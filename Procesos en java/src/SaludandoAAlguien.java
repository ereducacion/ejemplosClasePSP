

import java.util.Scanner;

public class SaludandoAAlguien {

	public static void main(String[] args) {

		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("Hola, como te llamas?");
			String nombre = sc.nextLine();
			System.out.println("ADIOSS " + nombre + ", soy un proceso nuevo!!");
		}
	}

}
