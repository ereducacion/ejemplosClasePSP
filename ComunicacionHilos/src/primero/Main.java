package primero;

public class Main {
	public static void main(String[] args) {
		Contador cont = new Contador(100);
		HiloA a = new HiloA("HiloA", cont);
		HiloB b = new HiloB("HiloB", cont);
		a.start();
		b.start();
		
		try {
			a.join();
			b.join();
			System.out.println("ME quedo a esperar que terminen");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Main contador vale " + cont.getValor());
	}
}
