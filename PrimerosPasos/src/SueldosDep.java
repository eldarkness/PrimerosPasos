

/*
* SueldosDep.java
* 
* A partir de la definición de un empleado (ver más abajo), crea un programa JAVA (SueldosDep) que pida un 
* identificador de DEPARTAMENTO (o bien lo pases por parámetro) y nos muestre en pantalla los nombres de 
* los empleados que pertenecen a él, su sueldo y la suma total de todos los sueldos asociados a ese departamento.
*  
* Autor: Arturo Lopez Mu�oz
* Fecha: 30/11/2020 
* 
*/

import java.io.*;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class SueldosDep {
	
	public static RandomAccessFile file;
	public static ArrayList<Empleado> empleados;
	
	public static void main(String[] args) throws IOException {     
		File fichero = new File("AleatorioEmple.dat");
		//declara el fichero de acceso aleatorio
		file = new RandomAccessFile(fichero, "r");
		
		int  id, dep, posicion;    
		Double salario, sumaTotal=0.0;
		
		int DepABuscar=Integer.parseInt(JOptionPane.showInputDialog("Introduce numero de departamento"));
		empleados= new ArrayList<Empleado>();
		
		posicion = 0;  //para situarnos al principio

		for(;;){  //recorro el fichero
			file.seek(posicion); //nos posicionamos en posicion
			id = file.readInt();   // obtengo id de empleado	  	  

			String apellidos = leerApellidos();
			apellidos=apellidos.trim();
			dep = file.readInt();        //obtengo dep
			salario = file.readDouble(); //obtengo salario
			
			if(DepABuscar==dep) {
				empleados.add(new Empleado(apellidos,salario));
				
			}

			//me posiciono para el sig empleado, cada empleado ocupa 36 bytes
			posicion= posicion + 36;
			sumaTotal=sumaTotal+salario;

			//Si he recorrido todos los bytes salgo del for	 	  
			if (file.getFilePointer() == file.length())break;

		}//fin bucle for 
		file.close();  //cerrar fichero 
				
		for(int i=0; i<empleados.size();i++) {
			System.out.printf("El empleado %s cobra %.2f %n",empleados.get(i).nombre, empleados.get(i).sueldo);
		}
		
		System.out.printf("La suma total del departamento %d es %.2f ",DepABuscar, sumaTotal);
	}
	
	public static String leerApellidos() throws IOException {
		char apellido[] = new char[10], aux;
		for (int i = 0; i < apellido.length; i++) {         
			aux = file.readChar(); 
			apellido[i] = aux;    //los voy guardando en el array
		}
		String apellidos = new String(apellido);
		apellidos=apellidos.trim();
		
		return apellidos;
	}
	

}

class Empleado{
	
	public String nombre;
	public double sueldo;
	
	public Empleado(String nombre, double sueldo) {
		this.nombre=nombre;
		this.sueldo=sueldo;
				
	}
		
}
