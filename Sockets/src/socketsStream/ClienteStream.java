package socketsStream;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClienteStream {
	
	public static void main(String[] args) {
		String host = "localhost";
		int puerto = 6000;
		
		// creamos el socket
		try {
			Socket misocket = new Socket(host, puerto);
		
		// preparo el sitio donde leo del socket
			InputStream lecturaSocket = misocket.getInputStream();
			InputStreamReader lector = new InputStreamReader(lecturaSocket);
			BufferedReader leerDesdeCliente = new BufferedReader(lector);
		
		// preparo el sitio donde escribiré en el socket
			OutputStream escrituraSocket = misocket.getOutputStream();
			OutputStreamWriter escritor = new OutputStreamWriter(escrituraSocket);
			BufferedWriter escribirAlServidor = new BufferedWriter(escritor);
		
		// envío algo al servidor
			escribirAlServidor.write("Hola Servidor!!");
			escribirAlServidor.newLine();
			escribirAlServidor.flush();
			
		// leo lo que el servidor responde
			System.out.println("He leido del servidor=>" + leerDesdeCliente.readLine());

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
