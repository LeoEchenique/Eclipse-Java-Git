    Java papá!

Regla clave de sentido común: "Es un.." -> que la subClase sea "lo mismo" que la clase de la que hereda {vehículo === pick-up } (una pick up, es un vechiculo y hereda props generales relacionadas)

Modularización: tener clases auxiliares o clases de utilidad o con main en archivos separados, SOLID

Encapsulamiento: FIRST principle of OOP.
/los valores "inviolables" de una instancia deben ser privados pudiendo acceder entonces desde otra clase por medio de un getter. ///podemos setear valores privados desde otra clase con un setter

# Key: public static void main

1. todo pograma java se ejecuta desde el método main
2. todo programa java tiene al menos una clase principal que contiene el método main
3. public: se puede acceder al método main desde fuera de la clase donde está definido.
4. static: no actúa o puede actuar bajo una instancia de un objecto de clase. esto es fundamental ya que, al ser ejecutado en cascada, toda clase con main necesita ejecutar código desde fuera de una instancia de clase. en la primera linea de código que ejecuta el main no hay ningún objecto construido. es el método que se encarga de construir o ejecutar código "on behalf"
5. void: no devuelve ningun dato, por eso void.

# Métodos: permiten que nuestras clases interactuen entre sí, formando una unidad, para que un programa funcione.

# tips:

    # Java NO admite herencia multiple! --> transformada en interfaces
    # ECLIPSE pone en cursiva todas aquellas variables que pertenezcan  a la clase y no a un objeto en si (static)
    # PARA UTILIZAR UNA VARIABLE STATIC se necesita acceder DESDE LA CLASE y NO desde la instancia. porque el mod. Static pertenece a la clase y no a un objecto en sí.
    # PARA UTILIZAR UN MÉTODO STATIC se necesita acceder DESDE LA CLASE y NO desde la instancia. porque el mod. Static pertenece a la clase y no a un objecto en sí.
    # NO SE PUEDE comparar Strings con '=='  (si con equals, recordá que String es una clase porque no es primitivo)
    # la presencia de un método main en una clase depende de su propósito y función dentro del programa, no necesariamente de su ubicación en un paquete.
    # No es necesario que todas las clases tengan un método main, ya que pueden ser utilizadas como clases auxiliares o clases de utilidad dentro de otras clases con un método main.

    / formas desaconsejadas de codear:
    										/ crear dos o más clases dentro de un mismo archivo. ()
    										/ CONTRAS:
    													no haces modularización.
    										/PROS:    limitar por default las clases siendo posible acceder a ellas sólo por la

# Estructura de una variable: [tipo + identificador] = asignación. (string Name= "leo";)

    -se declaran variables en camelCase

# Sobrecarga de constructores: siempre y cuando el número de parámetros sea distinto podes instanciar un mismo tipo de objeto pero con distintos parámetros

# tipos de datos:

!!Primitivos: !!Cannot be a null pointer, no puede ser null los datos primitivos.

-numéricos:
byte number1= 1; // 1 byte
short number2= 2; // 2 byte
int number3= 3; // 4 byte
long number4= 4; // 8 byte

-flotantes-decimales:
float decimal= 4.9f; //--> la "f" le dice al prog que es un float, si no tira error porque le da duda de si es un double.
double decimal2= 9.99d// --> gralmente para un doble no hace falta la "d" CREO pero si la pones ta todo bien
-caracter:

    char letra= "a"; // sólo 1 caracter. si pones "ad" error porque hay 2 caracter

-boolean:

    boolean v= true;
    boolean f= false;

!!String= tipo de dato de clase
-cadena de texto:

    String nombre= "leo"; //--> esto en realidad ya es la implementación de la CLASE String

/_
A primitive type is supposed to be the smallest atomic type which cannot be decomposed.
A string is fundamentally a sequence of characters and that is why there is no string primitive.
Think of primitives as the minimum required for the language to function. Anything else that is
required can be build from those primitives.
_/

!! wrapers: Envuelve los datos primitivos permitiendo entre otras cosas una referencia null:

    Integer numero= null; --> !== Int number= null; -> **throws error, cannot be null because it's a primitive type of data.

