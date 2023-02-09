package Eventss;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class PruebaEventos {

	public static void main(String[] args) {

		MarcoBotones elMarco = new MarcoBotones();

		elMarco.setVisible(true);
		elMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

class MarcoBotones extends JFrame {

	public MarcoBotones() {
		setTitle("botones y eventos");
		setBounds(700, 300, 500, 300);
		//LaminaBotones miLamina = new LaminaBotones();
		add(new LaminaBotones());
	}
}

class LaminaBotones extends JPanel  {

	JButton blue = new JButton("blue");
	JButton red = new JButton("red");
	JButton yellow = new JButton("yellow");

	public LaminaBotones() {
		
		add(blue);
		add(yellow);
		add(red);
		
		/*
		BackGround rojo= new BackGround(Color.red);
		BackGround amarillo= new BackGround(Color.yellow);			// we can put the creation of the instance inside the addActionListener, because BackGround implements the actionPerformed method needed by the addActionListener
		BackGround azul= new BackGround(Color.blue);
		*/
		blue.addActionListener(new BackGround(Color.blue));
		red.addActionListener(new BackGround(Color.red));
		yellow.addActionListener( new BackGround(Color.yellow));
		
		// addEventListener("click", ... ) in js
		// blue is the source of the action, the element that triggers the event
		// this is the
	}


	private class BackGround implements ActionListener {

		private Color color;

		public BackGround(Color c) {
			color= c;
		}

		@Override
		public void actionPerformed(ActionEvent e) {

			setBackground(color);
		
		}
	}

}

