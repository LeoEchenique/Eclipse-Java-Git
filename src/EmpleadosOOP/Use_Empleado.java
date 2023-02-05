package EmpleadosOOP;

import java.util.Scanner;

public class Use_Empleado {

	public static void main(String[] args) {

		Empleado[] empleados = { new Empleado("leo", 100000, 18, 02, 2023), new Empleado("juan", 97000, 20, 04, 2021),
				new Empleado("mario", 165000, 1, 05, 2020) };
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
		Empleado[] polimorphEmpleados = new Empleado[empleados.length + 1]; // instance of a new Array that will copy
																			// the empleados array defined above
		System.arraycopy(empleados, 0, polimorphEmpleados, 0, empleados.length); // copy the array in polimorphEmpleados
		Personal manuel = new Personal("Manuel", "music", 10, "nice guy");
		polimorphEmpleados[empleados.length] = manuel; // Adds new instance in the array polimorphEmpleados

		for (Empleado e : empleados) {	
			System.out.println(e.getInfo());			// polymorphism, MANUEL is define as Personal class, but inherits the class of Empleado so is allowed to be in the array of type Empleado
		}

		// System.out.println(manuel.getInfo()); // parentClass method provided by
		// herency
		// System.out.println(manuel.getPersonal() + " " + manuel.aumentarSueldo(50));
		// // aumentarSueldo() has been overrided from the child class
		// System.out.println(manuel.aumentarSueldo(20));
	}
}
