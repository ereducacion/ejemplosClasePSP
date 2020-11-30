package ejercicio8.solucion1;

import java.io.File;
import java.util.Vector;

public class UsaHilo {
	
	public static void main(String[] args) {
		
		//pedir los nombres de los ficheros
		File fichero1= new File("tmp1.txt");
		File fichero2= new File("tmp2.txt");
		File fichero3= new File("tmp3.txt");
		File fichero4= new File("tmp4.txt");
		
		Vector<File> ficherosPares = new Vector<File>();
		Vector<File> ficherosImpares = new Vector<File>();
		
		ficherosPares.add(fichero2);
		ficherosPares.add(fichero4);
		ficherosImpares.add(fichero1);
		ficherosImpares.add(fichero3);
		
		// lanzar los hilos con los ficheros pares
		HiloSimple hs = new HiloSimple(ficherosPares);
		HiloSimple hs2 = new HiloSimple(ficherosImpares);
		
		hs.start();
		hs2.start();
		
		// lanzar los hilos con los ficheros impares
	}
}
