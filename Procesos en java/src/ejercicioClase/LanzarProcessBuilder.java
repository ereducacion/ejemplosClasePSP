package ejercicioClase;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class LanzarProcessBuilder {

	/**
	 * Lanza un comando que se especifica dentro del código
	 * 
	 * @param args
	 */
	public static void main(String[] args)  {

		String comando[] = {"java", "-cp", "bin", "ejercicioClase.Leer"};

		ProcessBuilder pb = new ProcessBuilder(comando);
		try {
			// Creo el constructor de procesos

						
			// Lanzo el proceso
			Process p = pb.start();

			OutputStream os = p.getOutputStream();
			BufferedWriter bw = new BufferedWriter (new OutputStreamWriter(os));                      

			// Escribo lo que está esperando por System.in
			bw.write("una linea\n otra línea\n tercera línea\n *\n");

			bw.close();
			


			// haré que la salida salga por esta consola
			InputStream is = p.getInputStream();
			BufferedReader br = new BufferedReader (new InputStreamReader (is));                      
			String linea;
			while((linea = br.readLine())!=null) {
				System.out.println("Soy \"lanzar\"-->" + linea);
			}
			br.close();
			System.out.println("FIN de lanzar");

		} catch (Exception e) {
			System.err.println("Se ha producido un error!");
			System.err.println(e.toString());

		}
	}


}
