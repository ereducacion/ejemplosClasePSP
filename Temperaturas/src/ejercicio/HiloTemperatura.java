package ejercicio;

public class HiloTemperatura extends Thread{

	int[] vectorTemporal;
	private int posini;
	private int posfin;
	TemperaturaFinal temp;
	
	public HiloTemperatura(int[] vectortemperaturas, int posini, int posfin, TemperaturaFinal t) {
		vectorTemporal = vectortemperaturas;
		this.posini = posini;
		this.posfin = posfin;
		temp = t;
//		System.out.println(this.getName() + " " + posini + "-" + posfin);
	}

	public void run() {
		int tempMax = vectorTemporal[posini];
		for (int i = posini; i < posfin; i++) {
			if (vectorTemporal[i] > tempMax) {
				tempMax = vectorTemporal[i];
			}
		}
//		System.out.println(this.getName() + " la temperatura max es " + tempMax);
		temp.setTemperaturaFinal(tempMax);
	}
}
