import java.util.Random;

public class ProduceDatos extends Thread {

	/** buffer circular que compare y va a sincronizar **/
	BufferCircular mibufferCircular = new BufferCircular(4);
	private int datoInsertar; 
	
	public ProduceDatos(BufferCircular q, int dato) {
		mibufferCircular = q;
		datoInsertar = dato;
	}
	
	/**
	 * Hilo que añade al buffer circular los números, es decir, está
	 * PRODUCIENDO DATOS
	 */
	public void run() {
		Random aleat = new Random();
		try {
			sleep(aleat.nextInt(2)*1000); // espera un tiempo aletorio
			synchronized (mibufferCircular) {
				//añado un entero
				while (mibufferCircular.full()) {
					System.err.println("No puedo producir más, esperaré " + this.getName());
					mibufferCircular.wait();
				}; 
				System.err.println("añado " + datoInsertar + " soy " + this.getName());
				mibufferCircular.add(datoInsertar);
				mibufferCircular.notifyAll(); // notifico que hay dato
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
