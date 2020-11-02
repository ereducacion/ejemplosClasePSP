import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejemplo2 {

	public static void main(String[] args) {
		System.out.println("introduce un número entero!!!!!");
		Scanner sc = new Scanner(System.in);
		int numero = 0;
		boolean todoOk = true;
		while (todoOk) {
			try {
				numero = sc.nextInt();
				todoOk = false;
			} catch (InputMismatchException e1) {
				System.out.println("No estás introducioendo un entero");
			} 
		}
		System.out.println("fin de programa");
	}
}
