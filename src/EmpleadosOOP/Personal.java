package EmpleadosOOP;

public class Personal extends Empleado{ // Herencia, hereda las props de Empleado y en el super llama a uno de sus constructores que solo recibe el nombre del empleado.
	



	private String interest;
	private int companyValoration;
	private String softSkill;
	private int giveMoney;
	
	public  Personal(String name, String interest, int companyValoration, String softSkill) { // Personal class Also contains all the methods of the parent class "Empleado"
		super(name);
		this.interest= interest;
		this.companyValoration=companyValoration;
		this.softSkill= softSkill;
	}
	
	public String getPersonal() {
		return "Personal interest: " + interest + "\nValorates the company: " + companyValoration + "\nRelated softSkills: " + softSkill; 
	}
	
	//setter
	@Override
	public String aumentarSueldo(double giveMoney) {  // aumentarSueldo sobreescribió al método aumentarSueldo heredado de la clase Empleado
		int sueldo= super.getSueldo(); 		// acá utiliza el getSueldo() de la clase padre (Empleado) 
								//!! si sacas super hace implicito el uso de getSueldo del método del padre pero capaz confunde.
		
		// pudo haberse llamado diferente la fn y no se hace un override del método pero bueno, ahorra y tiene sentido EN ESTE CASO, pero puede malir muy sal.

		return "Nuevo sueldo, recibió un regalo! " + ( sueldo + giveMoney  );  
	}

	
}
