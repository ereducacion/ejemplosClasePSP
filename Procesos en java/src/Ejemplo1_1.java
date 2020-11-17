import java.io.IOException;

/**
 * Lanza un proceso en Java, concretamente abre el programa Notepad
 * @author Eva Royo
 *
 */
public class Ejemplo1_1 {
	public static void main(String[] args)  {
     Runtime r = Runtime.getRuntime();
     String comando= "Notepad" ;
	 
	 Process p;
	 try {
		p = r.exec( comando );
		p.waitFor();
		System.out.println("Terminé!!");
	 } catch (IOException e) {	 
	     System.out.println("Error en: "+comando );
	     e.printStackTrace();
	 } catch (InterruptedException e) {
		 System.out.println("He sido interrumpido");
		e.printStackTrace();
	}
	}
}//Ejemplo1
