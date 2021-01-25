package socketsData;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorData {

	public static void main(String[] args) {
		int puerto = 6000;
		
		try {
			ServerSocket miServidor = new ServerSocket(puerto);
			System.out.println("SERVIDOR: Escuchando por el puerto " + puerto);
			miServidor.setSoTimeout(0);
			Socket cliente = miServidor.accept();
			System.out.println("se ha conectado, esperando entrada Cliente");
			
			// Para leer lo que llegue por el nuevo socket
			InputStream lecturaSocket = cliente.getInputStream();
			DataInputStream leeCliente = new DataInputStream(lecturaSocket);
			
			String linea = leeCliente.readUTF();
			System.out.println("He leido =>" + linea);
			 
			// preparo el sitio donde escribiré en el socket
			OutputStream paraescribir = cliente.getOutputStream();
			DataOutputStream escribe = new DataOutputStream(paraescribir);
			escribe.writeUTF("Hola Cliente!!");

			// cierro todos los recursos
			leeCliente.close();
			escribe.close();
			miServidor.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
