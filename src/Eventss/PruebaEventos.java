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
		LaminaBotones miLamina = new LaminaBotones();
		add(miLamina);
	}
}

class LaminaBotones extends JPanel implements ActionListener {

	JButton blue = new JButton("blue");
	JButton red = new JButton("red");
	JButton yellow = new JButton("yellow");

	public LaminaBotones() {
		add(blue);
		add(yellow);
		add(red);
		blue.addActionListener(this);
		red.addActionListener(this);
		yellow.addActionListener(this);
		// addEventListener("click", ... ) in js
		// blue is the source of the action, the element that triggers the event
		// this is the
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		JButton incomingEvent = (JButton) e.getSource();
		String eventValue = incomingEvent.getText();
		
		if("red".equals(eventValue)) setBackground(Color.red);
		if("blue".equals(eventValue)) setBackground(Color.blue);
		if("yellow".equals(eventValue)) setBackground(Color.yellow);
	}

}
