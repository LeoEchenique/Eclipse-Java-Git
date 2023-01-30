package hello;

import java.util.Scanner;

public class testingFn {
	
	
	static String[] nombres = { "maria", "Ernesto", "Nahuel", "Lucia" };
	
	
	public static void main(String[] args) {
		WelcomeClass welcome= new WelcomeClass();
		WelcomeClass.holaNombre("juan");
		welcome.holaClase();
		
		//Java has ternary! 
		Scanner scanner= new Scanner(System.in);
		System.out.println("type your text here: ");
		String input= scanner.nextLine();
		
		String showResult= input.length() > 6 ? "a long entry!" : "a short entry";
		scanner.close();
		System.out.print("you've typed " + showResult);
		
		
		
	}
}
