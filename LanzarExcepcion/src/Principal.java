
public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Persona juan = new Persona();
		juan.setNombre("Juan");
		try {
			juan.setEdad(-1);
		} catch (RuntimeException e) {
			System.out.println("Ha habido una excepcion y sigo...");
			System.out.println("La excepción dice..." + e.getMessage());
		}
		
		
		System.out.println("juan tiene " + juan.getedad());
	}

}
