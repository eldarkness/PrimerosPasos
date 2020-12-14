package poo;

import java.util.*;

public class Uso_Empleado {

	public static void main(String[] args) {
		
		Jefatura jefe_RRHH=new Jefatura("Arturo Lopez", 55000, 2006, 9, 25);
		
		jefe_RRHH.estableceIncentivo(2570);
		
		
		Empleado[] misEmpleados=new Empleado[6];
		
		misEmpleados[0]=new Empleado("Paco Gomez", 85000, 1990, 12, 17);
		
		misEmpleados[1]=new Empleado("Ana Lopez", 95000, 1995, 06, 02);
		
		misEmpleados[2]=new Empleado("Maria Martin", 105000, 2002, 03, 15);
		
		misEmpleados[3]=new Empleado("Antonio Fernandez", 30000, 2000, 01, 01 );
		
		misEmpleados[4]=jefe_RRHH; // Polimorfismo en accion. Principio de sustitucion
		
		misEmpleados[5]=new Jefatura("Miriam Carceles", 95000, 1999, 5, 26);
				
		
		Jefatura jefa_Finanzas=(Jefatura) misEmpleados[5];
		
		jefa_Finanzas.estableceIncentivo(55000);
		
		
		System.out.println(jefa_Finanzas.tomar_decisiones("Dar mas dias de vacaciones a los empleados"));
		
		
		System.out.println("El jefe " + jefa_Finanzas.dameNombre()+ " tiene un bonus de: " + jefa_Finanzas.Establece_bonus(500));
		
		System.out.println("El empleado " + misEmpleados[1].dameNombre() + " tiene un bonus de: " + misEmpleados[1].Establece_bonus(1000));
		
		
		// Ejemplos con el instanceof
		Empleado director_comercial=new Jefatura("Sandra", 85000, 2012, 05, 05 );
		Comparable ejemplo=new Empleado("Elisabeth", 95000, 2011, 06, 07);
		if(director_comercial instanceof Empleado) {
			System.out.println("Es de tipo Jefatura");
		}
		if(ejemplo instanceof Comparable) {
			System.out.println("Implementa la interfaz comparable");
		}
	
				
		for (Empleado e: misEmpleados){
			
			e.subeSueldo(5);
		}
		
		
		Arrays.sort(misEmpleados);
		
		for (Empleado e: misEmpleados) {
			
			System.out.println("Nombre: " + e.dameNombre() + ". ID: " + e.dameID() + " Sueldo: " + e.dameSueldo() + ". Fecha de Alta: " + e.dameFechaContrato() + ".");
		
		}
				
				
	}

}

class Empleado implements Comparable, Trabajadores { //Clase empleado, dentro estara el constructor, las variables iniciales y los metodos GETTER y SETTER
	
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
	
	public int compareTo(Object miObjeto) {
		
		Empleado otroEmpleado=(Empleado) miObjeto;
		
		if(this.sueldo<otroEmpleado.sueldo) {
			
			return -1;
		}
		
		if(this.sueldo>otroEmpleado.sueldo) {
			
			return 1;
		}
		
		return 0;
				
	}
	
	public double Establece_bonus(double gratificacion) {
		
		return Trabajadores.bonus_base+gratificacion;  // Con esta instruccion le estariamos pasando a la sentencia que llama a este metodo la constante Trabajadores.bonus_base 
														// que esta declarada en la interface Trabajadores mas la variable gratificacion que se ha pasado como parametro
	}
		
	private String nombre;
	
	private double sueldo;
	
	private Date altaContrato;

	private static int IdSiguiente=0;
	
	private int Id=0;

	
		
}

class Jefatura extends Empleado implements Jefes {
	
	public Jefatura(String nom, double sue, int agno, int mes, int dia) {
		
		super(nom, sue, agno, mes, dia);
		
	}
	
	public String tomar_decisiones(String decision) {
		
		return "Un miembro de la direccion ha tomado la decision de: " + decision; 
	}
	
	public double Establece_bonus(double gratificacion) {
		
		double prima=2000;
		
		return Trabajadores.bonus_base+gratificacion+prima; // Con esta instruccion le estariamos pasando a la sentencia que llama a este metodo la constante Trabajadores.bonus_base 
															// que esta declarada en la interface Trabajadores mas la variable gratificacion que se ha pasado como parametro y ademas
															// tambien hay que sumarle la variable prima que esta declarada en este mismo metodo diferenciandola asi del metodo Establece_bonus declarado en la clase Empleados

	}
	
	public void estableceIncentivo(double b) {
		
		incentivo=b;
				
	}
	
	public double dameSueldo() {  // Enlazado dinamico. Cuando recorramos un array de tipo empleado en un bucle el interprete de java llamara automaticamente a este metodo cuando se encuentre un objeto de tipo Jefatura ya que este metodo machaca al de la clase Empleado
		
		double sueldoJefe=super.dameSueldo();
		
		return sueldoJefe + incentivo;
		
	}
		
	private double incentivo;
	
	
}

class Director extends Jefatura {
	
	public Director(String nom, double sue, int agno, int mes, int dia) {
		
		super(nom, sue, agno, mes, dia); // Con la instruccion super estariamos llamando al constructor de la clase padre, esto es al constructor de la clase Jefatura 
										//que a su vez llama al de la clase Empleados que es la clase que tiene definido el constructor que queremos usar segun la lista de parametros
		
	}
}

