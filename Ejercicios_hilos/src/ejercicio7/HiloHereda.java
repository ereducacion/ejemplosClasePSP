package ejercicio7;

public class HiloHereda extends Thread {
	
	/**
	 * Indentificador del hilo
	 */
	private int identificador = 0;

	
	/**
	 * Crear un hilo con identificador
	 * @param i
	 */
	public HiloHereda(int i) {
		// TODO Auto-generated constructor stub
		this.identificador = i;
	}

	/**
	 * Donde defino lo que va a hacer le hilo
	 */
	public void run() {
		
		try {
			System.out.println("Soy el hilo:" + this.identificador + "empiezo..............");
			sleep(identificador*1000);
			System.out.println("Soy el hilo:" + this.identificador + "FIN----");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
