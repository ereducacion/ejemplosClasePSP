
public class Persona {

	String nombre;
	int edad;
	
	Persona () {
		
	}
	
	String getNombre() {
		return nombre;
	}
	int getedad() {
		return edad;
	}

	void setNombre(String nom) {
		nombre = nom;
	}
	void setEdad(int ed) throws RuntimeException {
		if (ed < 0) {
			throw new RuntimeException("La edad es negativa");
		}
		
		edad = ed;
		
	}

}
