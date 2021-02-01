package datagram;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.Inet4Address;
import java.net.InetAddress;

public class Cliente {

	public static void main(String[] args) throws InterruptedException {
		
		int puertoServidorDestino = 6005;
		int tama�oBufferPkt = 1024;
	
		DatagramSocket socket = null;
		try {
			
			// PREPARO EL DESTINO
			InetAddress destino = Inet4Address.getByName("192.168.1.130");

			byte[] mensaje = new byte[tama�oBufferPkt];
			
			String mensajeStr = "Hola que tal?";
			mensaje = mensajeStr.getBytes();
			
			// construyo el datagrama que quiero enviar
			// creamos el Datagrama diciendo...
			// el mensaje en bytes // la longitud del mensaje // la m�quina de destino // el puerto de destino
			DatagramPacket paqueteEnv = new DatagramPacket(mensaje, mensaje.length, destino, puertoServidorDestino);
			
			socket = new DatagramSocket();
			System.out.println("CLIENTE:");
			System.out.println("\tEnvio por: " + socket.getLocalPort() + " y la ip " + Inet4Address.getLocalHost().getHostAddress() );
			System.out.println("ENVIANDO -->" + paqueteToString(paqueteEnv));

			socket.send(paqueteEnv);
			
			// SI QUIERO ESCUCHAR UNA RESPUESTA APROVECHO EL SOCKET QUE HE ABIERTO YO MISMA
			byte[] bufferTemporal = new byte[tama�oBufferPkt];
			DatagramPacket paqueteRecibido = new DatagramPacket(bufferTemporal, bufferTemporal.length);
			System.out.println("Esperando datagrama.....");
			
			socket.setSoTimeout(10);
			socket.receive(paqueteRecibido);
			System.out.println("IP origen:" + paqueteRecibido.getAddress().getHostAddress() + ";Puerto origen:" + paqueteRecibido.getPort());
			System.out.println("<---RECIBIDO:" + paqueteToString(paqueteRecibido));

			
		} catch (IOException e) {
			System.out.println("Error de entrada salida");
			e.printStackTrace();
		} finally {
			if (socket != null) {
				socket.close();			
			}
		}
	}
	
	public static String paqueteToString (DatagramPacket paquete) {
		 return ("|" + new String(paquete.getData(), 0, paquete.getLength()) + "|" + paquete.getLength() + "|" + 
				 paquete.getAddress().getHostAddress() + "|" + paquete.getPort() + "|");
	}
}
