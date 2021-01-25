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
	 * Hilo que a�ade al buffer circular los n�meros, es decir, est�
	 * PRODUCIENDO DATOS
	 */
	public void run() {
		Random aleat = new Random();
		try {
			sleep(aleat.nextInt(2)*1000); // espera un tiempo aletorio
			synchronized (mibufferCircular) {
				//a�ado un entero
				while (mibufferCircular.full()) {
					System.err.println("No puedo producir m�s, esperar� " + this.getName());
					mibufferCircular.wait();
				}; 
				System.err.println("a�ado " + datoInsertar + " soy " + this.getName());
				mibufferCircular.add(datoInsertar);
				mibufferCircular.notifyAll(); // notifico que hay dato
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
