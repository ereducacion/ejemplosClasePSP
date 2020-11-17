
public class UsaHilo3 extends Thread {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UsaHilo3 mihilo = new UsaHilo3();
		mihilo.start();

		for (int i = 0; i < 5; i++) {
			System.out.println("Estoy fuera del hilo... " + i);
		}

	}

	public void run() {
		for (int i = 0; i < 5; i++) {
			System.out.println("Estoy en el hilo..." + i);
		}
	}
}
