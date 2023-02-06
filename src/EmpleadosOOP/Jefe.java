package EmpleadosOOP;

public class Jefe extends Empleado implements allEmployes {

	public Jefe(String nombre) {
		super(nombre);
	}
	
	
	
	@Override
	public void getAllEmployes(Empleado[] empleados) {
		
		for (Empleado e : empleados) {
			if (e instanceof Empleado && !(e instanceof Jefe)) System.out.println("interface implemented from JEFE class, all the employees " + e.getInfo());  // strange shit happens here 
		}
	}

}
