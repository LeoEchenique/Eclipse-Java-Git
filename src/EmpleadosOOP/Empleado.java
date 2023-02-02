package EmpleadosOOP;

import java.util.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Empleado {

	private final String nombre; // final === const in JS. this keyword makes impossible to any setter to change the value once the class is instanciated.
	private int sueldo;
	private final String altaContrato;
	private final int ID;
	private static int nextId= 1;
	
	public Empleado(String nombre, double sueldo, int dia, int mes, int anio) {

		this.nombre = nombre;
		this.sueldo = (int) sueldo;
		LocalDate date = LocalDate.of(anio,mes,dia);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String formattedDate = date.format(formatter);
		this.altaContrato= formattedDate;
		ID= nextId;
		nextId++;
	//	GregorianCalendar alta = new GregorianCalendar(anio, mes, dia);
	//	this.altaContrato = alta.getTime();
		
		
	}

	// getters
	public String getInfo() {
		return "Name: " + nombre + " Sueldo: " + sueldo + " Alta de contrato: " + altaContrato + "Id: " + ID;
	}

	public String getSueldo() {
		
		return Integer.toString(sueldo);
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
}
