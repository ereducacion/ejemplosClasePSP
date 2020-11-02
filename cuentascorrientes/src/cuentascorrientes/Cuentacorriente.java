package cuentascorrientes;


public class Cuentacorriente {

	int saldo =0;
	
	public Cuentacorriente () {
		
	}
	
	public void ingresar (int cantidad)  {
		saldo = saldo + cantidad;
				
	}

	public void extraer (int cantidad) throws RuntimeException, ArithmeticException {
		if (saldo < cantidad) {
			// lance una excepcion
			throw new RuntimeException("Cantidad supera al saldo");
		}
		if (cantidad < 0) {
			throw new ArithmeticException("Cantidad negativa");
		}
		saldo = saldo - cantidad;
	}
}
