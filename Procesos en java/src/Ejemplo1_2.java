import java.io.*;

public class Ejemplo1_2 {    

	public static void main(String[] args)  {
		Runtime r = Runtime.getRuntime();    
		String comando= "CMD /C DIR" ;
		Process p=null;
		
		try {
			p = r.exec( comando );
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
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