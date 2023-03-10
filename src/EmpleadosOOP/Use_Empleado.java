package EmpleadosOOP;

import java.util.Arrays;
import java.util.Scanner;

public class Use_Empleado {

	public static void main(String[] args) {

		Empleado[] empleados = { new Empleado("leo", 10, 18, 02, 2023), new Empleado("juan", 97000, 20, 04, 2021),
				new Empleado("mario", 165000, 1, 05, 2020), new Jefe("leito") };
		
		
		///////////////////////////////////////////////////////  Program basic, handle instance in a for iteration
		/*
		 * for (Empleado e : empleados) {
		 * System.out.println("How much is the raise? This employee currently has $" +
		 * e.getSueldo() + " of money"); String input = scanner.nextLine(); int number =
		 * Integer.parseInt(input); e.aumentarSueldo(number);
		 * System.out.println(e.getInfo().toUpperCase()); } scanner.close();
		 * System.out.println("\n Cascade execution, fullList below! \n"); for (Empleado
		 * e : empleados) { System.out.println(e.getInfo()); }
		 * System.out.println(Empleado.getStaticProp()); // static method, in cursive,
		 * gets the static prop of the nextId that will be generate for a employee.
		 * 
		 * Empleado nestor = new Empleado("Néstor");
		 * 
		 * System.out.println(nestor.getInfo());
		 */
		
		
		//////////////////////////////////////////////////////////////  Herency, Pholymorphism
		
		
		Empleado[] polimorphEmpleados = new Empleado[empleados.length + 1]; // instance of a new Array that will copy
																			// the empleados array defined above
		System.arraycopy(empleados, 0, polimorphEmpleados, 0, empleados.length); // copy the array in polimorphEmpleados
		//Personal manuel = new Personal("Manuel", "music", 10, "nice guy");
		//polimorphEmpleados[empleados.length] = manuel; // Adds new instance in the array polimorphEmpleados
		// Substutle principle.
		//same as:
		polimorphEmpleados[empleados.length] = new Personal("Manuel", "music", 10, "nice guy"); // polimorphEmpleados has a type of Empleado[] the parent class of Personal
		
		for (Empleado e : polimorphEmpleados) {	
	//		System.out.println(e.getInfo());			// polymorphism, MANUEL is define as Personal class, but inherits the class of Empleado so is allowed to be in the array of type Empleado
		//	System.out.println(e.getClass());
		}
		
		
		
		////////////////////////////////////////////////////////////// Method Override	& Herency	
	/*
		for (Empleado e : polimorphEmpleados) {	
			System.out.println(e.aumentarSueldo(100)); // aumentarSueldo has been overrided by the child class who inherits all the props of Empleado, So in the ireation when it comes Manuel
		}// "Dynamic linking" 						   // a "aumentarSueldo()" its called as the method of the Personal class, not the original method of Empleado so it will sum the extra money and not gives a raise for percentaje

		 System.out.println(manuel.getInfo()); // parentClass method provided by herency
			System.out.println(manuel.getPersonal() + " " + manuel.aumentarSueldo(50)); // aumentarSueldo() has been overrided from the child class
		 System.out.println(manuel.aumentarSueldo(20));
		
		
		// in the for iteration we cannot exec getPersonal method because correspond to the class personal
		// in the array polimorphEmpleados we cannot call getPersonal because it's of a type Empleado 
		// how can i initialize the getPersonal method for manuel? since he's a Personal class, although extended from Empleado
		//casting to Personal in a new assignment of personal type:
		
		
		Personal empleadoPersonal= (Personal) polimorphEmpleados[3];  // casting this instance as a personal and not as Empleado
		System.out.println("\n" + empleadoPersonal.getPersonal()); // calls class methods
		System.out.println("\n" + empleadoPersonal.getInfo());     // calls extended class methods (Empleado methods)
		*/
		
	
		////////////////////////////////////////////////////////////// Interface:  we want to sort the polimorphEmpleados array to asc order by salary	(Array.sort)
		/*
		Arrays.sort(polimorphEmpleados);	// Sorts the specified array of objects into ascending order, accordingto the natural ordering of its elements.
		//All elements in the array must implement the Comparableinterface. TO EMPLEADO FILE, THE INTERFACE IS IMPLEMENTED! no compile error.
		
		
		for (Empleado e : polimorphEmpleados) {	
			System.out.println(e.getInfo());			// polymorphism, MANUEL is define as Personal class, but inherits the class of Empleado so is allowed to be in the array of type Empleado
		} // now they're sorted by salary!
		*/
		
		
		/////////////////////////////////////////////////////////////////// Creating and assigning interfaces: 
		
		Jefe jefeson= new Jefe("argentino");  // another class that heredates from Empleado AND implements an Interface method called getAllEmployees
		
		jefeson.getAllEmployes(polimorphEmpleados);  // as an interface, this method is implemented dinamically acording the class who is using it, in this case, the boss wants to know ho are the employees
		Empleado esteban= new Empleado("Esteban");
		esteban.getAllEmployes(polimorphEmpleados); // as an interface, this method is implemented dinamically acording to the class who is using it, in this case, the employees wanna know who are/is the bosses.
		
	}
}
