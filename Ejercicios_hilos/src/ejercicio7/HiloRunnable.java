package ejercicio7;


public class HiloRunnable implements Runnable {

	/**
	 * Indentificador del hilo
	 */
	private int identificador = 0;

	
	/**
	 * Crear un hilo con identificador
	 * @param i
	 */
	public HiloRunnable(int i) {
		// TODO Auto-generated constructor stub
		this.identificador = i;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		try {
			System.out.println("Soy el hilo:" + this.identificador + " empiezo..............");
			Thread.sleep(identificador*1000);
			System.out.println("Soy el hilo:" + this.identificador + "FIN----");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}


	
}
