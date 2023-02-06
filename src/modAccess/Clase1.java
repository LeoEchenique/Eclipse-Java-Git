package modAccess;

public class Clase1 {

	
	protected int num= 5;							// no constructor: default mod access.
	private int num2= 7;						
	
	
	String myMethod() {
		return "Var num es: " + num;
	}
	
}
