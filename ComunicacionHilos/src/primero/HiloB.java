package primero;

public class HiloB extends Thread {
	private Contador contador;

	public HiloB(String n, Contador c) {
		this.setName(n);
		contador = c;
	}

	public void run() {
		for (int j = 0; j < 300; j++) {
			contador.incrementa();
//			try {
//				sleep(5);
//			} catch (InterruptedException e) {}
		}
		//System.out.println(getName() + " contador vale " + contador.getValor());
	}
}
