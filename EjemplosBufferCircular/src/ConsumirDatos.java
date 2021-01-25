import java.util.Random;

public class ConsumirDatos extends Thread {

	/** buffer circular que compare y va a sincronizar **/
	BufferCircular mibufferCircular = new BufferCircular(4);
	
	public ConsumirDatos(BufferCircular q) {
		mibufferCircular = q;
	}
	
	/**
	 * Hilo que va a ir consumiendo los datos producidos en el buffer circular, 
	 * ES EL CONSUMIDOR DE ENTEROS
	 */
	public void run() {
		
		try {
			Random aleat = new Random();
			Integer res ;

			sleep(aleat.nextInt(2)*1000); // espero un tiempo aleatorio
			// como el buffer es compartido, sincronizo su acceso
			synchronized (mibufferCircular) {
				// poll es retirar un elemento del buffer circular
				while (mibufferCircular.empty()) {
					// es porque no hay datos --> me espero a que me avisen de que hay datos
					System.err.println("No puedo consumir más, voy a parar " + this.getName());
					mibufferCircular.wait();
				}
				res=mibufferCircular.poll();
				System.err.println("consumo " + res + " soy " + this.getName());
				mibufferCircular.notifyAll(); // notifico que he consumido un dato
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}