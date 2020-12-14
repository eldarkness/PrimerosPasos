package poo;

/* Esta clase servira para mostrar como creamos varios objetos de la clase Empleado tanto manualmente (ver 1.0) como con Arrays (ver 2.0). Para hacerlo de forma manual crearemos
 * primero nosotros los objetos de tipo empleado (1.0) y luego usaremos el metodo subeSueldo() para subir el sueldo de los 3 empleados sin usar ningun tipo de bucle (1.1).
 * Despues imprimiremos la informacion de los 3 empleados en pantalla sin usar tampoco esta vez un bucle (1.2).
 * 
 * Luego crearemos a los empleados pero usando un Array (2.0) para mas tarde usar un bucle for para ver como se subiria el sueldo a los 3 empleados (2.1) y otro bucle for para mostrar
 * en pantalla la informacion de los 3 empleados (2.2). Despues haremos lo mismo pero usando dos bucles for mejorados, el primero para subir el sueldo de los empleados (2.3) y el segundo
 * para mostrar la informacion de los 3 empleados por la consola (2.4).
 * 
 * Despues de eso se crea la Clase Empleado y yua se va comentando todo por lineas.
  
import java.util.*;

public class Uso_Empleado_Ejemplos {

	public static void main(String[] args) {
		
		(1.0)
		
		Empleado empleado1=new Empleado("Paco Gomez", 85000, 1990, 12, 17);

		Empleado empleado2=new Empleado("Ana Lopez", 95000, 1995, 06, 02);
		
		Empleado empleado3=new Empleado("Maria Martin", 105000, 2002, 03, 15);
		
		(1.1)
		
		empleado1.subeSueldo(5);
		
		empleado2.subeSueldo(5);
		
		empleado3.subeSueldo(5);
		
		(1.2)
	
		System.out.println("Nombre: " + empleado1.dameNombre() + ". Sueldo: " + empleado1.dameSueldo()
		+ ". Fecha de Alta: " + empleado1.dameFechaContrato());
		
		System.out.println("Nombre: " + empleado2.dameNombre() + ". Sueldo: " + empleado2.dameSueldo()
		+ ". Fecha de Alta: " + empleado2.dameFechaContrato());
		
		System.out.println("Nombre: " + empleado3.dameNombre() + ". Sueldo: " + empleado3.dameSueldo()
		+ ". Fecha de Alta: " + empleado3.dameFechaContrato());
		
				
		(2.0)	
		
		Empleado[] misEmpleados=new Empleado[4];
		
		misEmpleados[0]=new Empleado("Paco Gomez", 85000, 1990, 12, 17);
		
		misEmpleados[1]=new Empleado("Ana Lopez", 95000, 1995, 06, 02);
		
		misEmpleados[2]=new Empleado("Maria Martin", 105000, 2002, 03, 15);
		
		misEmpleados[3]=new Empleado("Antonio Fernandez", 30000, 2000, 01, 01 );
		
		(2.1)
		
		for(int i=0;i<3;i++) { 
			
			misEmpleados[i].subeSueldo(5);
			
		}
		
		(2.2)
		
		for(int i=0;i<misEmpleados.length;i++) {
		
			System.out.println("Nombre: " + misEmpleados[i].dameNombre() + ". Sueldo: " + misEmpleados[i].dameSueldo() + ". Fecha de Alta: " + misEmpleados[i].dameFechaContrato());
			
		}
		
		(2.3)		
		
		for (Empleado e: misEmpleados){
			
			e.subeSueldo(5);
		}
			
		(2.4)	
						
		for (Empleado e: misEmpleados) {
			
			System.out.println("Nombre: " + e.dameNombre() + ". Sueldo: " + e.dameSueldo() + ". Fecha de Alta: " + e.dameFechaContrato() + ". Y su ID es " +  e.dameID());
		
		}
				
		
	}

}

class Empleado { // Clase empleado, dentro estara el constructor, las variables iniciales y los metodos GETTER y SETTER
	
	public Empleado(String nom, double sue, int agno, int mes,  int dia) { // El constructor puede recibir parametros solo hay que asignar el tipo de dato y darle nombre.
		
		nombre=nom;
		
		sueldo=sue;
		
		GregorianCalendar calendario=new GregorianCalendar(agno,mes-1,dia); // Para usar la clase gregorian calendar tenemos que crear un objeto de tipo gragorian calendar (al igual que hacemos cuando creamos un Scanner por ejemplo...)
																			// Y en los parentesis introducimos la informacion, en este caso el a�o, mes y dia.		
		
		altaContrato=calendario.getTime(); 	// Y luego pedimos la informacion contenida en dicho calendario con el metodo getTime()
		
		++IdSiguiente;
		
		Id=IdSiguiente;
	}
	
	public Empleado(String nom) {
		
		this(nom, 30000, 2000, 01, 01); // Aqui el this es como decir "te paso todo esto", donde nom es una variable que coge de el mismo
		
	}
	
	public String dameNombre() { //GETTER
		
		return nombre;
	
	}
	
	public double dameSueldo() { //GETTER
		
		return sueldo;
		
	}
	
	public Date dameFechaContrato() { //GETTER
		
		return altaContrato;
		
	}
	
	public void subeSueldo(double porcentaje) { //SETTER
		
		double aumento=sueldo*porcentaje/100;
		
		sueldo+=aumento;
		
	}
	
	public int dameID() {
		
		return Id;
	}
	
	private String nombre;
	
	private double sueldo;
	
	private Date altaContrato;

	private static int IdSiguiente=0;
	
	private int Id=0;
	
	
		
}*/
