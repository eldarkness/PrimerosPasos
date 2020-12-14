package poo2;
import java.util.*;

import java.util.Date;
import java.util.GregorianCalendar;

public class MainPrincipal {

	public static void main(String[] args) {
	
		//Empleados empleado01=new Empleados("Arturo","Lopez Muñoz", "48516537s", "c/ palmeras nº1", 30012,  false);
		Empleados empleado02=new Empleados("Isabel", "La Catolica", "69696969p", "c/ nose donde vive nº24", 31024, true, 10, 05, 2006, 10000);
		Empleados empleado03=new Empleados("Miriam", "Carceles Parra", "52154871s", "c/ pilar nº25 3ºB", 30012, false, 15, 03, 2008, 15000);
		
				
		Empleados[] arrayEmpleados = new Empleados[4];
		
		arrayEmpleados[0] = new Empleados("Arturo","Lopez Muñoz", "48516537s", "c/palmeras nº1", 30012, false, 20, 04, 2002, 18000);
		arrayEmpleados[1] = empleado02;
		arrayEmpleados[2] = empleado03;
		arrayEmpleados[3] = new Jefatura("Jose Carlos", "Lopez Muñoz", "48516538q", "C/ pañmeras etc", 30012, false,15, 03, 2002, 21000);
		Jefatura ola2= new Jefatura("Isabela", "La puta", "6asdasd6969p", "c/ nose dasd24", 31024, true, 10, 05, 2006, 10000);
		
		arrayEmpleados[0].aumentoSueldo(50);
		
			
		for (Empleados e: arrayEmpleados) {
			
			System.out.println("El trabajador se llama " + e.getNombre() + " " + e.getApellidos() + ". Su DNI es: " + e.getDNI() + ". Su direccion es " 
			+  e.getDireccion() + ", " + e.getCodigoPostal() + ". ¿Se droga?: " + e.isSeDroga() + ". La fecha actual es: " + e.getFechaContrato() + " y su sueldo es de " + e.dimeSueldo() + " €/anuales");
			
		}
		
				
		System.out.println(getCurrentTime());
	}
	public static Date getCurrentTime() {
		GregorianCalendar calendarioGregoriano=new GregorianCalendar();
		Date horaActual=calendarioGregoriano.getTime();
		return horaActual;
	
		
	}
}


