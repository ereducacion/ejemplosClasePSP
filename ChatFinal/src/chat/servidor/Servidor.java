package chat.servidor;

import java.awt.BorderLayout;
import java.awt.Component;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.util.Properties;

import javax.swing.JFrame;

import util.CapturePanel;
import util.Consumer;
import util.ProxyPrintStream;
import util.StreamCapturer;

public class Servidor {

	private static final String PROPERTIES_FILE = "src/config/datos.properties";
	
	/**
	 * Muestra en pantalla un panel con un área de texto que mostrará la salida indicada (out o err)
	 * @param textAreaServidor
	 * @param frame
	 * @param alto
	 * @param ancho
	 */
	public static void cargaPanel(Consumer textAreaServidor, JFrame frame, int alto, int ancho) {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		frame.add((Component) textAreaServidor);
		frame.setSize(ancho, alto);
		frame.setLocationRelativeTo(null);
		frame.setTitle("SERVIDOR");
		frame.setVisible(true);

	}
	public static void main(String[] args) {
	
		Properties properties = new Properties();
		Consumer textAreaServidor = new CapturePanel(); // area de texto que meteremos en una ventana
		JFrame frame = new JFrame(); // ventana que contendrá el texto

		DatagramSocket socket= null;
		try {
			
		    properties.load(new BufferedReader(new FileReader(PROPERTIES_FILE)));
		    int puertoEscucha = Integer.valueOf(properties.getProperty("puertoEscucha"));
		    int tamagnoBufferPkt = Integer.valueOf(properties.getProperty("tamagnoBufferPkt"));
		    String ipServidor = properties.getProperty("ipServidor");

		    // preparo el panel de salida de mensajes---------
			System.setOut(new PrintStream(new StreamCapturer("STDOUT", textAreaServidor, System.out)));
			cargaPanel(textAreaServidor, frame, 200, 500);
			// guardaré la salida de error en un fichero de log
			System.setErr(new ProxyPrintStream(System.err, "stderr.log"));
			//------------------------------------------------
		    
			InetAddress origen = Inet4Address.getByName(ipServidor);

			socket = new DatagramSocket(puertoEscucha, origen);
			System.out.println("SERVIDOR:");
			System.out.println("\tEscucho por: " + puertoEscucha + " y la ip " + origen.getHostAddress());

			// recibir un paquete
			byte[] bufferTemporal = new byte[tamagnoBufferPkt];
			DatagramPacket paqueteRecibido = new DatagramPacket(bufferTemporal, bufferTemporal.length);
			System.out.println("Esperando datagrama.....");
			
			socket.receive(paqueteRecibido);
			
			System.out.println("<---RECIBIDO:" + paqueteToString(paqueteRecibido));			 
				
			// construyo un Datagrama para enviar al cliente un mensaje
			// SE QUE PODRÉ ENVIARLE LA INFORMACIÓN PORQUE EN EL PAQUETE ME HA LLEGADO
			// INFORMACIÓN DE CUAL ES EL CANAL POR EL QUE ENVIARLE LOS DATOS
			String mensaje = "un saludo desde el servidor!";
			DatagramPacket paqueteEnviado = new DatagramPacket(mensaje.getBytes(), mensaje.length(), paqueteRecibido.getAddress(), paqueteRecibido.getPort());
			socket.send(paqueteEnviado);			
			System.out.println("ENVIADO-->:" + paqueteToString(paqueteEnviado));
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (socket != null) {
				socket.close();
			}
		}
		
		// cierro la ventana!!!
		frame.dispose();
	}
	
	public static String paqueteToString (DatagramPacket paquete) {
		 return ("|" + new String(paquete.getData(), 0, paquete.getLength()) + "|" + paquete.getLength() + "|" + 
				 paquete.getAddress().getHostAddress() + "|" + paquete.getPort() + "|");
	}
}