# operadores

-Son iguales que JS pero no está el de comparación estricta (===) o (!==) sólo (==) y (!=)

// palabras reservadas: hay, buscalas dogor algún dia si tenes un error inexplicable, puede venir por acá

# Funcionesss: contienen MODIFICADORES (De acceso, u otros que ya veré en profundidad) + lo que retorna

    ## algo raro:  static void holaNombre(String nombre) {
    					System.out.println("Hola " + nombre);
    				}
     				static void holaNombre(String[] nombre) {	// !!warning this will not throw an error because even if the name of the Fn is the same as the above, the args are diff so this is fine to Java
    					System.out.println("Hola " );
    				}

    			---- two diff functions but with the same name can be possible in Java
    			---- so: you can overload a function name IF and only if the args are different on each Fn declaration


    -mod de acceso: public, private, protected, default
    -mod de NO acceso: estático - final - resumen - transitorio - volátil - sincronizado - nativo


    estructura de una función:	access_mod + noAcces_mod + return value + name + args + Fn

    ej: private static void HolaMundo(){	--> privada de la clase donde es instanciada, static que significa algo que no sé todavía, void porque no retorna nada, solo ejecuta un print en la consola
    	System.out.println("Hola mundo!");
    };

!!!-- los parámetros que recibe la función obviamente deben esecificar qué tipo de dato espera recibir

    ej: private static void holaNombre(String nombre){
    	System.out.println("Hola " + nombre);
    };

!!-> para llamar a la función se describe el nombre del parametro seguido del argumento:

    holaNombre("leo") -> "Hola leo"

# MODIFICADORES EN JAVA: JVM= Java Virtual Machine

They are used to control access mechanisms and also provide information about class functionalities to JVM.

# 1)Los modificadores de acceso:

!!--Access Modifiers in Java help restrict the SCOPE of a variable, method, class, or constructor.

En Java existen los siguientes modificadores de acceso: default, private, protected y public.

-- Default -> Sino se especifica modificador de acceso para una clase, método o miembro de datos,
se tiene un modificador de acceso default por defecto.
.- solo se puede acceder dentro del mismo paquete

-- Private -> Los métodos o los miembros de datos que se declaran como privados usando la palabra clave private y sólo se puede acceder a
ellos desde DENTRO DE LA CLASE EN LA QUE SE DECLARAN.

-- Protected -> Los métodos o miembros de datos declarados como protected son accesibles desde dentro del mismo
paquete o sub-clases dentro de paquetes diferentes.
.- dentro del mismo paquete (like default mod)
.- por heredación
ej: public class B extends A {
public static void main(String[] args) {
B obj = new B();
obj.mostrar(); -> mostrar es un método que está dentro de la clase A de quien hereda huevadas la clase B por lo que el método es accesible por la clase B por extensión
} // el método mostrar() es protected
}

-- Public -> El modificador de acceso público se especifica con la palabra clave public.
Se caracteriza por tener el alcance más amplio entre todos los modificadores de acceso de Java.

     .-El modificador de acceso público se especifica con la palabra clave public.
     .-Se caracteriza por tener el alcance más amplio entre todos los modificadores de acceso de Java.
      Las clases, métodos o miembros de datos que se declaran como públicos se pueden acceder desde cualquier lugar del programa.

# 2)Non-access modifiers:

In java, we have 7 non-access modifiers. They are used with classes, methods, variables, constructors, etc
to provide information about their behavior to JVM. They are as follows:

static
final
abstract
synchronized
transient
volatile
native

