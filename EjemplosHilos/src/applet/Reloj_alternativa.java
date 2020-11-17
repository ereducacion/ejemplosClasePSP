package applet;

import java.applet.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.*;

@SuppressWarnings({ "serial" })
public class Reloj_alternativa extends Applet implements Runnable {
	private Thread hilo = null; // hilo
	private Font fuente; // tipo de letra para la hora

	/**
	 * En esta variable vamos a guardar la hora que irá actualizandose cada segundo
	 */
	private String horaActual = "";

	/**
	 * Se ejecuta cuando se crea el applet
	 */
	public void init() {
		fuente = new Font("Verdana", Font.BOLD, 26);
	}

	/**
	 * Se ejecuta cuando se inicia el applet (o se visita una página web)
	 */
	public void start() {
		if (hilo == null) {
			hilo = new Thread(this);
		//	System.out.println("entro aqui");
			hilo.setName("relojito!");
			hilo.start();
		}
	}

	/**
	 * Se ejecuta cuando se da la orden "repaint()"
	 */
	public void paint(Graphics g) {
		g.clearRect(1, 1, getSize().width, getSize().height);
		setBackground(Color.yellow);// color de fondo
		g.setFont(fuente);// fuente
		g.drawString(horaActual, 20, 50);// muestra la hora
	}

	/**
	 * Se ejecuta justo antes de parar el applet (o de salir de la página web)
	 */
	public void stop() {
		hilo.interrupt();
	}

	/**
	 * Contenido de lo que va a hacer el hilo que creemos
	 */
	public void run() {

		while (!hilo.isInterrupted()) {
			SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
			Calendar cal = Calendar.getInstance();
			horaActual = sdf.format(cal.getTime());
			repaint();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}
		}
	}

}
