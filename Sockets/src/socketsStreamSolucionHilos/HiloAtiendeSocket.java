package socketsStreamSolucionHilos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class HiloAtiendeSocket extends Thread{

	Socket elsocket;
	int micontador;
	
	public HiloAtiendeSocket(Socket cliente, int contador) {
		elsocket = cliente;
		micontador = contador;
	}

	public void run() {
		try {
			// Para leer lo que llegue por el nuevo socket
			InputStream lecturaSocket = elsocket.getInputStream();
			InputStreamReader lector = new InputStreamReader(lecturaSocket);
			BufferedReader leeCliente = new BufferedReader(lector);
			
			// preparo el sitio donde escribiré en el socket
			OutputStream paraescribir = elsocket.getOutputStream();
			OutputStreamWriter escritor = new OutputStreamWriter(paraescribir);
			BufferedWriter escribe = new BufferedWriter(escritor);
	
			escribe.write("Eres el cliente num " + micontador );
			escribe.newLine();
			escribe.flush();
			
			String linea = leeCliente.readLine();
			System.out.println("el cliente me dice " + linea);
						
			// cierro todos los recursos
			leeCliente.close();
			escribe.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
