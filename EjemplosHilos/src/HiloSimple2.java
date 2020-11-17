
public class HiloSimple2 implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub

		for (int i = 0; i < 5; i++) {
			System.out.println("Estoy en el hilo..." + i);
		}
	}

//	public void run() {
//		for (int i = 0; i < 5; i++) {
//			System.out.println("Estoy en el hilo..." + i);
//		}
//	}

}
