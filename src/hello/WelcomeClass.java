package hello;

import java.util.Arrays; // importing a collection of the framework that makes possible to show an array on the console
							// Arrays.deepToString() -> This method is used when you have to two dimensional array. [[]]

public class WelcomeClass {

	public static void main(String[] args) {
		// public static void main -> method of a class. tells the compiler what code
		// must be run first
	
		//System.out.println("Hello wordl!");
		//System.out.println("Hello!");

		String[] nombres = { "maria", "Ernesto", "Nahuel", "Lucia" };
		for (int i = 0; i < nombres.length; i++) {
			holaNombre(nombres[i]);
		}
		// System.out.println(nombres);
		System.out.println(Arrays.toString(nombres));
		
	}
	
	public static void holaNombre(String nombre) {
		System.out.println("Hola " + nombre);
	}
}