1.  static -> the entity to which it is applied is available outside any particular instance of the class. That means the static methods or the attributes are a PART OF THE CLASS AND NOT AN OBECT.
    .-The memory is allocated to such an attribute or method at the time of class loading. (more efficient by saving memory)
    .-A static field exists across all the class instances, and WITHOUT creating an object of the class, they can be called.
    .- A static method cannot make a static reference to the non-static field !!! (if a static method getter try to access and return a non-static field it will throw an error before compilation )
    .- An attribute or method MUST be called by the class and not the instance itself [className].myMethod || [className].myAttribute
    practical example:

        		import java.io.*;

        		class Contador {

        			// static variable
        			static int count = 0;
        			void myMethod()
        			{
        				count++;
        				System.out.println(count);
        			}
        		}


        		class GFG {
        			public static void main(String[] args)
        			{
        				// first object creation
        				Contador obj1 = new Contador();

        				// method calling of first object
        				obj1.myMethod(); 			-------> output: 1 (incrementation of the static variable by 1)

        				// second object creation
        				Contador obj2
        					= new Contador();

        				// method calling of second object
        				obj2.myMethod(); 			-------> output: 2 (incrementation of the static variable by 1)
        			}
        		}

        			SO....   the count variable is static, so it is not tied to a specific instance of the class. While obj1.myMethod() is called it increases the value of count by 1 and then obj2.myMethod() again increases it . If it was not a static one, then we will get output as 1 in both cases, but as it is a static variable so that count variable will be increased twice, and we will get 2 as an output the second time.

2.  The final keyword indicates that the specific class cannot be extended or a method cannot be overridden

    - If a class is declared as final, then we cannot extend it or inherit from that class.
    - If a VARIABLE is declared as final, his value cannot be changed (example: private final String nombre; --> once the constructor instances an object with this prop, it cannot be set to another value );

3.  abstract

    .- una clase que tenga al menos un método abstracto debe ser definida como abstracta

    abstract keyword is used to declare a class as partially implemented means an object cannot be created directly from that class. Any subclass needs to be either implement all the methods of the abstract class, or it should also need to be an abstract class. The abstract keyword cannot be used with static, final, or private keywords because they prevent overriding, and we need to override methods in the case of an abstract class.

    real-life example:
    .-tenes clases "empleados" , "jefes" y "alumno". "jefe" hereda de "empleados" porque un jefe es un empleado. a todos se puede referir si planteamos una idea de más abstracta: los tres, tanto las instancias como "jefe" como el "empleado" y "alumno" son una "persona".
    .-persona sería una cualidad más abstracta que los une, y engloba todos sus métodos "naturales", como por ejemplo un getDescription(). Este getDescription() en clases heredadas involucra información particular donde dependiendo el contexto/tipo (empleado, jefe, alumno) su comportamiento varía, ya que por ejemplo un alumno no tiene un sueldo.
    .- por lo que los métodos de la clase abstracta necesitan SI O SI ser redifinidos (Override) en clases que heredan

    .- una atomización/modularización de la clase a definir.

4.  synchronized

    synchronized keyword prevents a block of code from executing by multiple threads at once. It is very important for some critical operations.

5.  volatile

    .- The volatile keyword is used to make the class thread-safe. That means if a variable is declared as volatile, then that can be modified by multiple threads at the same time without any issues.
    .- The volatile keyword is only applicable to a variable
    .- A volatile keyword reduces the chance of memory inconsistency.
    .- The value of a volatile variable is always read from the main memory and not from the local thread cache, and it helps to improve thread performance.

6.  transient

    .-This needs prior knowledge of serialization in Java.

    .-The transient keyword may be applied to member variables of a class to indicate that the member variable should not be serialized when the containing class instance is serialized. Serialization is the ​process of converting an object into a byte stream. When we do not want to serialize the value of a variable, then we declare it as transient. To make it more transparent, let’s take an example of an application where we need to accept UserID and Password. At that moment, we need to declare some variable to take the input and store the data, but as the data is susceptible, so we do not want to keep it stored after the job is done. To achieve this, we can use the transient keyword for variable declaration.

    ej:

        import java.io.*;

        class transient_gfg implements Serializable {
        	// normal variable
        	int a = 10;

        	// Transient variables
        	transient String UserID="admin";
        	transient String Password="tiger123";

        }
        class GFG{
        	public static void main(String[] args) throws IOException, ClassNotFoundException {
        		transient_gfg obj=new transient_gfg();

        		// printing the value of transient
        		// variable before serialization process		-OUTPUT:
        		System.out.println("UserID :"+obj.UserID);		// "admin"
        		System.out.println("Password: "+obj.Password);	// "tiger123"
        		System.out.println("a = "+obj.a);   			// 10

        		// serialization
        		FileOutputStream fos = new FileOutputStream("abc.txt");
        		ObjectOutputStream oos = new ObjectOutputStream(fos);
        		oos.writeObject(obj);

        		// de-serialization
        		FileInputStream fis = new FileInputStream("abc.txt");
        		ObjectInputStream ois = new ObjectInputStream(fis);
        		transient_gfg output = (transient_gfg)ois.readObject();

        		// printing the value of transient
        		// variable after de-serialization process	        -OUTPUT:
        		System.out.println("UserID :"+output.UserID);		// null
        		System.out.println("Password: "+output.Password);	// null
        		System.out.println("a = "+obj.a);					// 10

        	}
        }

