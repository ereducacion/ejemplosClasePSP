package segundo;

public class Main {
	public static void main(String[] args) {
		Contador2 cont = new Contador2(100);
		HiloA a = new HiloA("HiloA", cont);
		HiloB b = new HiloB("HiloB", cont);
		a.start();
		b.start();
		
//		try {
//			a.join();
//			b.join();
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
}