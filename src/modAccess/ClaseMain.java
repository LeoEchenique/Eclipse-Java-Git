package modAccess;
import modAccess2.Clase3;

public class ClaseMain {

	public static void main(String[] args) {
	
		
	
		Clase1 myobj= new Clase1();
		System.out.println(myobj.myMethod());
		
		// Clase3 myobj= new Clase3();  ---> its outside the package so must be imported above in order to work.
		
		Clase3 myobjClase3= new Clase3();  // myobjClase3 is extended from Clase1. but Clase1 has no constructor so his access mod is set default
		// System.out.println(myobjClase3.myMethod());  --> as the access mod is set to "default" we cannot call any method or value of this class.
		
		// UPDATE: now Clase1 has the first value mod set to "protected" 
		System.out.println(myobjClase3.num);  // now, "num" value in the Clase1 that is inherit by the Clase3 has the mod. access set to protected, so this value can be access
		
		System.out.println(myobjClase3);
	}

}
