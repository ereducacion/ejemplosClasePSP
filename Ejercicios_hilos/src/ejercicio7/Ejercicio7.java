package ejercicio7;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Implemente un programa que escriba un “hola mundo” por cada hilo de ejecución que se
 * cree (seis es un número razonable) y que además indique desde que hilo se imprime. Luego
 * haga que cada uno espere un tiempo proporcional a su identificador antes de imprimir el
 * mensaje (el thread 1, un segundo, el 2, dos segundos, el 3, tres segundos,…). Lance los
 * threads mediante la clase Thread y luego mediante el interfaz Runnable ¿Qué diferencias
 * aprecia?
 * @author departamento
 *
 */
public class Ejercicio7 {

	public static void main(String[] args) {
		
		
		ArrayList<Thread> hilos =  new ArrayList<Thread>();
		// Ejecutar el hilo que extiende de Runnable
		for (int i = 1; i < 7; i++) {
			HiloRunnable hr = new HiloRunnable(i);
			Thread hs = new Thread(hr);
			hilos.add(hs);
			hs.start();
		}
		
		for (Thread mihilo : hilos) {
			try {
				mihilo.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		System.out.println("FIN DE LA EJECUCIÓN ejercicio1");
	}

}
