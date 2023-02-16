package generics;

import EmpleadosOOP.Empleado;
import EmpleadosOOP.Jefe;

public class HerenciaGenerica {

	public static void main(String[] args) {
		/*
		Empleado counsil = new Empleado("Leo", 200000, 27, 02, 2023);
		Jefe boss = new Jefe("Manuel" );								//-- behold.. herency!
		Empleado nuevoEmpleado= boss;
		
		*/
		// the above code is not possible when we are doing some generics class stuffs.
		
		
		GenericClass<Empleado> counsil= new GenericClass<Empleado>(new Empleado("Mario"));		
		GenericClass<Jefe> boss= new GenericClass<Jefe>(new Jefe("Mario"));
		
		// GenericClass<Empleado> nuevoEmpleado = boss;   // with generic class we cannot apply the principle of sustitution
		
		
		GenericClass.printEmployeeWithErrorIfInheritates(counsil);		// all good. prints the type
		
		// GenericClass.printEmployeeWithError(boss);  // GenericClass<Jefe>  Herency is not appliable in the same way as normal class. NEED TO USE COMODIN TYPE\
		
		// IF WE WANT to use the above method with any subclass that extends from Empleado, we need a comodin type
		
		// SOLUTION: GenericClass<? extends Empleado> p
		
		GenericClass.printEmployee(boss);
	}
 
}
