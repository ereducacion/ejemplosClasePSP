package ejercicio8.solucion2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.Vector;

public class HiloSimple2 extends Thread { 

	public File fichero;
	private Vector<File> losFicheros = null;
	private int lineasFichero =0;
	
	public HiloSimple2 (Vector<File> ficheros) {
		this.losFicheros = ficheros;
	}
	
	public void run() {
		for (int i = 0; i < losFicheros.size(); i++) {
			lineasFichero = 0;
			fichero = losFicheros.get(i);
			// cuenta las linea de file
			FileReader fr;
			try {
				fr = new FileReader(fichero);
				BufferedReader br = new BufferedReader(fr);	
				while (br.readLine() != null) {
					lineasFichero++;
				};
			} catch (FileNotFoundException e) {
				System.out.println("Error de fichero no encontrado");
				e.printStackTrace();
			} catch (IOException e) {
				System.out.println("Excepción de entrada salida");
				e.printStackTrace();
			}
			// lineas del fichero actual
			System.out.println("las lineas del fichero " + fichero.getName() + " son " + lineasFichero);

			// acumulo las líneas en la variable de la clase que ha llamado al hilo, y contiene el mail
			UsaHilo2.total = UsaHilo2.total + lineasFichero;
		}
		
		
	}
}

