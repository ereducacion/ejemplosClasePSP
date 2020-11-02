package cuentascorrientes;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Cuentacorriente caixa = new Cuentacorriente();
		caixa.ingresar(100);
		try {
			caixa.extraer(200);
		} catch (ArithmeticException e) {
			System.out.println("Error aritmético");
		} catch (RuntimeException e) {
			System.out.println("ERRRORRRR!!! cantidad sobrepasado");
		} catch (Exception e) {
			
		}
		
		System.out.println("Termina el programa");

	}

}
