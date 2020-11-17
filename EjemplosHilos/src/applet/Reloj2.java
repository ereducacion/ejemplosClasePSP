package applet;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.text.SimpleDateFormat;
import java.util.Calendar;

@SuppressWarnings("serial")

public class Reloj2 extends Applet {
	private Font fuente;
	private Thread hilo;
	private String horaActual;

	public void init() {
	}

	public void start() {
	}

	public void run() {
		Thread hiloActual = Thread.currentThread();
		while (hilo == hiloActual) {
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

	public void paint(Graphics g) {
//		g.clearRect(1, 1, getSize().width, getSize().height);
//		setBackground(Color.yellow);//color de fondo	    
//		g.setFont(fuente);//fuente
//		g.drawString(horaActual, 20, 50);//muestra la hora	
	}

	public void stop() {
		hilo = null;
	}
}
