package segundo;

public class HiloA extends Thread {
	private Contador2 contador;

	public HiloA(String n, Contador2 c) {
		setName(n);
		contador = c;
	}

	public void run() {
		synchronized (contador) {
			for (int j = 0; j < 300; j++) {
				contador.incrementa();
			}
			System.out.println(getName() + " contador vale " + contador.getValor());
		}

	}
}