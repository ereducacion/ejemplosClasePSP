package ejercicio;

import java.util.ArrayList;
import java.util.Random;

public class Main {
	
	// DEFINO MIS CONSTANTES
	private static final int TEMPERATURAMIN = -30;
	private static final int TEMPERATURAMAX = 50;
	private static final int DIAS = 3650;
	private static final int NUMHILOS = 10;
	//----------------------

	public static void main(String[] args) {
		
		//para calcular cuanto dura la ejecución del programa
		long inicio = System.currentTimeMillis();
                 
        		
		// crea las temperaturas imaginarias de NUMHILOS años
		int vectortemperaturas[] = new int[DIAS];
		Random azar = new Random();
		for (int i = 0; i < vectortemperaturas.length; i++) {
			vectortemperaturas[i] = TEMPERATURAMIN + azar.nextInt(Math.abs(TEMPERATURAMIN) + TEMPERATURAMAX);
			//System.out.print(vectortemperaturas[i] + " ");
		}
		System.out.println();
		//----------------------------------------------------
		
		// creo el objeto donde guardaré la temperatura final
		TemperaturaFinal t = new TemperaturaFinal(TEMPERATURAMIN);
		
		// crea los hilo que trabajarán con un subconjunto
		ArrayList<HiloTemperatura> loshilos = new ArrayList<HiloTemperatura>();
		int cantidadComponenes = DIAS/NUMHILOS; 
		// tener en cuenta los restos
		int resto = DIAS%NUMHILOS;
		int posini = 0;
		for (int i = 0; i < NUMHILOS; i++) {
			loshilos.add(new HiloTemperatura(vectortemperaturas, posini, posini + cantidadComponenes, t));
			posini = posini + cantidadComponenes;
		}
		if (resto > 0) {
			// añado un hilo más para que calcule el resto
			loshilos.add(new HiloTemperatura(vectortemperaturas, posini, posini + resto, t));
		}
		
		// lanza los hilos
		for (int i = 0; i < NUMHILOS; i++) {
			loshilos.get(i).start();
		}
		
		// espero a que los hilos calculen la temp máxima
		for (HiloTemperatura hiloTemperatura : loshilos) {
			try {
				hiloTemperatura.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		// obtengo la temperatura maxima total
		System.out.println("LA TEMPERATURA MÁXIMA TOTAL ES " + t.getTemperaturaFinal());
		   
		System.out.println("Duracion en milisegundos:" + (double)((System.currentTimeMillis() - inicio)));
		
	}

}
