package poo2;
import java.util.GregorianCalendar;

import java.util.Date;

public class Empleados 
{

	private String DNI="";
	private String nombre="";
	private String apellidos="";
	private String direccion="";
	private int codigoPostal=0;
	private boolean seDroga=false;
	private Date fechaContrato;
	private double sueldo;
	
	public Empleados(String nombre,String apellidos,String DNI, String direccion, int codigoPostal,boolean seDroga, int dia, int mes, int ano, double sueldo) {
		
		this.DNI=DNI;
		this.nombre=nombre;
		this.apellidos=apellidos;
		this.direccion=direccion;
		this.codigoPostal=codigoPostal;
		this.seDroga=seDroga;
		GregorianCalendar calendario=new GregorianCalendar(ano, mes-1,dia);
		fechaContrato=calendario.getTime();
		this.sueldo=sueldo;
	}

	public String getDNI() {
		return DNI;
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre=nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public String getDireccion() {
		return direccion;
	}

	public int getCodigoPostal() {
		return codigoPostal;
	}

	public boolean isSeDroga() {
		return seDroga;
	}

	public Date getFechaContrato() {
		return fechaContrato;
	}

	public void aumentoSueldo(double porcentaje) {
		
		sueldo= sueldo+(sueldo*porcentaje/100);
	
	}
	public double dimeSueldo() {
		
		return sueldo;
	
	}
}