7.  native

    The native keyword may be applied to a method to indicate that the method is implemented in a language other than Java.

# Clases

    constan de:
    			- [mod.acceso] + keyword(class) + [Nombre de la clase]
    			- atributos, constructores, métodos


    			.atributos: en parte abstractos, lo que representa la clase (clase coche= atributos like color, mod. año, etc)
    			.constructores: se pude no añadirlo, lo que significa que se podra instanciar la clase con los atributos por defaut (es decir, sin asignarle valores a esos atributos)
    							.-los contsuctores empiezan con primera letra en mayus.
    							.-es como un método que recibe de parametros los atributos y así "inyecta" esa data dentro de una instancia.
    							.- EL THIS ENTRA EN ACCIÓN: ahora el this vuelve a la vida para dar referencia a cada nueva instancia creada como una propia.
    							.- "this" dentro de una sobre carga de constructores hace referencia al constructor cuya cantidad de parámetros sea la misma que la de el constructor desde donde se llama:
    									ej:

    									public Empleado(String nombre, double sueldo, int dia, int mes, int anio) {

    										this.nombre = nombre;
    										this.sueldo = (int) sueldo;
    										this.altaContrato= formattedDate;
    										ID= nextId;
    										nextId++;
    									}
    									public Empleado(String nombre){
    										this(nombre, 10000, 01,01,2023);-------------> lo que hace es instanciar un objecto del mismo tipo de dato (empleado) con algún dato por "Default"
    																		-------------> this llama al constructor "padre" (el que tiene el mismo numero de params y que se coresponden en tipo)
    										//es equivalente a:
    											this.nombre= nombre;
    											sueldo= 10000;
    											altaContrato= "01/01/2023";
    											ID= nextId;
    											nextId++;
    										}
    									}


    									!!!!!!!! entonces ahora solo queda instanciar un objeto de esta clase de dos maneras: teniendo toda la info o aplicando una por default:

    												Empleado maria= new Empleado("María"); // genera un field dinámico y los demás fields con info por default
    												Empleado julia= new Empleado("Julia", 200000,15,9,2013); // genera un Empleado con todos los campos dinámicos
    			.métodos: métodos.
    						- la sobre carga de métodos también existen y funcionan de la misma manera que los constructores múltiples: PUEDEN TENER EL MISMO NOMBRE SIEMPRE Y CUANDO POSENA UNA CANTIDAD DISTINTA DE PARAMETROS Y TIPOS DE DATOS.

# Tips: Herencia en paquetes importados:

    		una clase que importas al código para utilizarla, como por ejemplo: "java.util.ArrayList"  ArrayList is a class that implements the java.util.List interface and provides a dynamic array-based of the list data structure.

# Tips: constructores -- super:

    			-dentro de la herencia cuando creas una subclase podes asignar un super para "no duplicar código"
    			- el super lo que te da es la posibilidad de poder instanciar una clase hija con las prop propias de la clase hija y a su vez con las props de la clase padre
    	Constructor: método especial que tiene el mismo nombre que la clase y se encarga de dar un estado inicial a los nuevos objetos

# PRINCIPIOS OOP:

1. Herencia.. not much to say, you got it ;)

2. polimorfismo: tambien conocido como PRINCIPIO DE SUSTITUCIÓN.
   .- Una instancia puede comportarse diferente según el contexto, las variables objeto son polifórmicas.
   .- Se puede utilizar un objeto de la subclase siempre que el programa espere un objeto de la superclase

