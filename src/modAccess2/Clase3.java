package modAccess2;
import modAccess.Clase1;  // as Clase1 has a default access, we cannot create an object from that external package without importing it here.	

						 // remember that Clase1 has no constructor so is set to default. default !== public

public class Clase3 extends Clase1 {

	
}
