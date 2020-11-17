package ejercicioClase;


import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Leer {

	/**
	 * Leer por la líena de comandos hastas que se encuentre un *
	 * 
	 * @param args
	 */
	public static void main(String[] args)  {

		// creo un buffer para leer lo que entra por la líena de comandos
		BufferedReader brEntrada = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			// lee líneas de la entrada estandar
			int i = 0;
			String lineaEntrada = brEntrada.readLine();
			while (!lineaEntrada.equals("*")) {
				System.out.println("Soy \"leer\":" + lineaEntrada);
				lineaEntrada = brEntrada.readLine();
				i++;
			}
			
			System.out.println("HE TERMINADO DE LEER " + i + " líneas");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