# Interfaces: conjunto de métodos con los que deben cumplir las clases que implementan la Interfaz

    .- Resuelve el problema de la herencia multiple en Java:  una clase (supongamos "Jefe") hereda de "Empleados" (porque un jefe es un empleado) pero Java no admite herencia múltiple por lo que jefe, solo heredaría de Empleado y nada más, suponiendo que tenemos otra clase "junta directiva" en la cual hay ciertos métodos que "jefe" debería heredar, esto, siendo que Java no admite herencia múltiple sólo será posible gracias a una INTERFAZ. (implementación de una interfaz)

    					CODE EXAMPLE:
    									Class Jefe extends Empleado implements [Interfaz1], [Interface2], ... {	 !!!!!!!!!! al implementar una interfaz, estás obligado a sobreescribir los métodos abtrasctos que tiene

    									}

    .- Similar a  una clase abstracta


    .- Establecen los métodos a cumplir por las clases. Las clases que IMPLEMENTAN la INTERFAZ, deben incluir estos métodos.


    Una interfaz en código es:

    .- como una clase que contiene 1-métodos abstractos  2-constantes
    .- Todos los métodops tienen un scope (mod. acceso) PUBLIC O ABSTRACT. --> si no lo declaras en un método el "default" lo da por supuesto
    .- No se pueden INSTANCIAR objetos


    - HAY JERARQUÍA DE INTERFACES, una interfaz puede extender otra interfaz

    			ej:   	public interface Jefes extends Interfaz1{

    			}

    .- Cada clase que implementa una interfaz como que hace una especie de CONTRATO en donde debe si o si respetar los typos de dato que recibe la interfaz y sobre-escribir la lógica del método según corresponda en la necesidad de tener que implmentarlo dentro de una clase.


    .- Hay métodos que reciben como argumentos una interfaz, como los EVENTOS. Es como una especie de CB function. EJ: un temporizador de "javax.swing.*" es de tipo  Timer y recibe (al crear una instancia de Timer, los ms, y una interfaz llamada "ActionListener" ) --> siendo que la interfaz no es más que un método que implementa una clase, hay que sobreescribirlo, por eso esto actua como una CB

# Clases internas / Clases internas locales.

    - una clase dentro de un método.
    - El objetivo es simplificar más el código
    - Su ámbito queda restringido al método en donde son declaradas.
    - Encapsulación extrema: ni siquiera la clase a la que pertenecen puede acceder a ella, sólo el método puede acceder
    - Si es declarada NO DEBE llevar ningún modificador de acceso, nada.

# Eventos: 3 obj -> evento, fuente, listener

    Qué desencadena la acción:   Objeto evento (onClick for example in React)
    Quien desencadena la acción: Objecto Fuente (Typo de dato User por ejemplo)
    Quien recibe la acción: 	Listener, Función callback


    Objeto evento == EventObject -> de ahi salen todas  (ActionEvent / WindowEvent, etc...)

    Objeto fuente == la instancia a partir de la cual se desencadena un evento

    Objeto listener == el que recibe el evento y hace algo al respecto.

     Es como un event de react teniendo que implementar la interfaz del evento

# Clases adaptadoras: sirven por ej para NO tener que declarar metodos de una interfaz al momento de implementarla en una clase

    En vez de implementar una interfaz y tener que obligatoriamente sobreescribir los métodos que implementa la interfaz, extendes la clase

