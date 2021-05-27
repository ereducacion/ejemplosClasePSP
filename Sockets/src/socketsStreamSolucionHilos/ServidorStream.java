package socketsStreamSolucionHilos;
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
			
			int contador = 1;
			// ESPERO AL CLIENTE.......
			for (int i = 1; i < 4; i++) {
				
				Socket cliente = miServidor.accept();
				System.out.println("se ha conectado, esperando entrada Cliente");
				
				HiloAtiendeSocket miHilo =  new HiloAtiendeSocket(cliente, contador);
				miHilo.start();
				contador ++;

			}
			
			miServidor.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
