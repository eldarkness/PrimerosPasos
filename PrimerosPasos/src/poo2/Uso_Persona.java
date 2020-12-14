package poo2;

import poo.Uso_Vehiculo;

public class Uso_Persona{
	
	public static void main(String[] args) {
		
		Empleado trabajador01= new Empleado("Arturo Lopez");
		
		System.out.println("El trabajador " + trabajador01.dameNombre() + " tiene la descripcion " + trabajador01.dameDescripcion());
		
		Empleado trabajador02= new Empleado("Miriam Carceles");
		Coche micoche1=new Coche();
	}
}


abstract class Persona {
	
	private String nombre;
	
	public Persona (String nombre) {
		
		this.nombre=nombre;
	
	}
	
	public String dameNombre() {
		
		return nombre;
	}
	
	public abstract String dameDescripcion();
	
}

class Empleado extends Persona {
	
	public Empleado(String nombre) {
		
		super(nombre);
		
	}
	
	public String dameDescripcion() {
		
		return "El empleado se llama: " + dameNombre();
	}
}

