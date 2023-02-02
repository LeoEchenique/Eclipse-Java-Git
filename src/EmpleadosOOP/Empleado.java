package EmpleadosOOP;

import java.util.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Empleado {

	String nombre;
	int sueldo;
	String altaContrato;

	public Empleado(String nombre, double sueldo, int dia, int mes, int anio) {

		this.nombre = nombre;
		this.sueldo = (int) sueldo;
	//	GregorianCalendar alta = new GregorianCalendar(anio, mes, dia);
	//	this.altaContrato = alta.getTime();
		LocalDate date = LocalDate.of(anio,mes,dia);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String formattedDate = date.format(formatter);
		this.altaContrato= formattedDate;
	}

	// getters
	public String getInfo() {
		return "Name: " + nombre + " Sueldo: " + sueldo + " Alta de contrato: " + altaContrato;
	}

	public String getSueldo() {
		
		return Integer.toString(sueldo);
	}

	// setters

	public String aumentarSueldo(double porcentaje) {
		
		double aumento = sueldo * porcentaje / 100;
		sueldo += aumento;

		return "New salary: " + sueldo;
	}
}