# Errores: compilation || runtime: EVERITHING is an Object.

    cada vez que hay un error Java crea un objeto de tipo error tamb. Como todo es un  objeto, cada error tiene una jerarquía de clases. Toda empieza por la más obvia, (abstracta): Error

    Error se subdivide en 2 originariamente, errores de:  compilación y runtime.

    compilación: Objeto error de sintaxis, de compilación, escribi bien o mamala.

    runtime Error:  Errores que son arrojados (Throwable) ---> Toda clase Error que es de runtime Hereda de la clase Throwable.


    Dentro de la clase Throwable se despliegan dos subclases más: Error / Exception.

    		-Error: gralmente de recursos. algo anda mal por los recursos, de hardware o algo asi.

    		-Exception:  los errores que gralmente salen.
    			Dentro de ellos dos subclases más: IOException y RunTimeException


    				-IOException: 			Excepciones comprobadas			-----> Por ej: definir un path para buscar un archivo y ese archivo se movió de lugar o algo así
    					-Los errores/Excepciones de este tipo el propio lenguaje de Java las tiene contempladas
    					- Si o si Try Catch o condicional


    				-RunTimeException:		Excepciones NO comprobadas		-----> Por ej:  querer almacenar una variable,  recorrer un array con más posiciones en las que en principio se declaró..

    							-Los errores/excepciones de este tipo significa que debemos implementar una solución de código porque algo está mal implementado.
    							-"podes programarlo mejor"
    							- no capturas el error si o si como una excepción comprobada porque se supone que es un error de programado


    	RunTimeException   y   IOException heredan de Exception. Por lo que si capturas una Exception contemplas ambas porque ambas son en primera instancia una Excepció, pero sería una mala práctica en ciertos casos




    !!!!! Si un método lanza una excepción, debe como buena práctica incluirse en la def del método:

    			!! no solo como buena práctica, porque si es de un error tipo RunTimeException Java compila bien pero si hay un error rompe la ejecución
    			!! pero si es de tio IOException cagaste, estas obligado a un try catch porque eclipse marca el error

    		static void checkEmail (String mail) throws [ERROR]{ --> "throws" para referenciar que este método PUEDE lanzar un error
    			....
    			throw new [Error()]  -> just like JS!
    		}

    !!!!! Si un método lanza un error de tipo "Exception" hay que implementar el bloque try/catch. Es importante al momento de crear métodos tener presente qué objecto de error devuelve específicamente para implementarlo bien. (si es IOE o RunTime)

In Java, I/O operations are performed using classes and methods from the java.io package. These classes and methods provide a way to interact with the input/output system and read from or write to various types of data sources.

# Try - Catch: curious aspect

    En Java al entonces tener que ser explícito en el tipo de error que puede devolver un método podrías tener un método que arroje dos instancias de errores diferentes por ejemplo...

    Para eso tenes que ANIDAR CATCHS
    ej:
    	try{
    		makeOperation(); --> this will throw at least 3 errors in case something is wrong
    	} catch([Error Type] e) {		--> define the error that the catch will catch (redundancy)

    		//..make something with the error
    	} catch([Error Type] e) {		--> define the error that the catch will catch (redundancy)

    		//..make something with the error
    	} catch([Error Type] e) {		--> define the error that the catch will catch (redundancy)

    		//..make something with the error
    	}

# Debugging

    can edit value/pairs while steping on execution code with debbuger tool. (like, changing a value in a for iteration in a random step of i value)
    can record break points so the execution in the code will stop.


    Buttons:
    	resume: go to the next break point (and pause) or resume the entire execution  of a program
    	F6 or "step over":  execute line by line pausing every time
    	F5 or "step into":  go to the file where or from that expression is stored. like if you make an invoice it goes all the way through invoice class -> documment class -> object class and therefore, if you combine this with "step over" you can see the execution line by line that is happening on that file and step into and go to a beauty of a rabbit hole
    	skip al break points:  when you resume the execution skips all the breakpoints remaining  (if you press again brings the breakpoints from the void)



    Breakpoints: has a conditional optional section to execute some code IF that condition is reflected, otherwise resume to keep the execution till the end or the next breakpoint


    Expressions: check and show if a given variable, conditional or other thing has a value in the process of execution

    			expression tab view in eclipse -> add expresion [varName] |  empty value  --> when the debug program is executed, when this varName contains a value, or it changes is value, displays it.

# Streams: flujo de datos

    para guardar data que se almacena provisoriamente con espacio en memoria de la ram en la pc o para enviar informacion a un remoto.


    dos formas:


    		flujo de bytes 			-> inputStream / outputStream  -> I/O operations
    		flujo de caracteres		->	Reader / Writer (fs in node for example) -> IO operations



