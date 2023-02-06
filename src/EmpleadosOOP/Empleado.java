package EmpleadosOOP;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Empleado  implements Comparable { // implementing Comparable means that we need to override his methods to perform dynamic task based on this type of object

	private final String nombre; // final === const in JS. this keyword makes impossible to any setter to change the value once the class is instanciated.
	private int sueldo;
	private final String altaContrato;
	private final int ID;
	private static int nextId= 1;
	
	public Empleado(String nombre, int sueldo, int dia, int mes, int anio) {

		this.nombre = nombre;
		this.sueldo =  sueldo;
		LocalDate date = LocalDate.of(anio,mes,dia);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String formattedDate = date.format(formatter);
		this.altaContrato= formattedDate;
		ID= nextId;
		nextId++;
	}

	public Empleado(String nombre){
//		this(nombre, 500, 1, 1, 2023);  es equivalente a lo que esta abajo:
	
	this.nombre= nombre;
	sueldo= 10;
	altaContrato= "01/01/2023";
	ID= nextId;
	nextId++;
	}

	
	// getters
	public String getInfo() {
		return "Name: " + nombre + " Sueldo: " + sueldo + " Alta de contrato: " + altaContrato + " Id: " + ID;
	}

	public int getSueldo() {
		
		return sueldo;
	}
	
	public static int getStaticProp() {
		return nextId;
	}

	// setters
	public String aumentarSueldo(double porcentaje) {
		
		double aumento = sueldo * porcentaje / 100;
		sueldo += aumento;

		return "New salary: " + sueldo;
	}

	@Override
	public int compareTo(Object empleado) { // override the interface's method. an instance id the class who implemnt this is the parameter  // this will compare elemtns of an array
		
		Empleado otroEmpleado= (Empleado) empleado;  // we need to cast the "unknown" generic Object parameter into a Empleado type of object
		
		if(this.sueldo > otroEmpleado.sueldo ) return 1;	// start the comparision
		if(this.sueldo < otroEmpleado.sueldo ) return -1;
		return 0;
		
	}
}
