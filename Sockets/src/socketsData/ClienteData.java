package socketsData;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClienteData {
	
	public static void main(String[] args) {
		String host = "localhost";
		int puerto = 6000;
		
		// creamos el socket
		try {
			Socket misocket = new Socket(host, puerto);
		
		// preparo el sitio donde leo del socket
			InputStream lecturaSocket = misocket.getInputStream();
			DataInputStream leerDesdeCliente = new DataInputStream(lecturaSocket);
		
		// preparo el sitio donde escribiré en el socket
			OutputStream escrituraSocket = misocket.getOutputStream();
			DataOutputStream escribirAlServidor = new DataOutputStream(escrituraSocket);
		
		// envío algo al servidor
			escribirAlServidor.writeUTF("Hola Servidor!!");
			escribirAlServidor.flush();
			
		// leo lo que el servidor responde
			System.out.println("He leido del servidor=>" + leerDesdeCliente.readUTF());

			// cerrar todos los streams y sockets
			leerDesdeCliente.close();
			escribirAlServidor.close();
			misocket.close();
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}
