package collections;

import java.util.Objects;

public class Client {
	
	private String name;
	private String numberAcc;
	private double salary;
	
	
	public Client(String name, String numberAcc, double salary) {
		this.name=name;
		this.numberAcc=numberAcc;
		this.salary=salary;
	}


	@Override
	public int hashCode() {
		return Objects.hash(numberAcc);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Client other = (Client) obj;
		return Objects.equals(numberAcc, other.numberAcc);
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getNumberAcc() {
		return numberAcc;
	}


	public void setNumberAcc(String numberAcc) {
		this.numberAcc = numberAcc;
	}


	public double getSalary() {
		return salary;
	}


	public void setSalary(double salary) {
		this.salary = salary;
	}

}
