package eventListener;

import java.awt.event.*;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.Timer;

public class Temporizador {

	public static void main(String[] args) {
		
		Hora listener=  new Hora();	// this class implementes ActionListener in order to pass a event and execute inside the miTemp
		Timer miTemp= new Timer(3000, listener);
		miTemp.start();  // read start method description, it just starts the timer
		JOptionPane.showConfirmDialog(null, "Aceptar para dejar de ejecutar");
		System.exit(0);
	}

}

// All classes that execute Events needs to implement the interface ActionListener to ensure that this interface (that needs to override the actionPerformed method) is constructed properly based on the class that dispatch some action

class Hora implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) { // actionPermormed always needs to be overrided if an events executes an action.

		Date now= new Date();
		System.out.println("La hora es: " + now);
		
	}
	
	
}
