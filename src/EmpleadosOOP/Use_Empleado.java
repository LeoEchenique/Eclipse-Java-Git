package EmpleadosOOP;

import java.util.Scanner;

public class Use_Empleado {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Empleado[] empleados= {new Empleado("leo", 100000, 18, 02, 2023), new Empleado("juan", 97000, 20, 04, 2021), new Empleado("mario", 165000, 1, 05, 2020)};
		Scanner scanner = new Scanner(System.in);
		
		
		for(Empleado e: empleados) {
		
			System.out.println("How much is the raise? This employee currently has $" + e.getSueldo() + " of money");
			String input = scanner.nextLine();

			int number = Integer.parseInt(input);
			e.aumentarSueldo(number);
			System.out.println(e.getInfo().toUpperCase());
		}
		
		scanner.close();
		
		for(Empleado e: empleados) {
			System.out.println(e.getInfo());
		}
	}

}