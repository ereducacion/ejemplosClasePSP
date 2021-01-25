package tercero;

public class Cuenta {
	private int saldo;

	Cuenta(int s) {
		saldo = s;
	}

	int getSaldo() {
		return saldo;
	}

	synchronized void restar(int cantidad) {
		saldo = saldo - cantidad;
	}

	/**
	 * Comprueba que el dinero que va a retirarse est� en la cuenta
	 * Si hay suficiente duerme 0,5 segundos y se lo resta a la cuenta
	 * Muestra el nombre de quien se ha llevado el dinero y de cuanto saldo queda
	 * Si no hay dinero suficiente muestra el mensaje
	 * Si el saldo es negativo muestra el mensaje
	 * 
	 * @param cant
	 * @param nom
	 */
	void RetirarDinero(int cant, String nom) {
		if (getSaldo() >= cant) {
			System.out.println("SE VA A RETIRAR SALDO (ACTUAL ES: " + getSaldo() + ")");
			try {
				Thread.sleep(500);
			} catch (InterruptedException ex) {
			}
			restar(cant);
			System.out.println(nom + " retira =>" + cant + " ACTUAL(" + getSaldo() + ")");
		} else {
			System.out.println(nom + " No puede retirar dinero, NO HAY SALDO(" + getSaldo() + ")");
		}
		if (getSaldo() < 0) {
			System.out.println("SALDO NEGATIVO => " + getSaldo());
		}
	}// retirar
}
