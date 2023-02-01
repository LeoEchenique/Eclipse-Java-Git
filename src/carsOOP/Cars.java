package carsOOP; 


public class Cars {
	
	private int ruedas; 	// it's private because all cars have 4 wheels. ENCAPSULATION
	int largo;		// dynamic props, this is bad. because other class or block of code can change the value without a setter. but for learning purposes for now will be keep it this way
	int ancho;
	private String color;
	int peso;
	private int year;
	
	//Constructor - siempre tiene el mismo nombre que la clase
	
	public Cars( int largo, int ancho, String color, int peso, int year) {
		this.ruedas= 4;
		this.largo= largo;
		this.ancho=ancho;
		this.color=color;
		this.peso=peso;
		this.year=year;
		
	}
	
	public String basic_info() {
		return "This Vehicule has " + this.ruedas + " wheels and " + this.peso + "Kg of weight";
	}
	public void setColor(String color) {
		this.color=color;
	}
	public void setYear(int year) {
		this.year=year;
	}

	public String getYear() {
		return "This Vehicule is a " + this.year + " model";
	}
}
