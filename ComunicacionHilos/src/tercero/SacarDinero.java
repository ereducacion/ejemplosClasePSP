package tercero;

public class SacarDinero extends Thread {
	private Cuenta c;

	public SacarDinero(String n, Cuenta c) {
		super(n);
		this.c = c;
	}

	public void run() {
		for (int x = 1; x <= 4; x++) {
			c.RetirarDinero(10, getName());
		}
	}// run
}
