package carsOOP;

public class Use_Car {
	public static void main(String[] args) {
		Cars honda= new Cars(500, 110, "red", 5000, 1980);
		System.out.println(honda.basic_info());
		
		System.out.println(honda.getYear());
		honda.setYear(2015);
		System.out.println(honda.getYear());
		
		System.out.println(honda.peso);
	}
}
