package socketsStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;


public class ServidorStream {

	public static void main(String[] args) {
		int puerto = 6000;
		
		try {
			ServerSocket miServidor = new ServerSocket(puerto);
			System.out.println("SERVIDOR: Escuchando por el puerto " + puerto);
			miServidor.setSoTimeout(0);
			
			// ESPERO AL CLIENTE.......
			Socket cliente = miServidor.accept();
			System.out.println("se ha conectado, esperando entrada Cliente");
			
			// Para leer lo que llegue por el nuevo socket
			InputStream lecturaSocket = cliente.getInputStream();
			InputStreamReader lector = new InputStreamReader(lecturaSocket);
			BufferedReader leeCliente = new BufferedReader(lector);
			
			String linea = leeCliente.readLine();
			System.out.println("He leido =>" + linea);
			 
			// preparo el sitio donde escribiré en el socket
			OutputStream paraescribir = cliente.getOutputStream();
			OutputStreamWriter escritor = new OutputStreamWriter(paraescribir);
			BufferedWriter escribe = new BufferedWriter(escritor);

			escribe.write("Hola Cliente!!");
			escribe.newLine();
			escribe.flush();

			// cierro todos los recursos
			leeCliente.close();
			escribe.close();
			miServidor.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
