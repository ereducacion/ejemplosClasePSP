/**
 * Implementa un esquema productor/consumidor. Es decir, habrá un thread que se dedicará a
crear datos y otro a consumirlos. Es un esquema bastante habitual de concurrencia, con uno
o varios threads creando datos y con uno o varios consumiendo dichos datos. En este caso
habrá sólo uno de cada. Además, por simplicidad, los datos a producir/consumir serán
enteros, empezando por el 1, luego el 2, el 3 y así sucesivamente hasta el 30. Cada thread
esperará un tiempo aleatorio entre datos (random), entre 0 y 2 segundos, para simular el
tiempo que tarda en producir/consumir cada dato. Utilice un buffer circular, con capacidad
para 4 datos, para pasar los datos entre los dos threads. Asegúrese de sincronizarlos
correctamente (wait/notify) para que el productor no meta datos en el buffer cuando este
esté lleno ni que el consumidor coja datos cuando este está vacío. Haga que el consumidor
imprima los datos una vez que los haya consumido (tras la espera) para ver que no se
pierde ninguno. Imprima también un mensaje cada vez que un thread tenga que esperar
porque el buffer esté lleno o vacío.
 * @author Eva Royo
 */
public class EjemploProductorConsumidor {

	public static void main(String[] args) {

		BufferCircular arraycircular = new BufferCircular(4);
		
		// durante 30 iteraciones crearemos un dato y lo consumiremos
		for (int i = 1; i <= 30; i++) {
			ProduceDatos p = new ProduceDatos(arraycircular, i);
			ConsumirDatos c = new ConsumirDatos(arraycircular);
			p.setName("productor" + i);
			c.setName("consumidor"+i);
			p.start();
			c.start();
		}
	}

}



