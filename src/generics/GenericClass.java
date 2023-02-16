package generics;

import EmpleadosOOP.Empleado;

public class GenericClass <T> {

	private T firstValue;
	public GenericClass(T firstValue) {
		this.firstValue=firstValue;
	}
	
	public static void printEmployeeWithErrorIfInheritates(GenericClass<Empleado> p) {  // a generic of a specific type
		
		Empleado firstEmp= p.getFirstValue();
		
		System.out.println(firstEmp);
	}
	
	public static void printEmployee(GenericClass<? extends Empleado> p) {  // < ? extends Empleado>  ----> ANY INSTANCE THAT INHERITS FROM EMPLEADO!!
		
		Empleado firstEmp= p.getFirstValue();
		
		System.out.println(firstEmp);
	}
	
	public T getFirstValue() {
		return firstValue;
	}
	
}
