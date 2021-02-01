package ejercicio;

public class TemperaturaFinal {

	private int temperaturaFinal;

	public TemperaturaFinal(int temperaturaFinal) {
		super();
		this.temperaturaFinal = temperaturaFinal;
	}

	public int getTemperaturaFinal() {
		return temperaturaFinal;
	}

	public synchronized void setTemperaturaFinal(int temperaturaFinal) {
		if (this.temperaturaFinal < temperaturaFinal)
			this.temperaturaFinal = temperaturaFinal;
	}
	
	
}
