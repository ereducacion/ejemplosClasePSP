package ejercicioClase;

import java.io.*;

/**
 * Clase para probar la escritura y lectura de los streams de un proceso
 * @author Eva Royo
 *
 */
public class LanzarRuntime {    
	
	
	public static void main(String[] args)  {
		Runtime r = Runtime.getRuntime();    
		String comando= "java -cp bin ejercicioClase.Leer";


		Process p = null;
		try {
			p = r.exec( comando );
		} catch (IOException e1) {
			// Si no puedo crear el proceso me voy del programa
			e1.printStackTrace();
			return;
		}

		// CONTROL DE LA ENTRADA EL PROCESO QUE ES LANZADO
		try {
			OutputStream StreamParaEscribirEnProceso = p.getOutputStream();
			BufferedWriter escribiendoEnProceso = new BufferedWriter (new OutputStreamWriter(StreamParaEscribirEnProceso));                      

			// Le digo cual es mi nombre...
			escribiendoEnProceso.write("unalinea\notralinea\n*");

			escribiendoEnProceso.close();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}



		//CONTROL DE LA SALIDA DEL PROCESO QUE ES LANZADO
		try {
			InputStream StreamParaLeerDelProceso = p.getInputStream();
			BufferedReader leyendoAlProceso = new BufferedReader (new InputStreamReader (StreamParaLeerDelProceso));                      
			String linea;
			while((linea = leyendoAlProceso.readLine())!=null) { 
				//escribe en la salida estandar lo que ha leido del proceso
				System.out.println(linea); 
			}
			leyendoAlProceso.close();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}

		// CONTROL DE LOS MENSAJES DE ERROR
		try {
			InputStream StreamErrorDelProceso = p.getErrorStream();					
			BufferedReader leyendoErrorAlProceso = new BufferedReader(new InputStreamReader(StreamErrorDelProceso));
			String liner = null;
			while ((liner = leyendoErrorAlProceso.readLine()) != null) {
				System.err.println("ERROR >" + liner);
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}

		// COMPROBACION DE ERROR:  0 indica que ha terminado bien
		int exitVal;
		try {
			exitVal = p.waitFor();
			System.out.println("Valor de Salida: " + exitVal);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} 
	}
}//Ejemplo2