package threads;

import java.awt.geom.*;

import javax.swing.*;

import java.util.*;
import java.awt.*;
import java.awt.event.*;

public class UsoThreads {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		JFrame marco = new MarcoRebote();

		marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		marco.setVisible(true);

	}

}

//Movimiento de la pelota-----------------------------------------------------------------------------------------

class Pelota {

	// Mueve la pelota invirtiendo posici�n si choca con l�mites

	public void mueve_pelota(Rectangle2D limites) {

		x += dx;

		y += dy;

		if (x < limites.getMinX()) {

			x = limites.getMinX();

			dx = -dx;
		}

		if (x + TAMX >= limites.getMaxX()) {

			x = limites.getMaxX() - TAMX;

			dx = -dx;
		}

		if (y < limites.getMinY()) {

			y = limites.getMinY();

			dy = -dy;
		}

		if (y + TAMY >= limites.getMaxY()) {

			y = limites.getMaxY() - TAMY;

			dy = -dy;

		}

	}

	// Forma de la pelota en su posici�n inicial

	public Ellipse2D getShape() {

		return new Ellipse2D.Double(x, y, TAMX, TAMY);

	}

	private static final int TAMX = 15;

	private static final int TAMY = 15;

	private double x = 0;

	private double y = 0;

	private double dx = 1;

	private double dy = 1;

}

// L�mina que dibuja las pelotas----------------------------------------------------------------------

class LaminaPelota extends JPanel {

	// A�adimos pelota a la l�mina

	public void add(Pelota b) {

		pelotas.add(b);
	}

	public void paintComponent(Graphics g) {

		super.paintComponent(g);

		Graphics2D g2 = (Graphics2D) g;
		
		for (Pelota b : pelotas) {
			g2.fill(b.getShape());
		}

	}

	private ArrayList<Pelota> pelotas = new ArrayList<Pelota>();
}

//Marco con l�mina y botones------------------------------------------------------------------------------

class MarcoRebote extends JFrame {

	public MarcoRebote() {

		setBounds(600, 300, 400, 350);

		setTitle("Rebotes");

		lamina = new LaminaPelota();

		add(lamina, BorderLayout.CENTER);

		JPanel laminaBotones = new JPanel();

		ponerBoton(laminaBotones, "Dale!", new ActionListener() {

			public void actionPerformed(ActionEvent evento) {

				comienza_el_juego_multiThread();
				// comienza_el_juego();
			}

		});

		ponerBoton(laminaBotones, "Salir", new ActionListener() {

			public void actionPerformed(ActionEvent evento) {

				System.exit(0);

			}

		});
		
		ponerBoton(laminaBotones, "Detener", new ActionListener() {

			public void actionPerformed(ActionEvent evento) {

				detener();

			}

		});


		add(laminaBotones, BorderLayout.SOUTH);
	}

	// Ponemos botones

	public void ponerBoton(Container c, String titulo, ActionListener oyente) {

		JButton boton = new JButton(titulo);

		c.add(boton);

		boton.addActionListener(oyente);

	}

	// implements runnable interface to make multi-thread operations:

	class PelotaThread implements Runnable { // only one method, we now are obligate to override the method

		private Pelota pelota;
		private Component component;

		public PelotaThread(Pelota ball, Component component) {
			this.pelota = ball;
			this.component = component;
		}

		@Override
		public void run() { // the funcionality of a given method in order to work on multi-Thread
			/* for (int i = 1; i <= 3000; i++) {

				pelota.mueve_pelota(component.getBounds());

				component.paint(component.getGraphics());

				try {
					Thread.sleep(5); 
				} catch (InterruptedException e) {
					e.printStackTrace();
				} 
					
			} */
			while(!Thread.interrupted()) {			// now threwad without sleep method can be interrupted
				pelota.mueve_pelota(component.getBounds());
				component.paint(component.getGraphics());
 
			}

		}

	}
	
	
	// A�ade pelota y la bota 1000 veces

	public void comienza_el_juego_multiThread() {

		Pelota pelota = new Pelota();

		lamina.add(pelota);
		
		Runnable run= new PelotaThread(pelota, lamina);
		
		// Thread newThread= new Thread(run);  // bad, with new method detener() we need to access this variable so we need to declared in the class and not inside the method
		
		newThread = new Thread(run);
		newThread.start();

	}
	
	public void detener() {
		newThread.interrupt();  // ---> InterruptedException: sleep interrupted error  -> doesnt stop the thread
		// when we interrupt the thread the LAST thread gets stopped. But why not the first one for example? 
		// Because in every new thread we generate a new instance of Thread but with the same name. to the THIS makes reference to the last one created
	}

	// A�ade pelota y la bota 1000 veces
/*
	public void comienza_el_juego() {

		Pelota pelota = new Pelota();

		lamina.add(pelota);

		for (int i = 1; i <= 3000; i++) {

			pelota.mueve_pelota(lamina.getBounds());

			lamina.paint(lamina.getGraphics());

			try {
				Thread.sleep(5); /// Thread.sleep to pause and watch more smooth the transition
			} catch (InterruptedException e) {
				e.printStackTrace();
			} // Wihout terminate the program pulsing the red cube, i cant exit the window,
				// because the for loop as no ended and the execuition thread is not over
		}
		// execution stack... // if i click on "dale" while the first iteration is not
		// over, when it ends it will start the second one. as MONOTASK thread cant
		// execute both operations

		// if i click on the X to close the program, this commands is on wait untill the
		// loop gets finished
	}
*/
	private LaminaPelota lamina;
	private Thread newThread;
}
