package poo2;

public class Jefatura extends Empleados {
	
	private double incentivo;

	public Jefatura(String nombre,String apellidos,String DNI, String direccion, int codigoPostal,boolean seDroga, int dia, int mes, int ano, double sueldo) {
		
		super(nombre, apellidos, DNI, direccion, codigoPostal, seDroga, dia, mes, ano, sueldo);
		
	
	}

	public double dimeSueldo() {
		
		double sueldobase=super.dimeSueldo();
		
		return sueldobase+incentivo;
	}
	
	public void estableceIncentivo(double b) {
		
		incentivo=b;
	}
}
