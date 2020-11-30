package ejercicio8.solucion2;

import java.io.File;
import java.util.Vector;

public class UsaHilo2 {
	
	public static int total;
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
		HiloSimple2 hs = new HiloSimple2(ficherosPares);
		HiloSimple2 hs2 = new HiloSimple2(ficherosImpares);
		
		hs.start();
		hs2.start();
		
		// espero a que terminen los hilos
		try {
			hs.join();
			hs2.join();
		} catch (InterruptedException e) {
			System.out.println("Se ha producido un error esperando a mis hijos");
			e.printStackTrace();
		}

		System.out.println("En total hay... " + total);
		
		// lanzar los hilos con los ficheros impares
	}
}
