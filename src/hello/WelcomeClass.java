package hello;

import java.util.Arrays; // importing a collection of the framework that makes possible to show an array on the console
							// Arrays.deepToString() -> This method is used when you have to two dimensional array. [[]]
import java.util.Scanner;

public class WelcomeClass {

	public static void main(String[] args) {
		// public static void main -> method of a class. tells the compiler what code
		// must be run first
		
		//System.out.println("Hello wordl!");
		//System.out.println("Hello!");
		Scanner scanner= new Scanner(System.in);
		System.out.println("type your text here: ");
		String input= scanner.nextLine();
		System.out.println("this is what you've typed: " + input);
		scanner.close();
		
		
		String[] nombres = { "maria", "Ernesto", "Nahuel", "Lucia", input};
		
		for (int i = 0; i < nombres.length; i++) {
			holaNombre(nombres[i]);
		}
		 System.out.println(Arrays.toString(nombres));
		 if(nombres.length > 3) System.out.println(nombres.length + " yei");
		 else System.out.println("not enough length");
		
	}
	
	
	public static void holaNombre(String nombre) {
		System.out.println("Hola " + nombre);
	}
	 
	
	protected void holaClase() {
		System.out.println("un hola protegido");
	}
}
