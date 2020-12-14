package repasoExamemn;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

/*
 * Ficheros Binarios y aleatorios (de acceso directo)
 * 
 * Una empresa de zapatos desea almacenar en un fichero binario la colecciï¿½n de los zapatos que fabrica. De cada zapato almacena los siguientes datos:
 * 
 * Nï¿½_identificativo: entero (este dato se irï¿½ incrementando de 1 en 1 y serï¿½ la ï¿½claveï¿½ de ese artï¿½culo)
 * Modelo: String de 50 caracteres
 * Talla: entero
 * Color: String de 15 caracteres
 * Precio_Venta: double
 * Stock: entero
 * 
 * Crea un programa que presente un menï¿½ en el que poder hacer las siguientes operaciones:
 * 1. Aï¿½adir modelos de zapatos en el fichero binario, (hasta introducir FIN como nombre de modelo)
 * 2. Mostrar todos los modelos que hay en el fichero, indicando talla y color.
 * 3. Mostrar todos los modelos DIFERENTES de zapatos que hay. (Por lo que no deberï¿½ repetir los modelos iguales, ni de diferente color)
 * 4. Mostrar el importe total que se dispone en zapatos fabricados, esto es, contar el nï¿½ de stock que hay y multiplicarlo por el importe de venta de todos los modelos.
 * 5. Modificaciï¿½n de zapato. Se pedirï¿½ un Nï¿½_identificativo, se pedirï¿½n los nuevos datos, se accederï¿½ a ï¿½l de manera directa y se sobreescribirï¿½n los datos.
 *
 */
public class EmpresaZapatos {

	public static int ID=0;
	public static RandomAccessFile f;

	public static void main(String[] args) throws IOException {

		File fic= new File("EmpresaZapatos.dat");

		//DataOutputStream dos= new DataOutputStream(new FileOutputStream(fic));
		f= new RandomAccessFile(fic, "rw");
		//DataInputStream dis= new DataInputStream(new FileInputStream(fic));
		System.out.println("Bienvenido al programa de gestion de Zapatos");

		int opcion=1;
		while(opcion!=0) {
			opcion=Integer.parseInt(JOptionPane.showInputDialog("ï¿½Que deseas hacer? \n1. Aï¿½adir modelos de zapato \n2. Mostrar todos los modelos que hay en el fichero (indicando talla y color)"
					+ "\n3. Mostrar todos los modelos diferentes de zapatos que hay \n4. Mostar el importe total de todos los zapatos en stock "
					+ "\n5. Modificacion de un zapato existente en la base de datos \n0. Salir del programa"));
			switch(opcion) {

			case 1:
				altaZapatos();
				break;
			case 2:
				mostrarTallaColor();
				break;
			case 3:
				mostrarModelos();
				break;
			case 4:
				importeTotal();
				break;
			case 5:
				break;
			case 0:
				f.close();
				break;
			}

		}
		System.out.println("Saliendo del programa, hasta la proxima!");

	} // main
	
	public static void altaZapatos() throws IOException {
		StringBuffer buffer= null;
		while(true) {
			f.writeInt(ID);
			ID++;
			// Este ocupa 4 bytes

			String modelo=JOptionPane.showInputDialog("Introduce el modelo del zapato");
			if(modelo.equalsIgnoreCase("FIN")) {
				System.out.println("Has tecleado \"Fin\", volviendo al menu principal");
				break;
			}
			buffer = new StringBuffer( modelo);
			buffer.setLength(50);
			f.writeChars(buffer.toString());
			// Este ocupa 100 bytes

			int talla=Integer.parseInt(JOptionPane.showInputDialog("Introduce la talla del zapato"));
			f.writeInt(talla);
			// este ocupa 4 bytes

			String color=JOptionPane.showInputDialog("Introduce el color del zapato");
			buffer = new StringBuffer(color);
			buffer.setLength(15);
			f.writeChars(buffer.toString());
			// este ocupa 30 bytes

			double precio=Double.parseDouble(JOptionPane.showInputDialog("Introduce el precio del zapato"));
			f.writeDouble(precio);
			// este ocupa 8 bytes

			int stock=Integer.parseInt(JOptionPane.showInputDialog("ï¿½Cuantas unidades hay en stock?"));
			f.writeInt(stock);
			// este ocupa 4 bytes


			f.seek(0);

			int i=f.readInt();
			String modeloR=leerModelo();
			int tallaR=f.readInt();
			String colorR=leerColor();
			double precioR=f.readDouble();
			int stockR=f.readInt();

			System.out.printf("El zapato con ID %d tiene las siguientes propiedades: \nModelo: \"%s\" \nTalla: %d \nColor: \"%s\" \nPrecio de venta: %f.2 ï¿½ \nCantidad en Stock: %d",i,modeloR,tallaR,colorR,precioR,stockR);    

			f.close();
		}

	}

	
	public static void mostrarTallaColor() throws IOException {
		
		f.seek(0);
		while(f.getFilePointer()<f.length()) {
			System.out.println("***********************************************************");
			int i=f.readInt();
			String modelo=leerModelo();
			int talla=f.readInt();
			String color=leerColor();
			double precio=f.readDouble();
			int stock=f.readInt();
			
			System.out.printf("El Modelo de zapato \"%s\" tiene las siguientes propiedades: \nTalla: %d \nColor: \"%s\"",modelo,talla,color);
			System.out.println();
						
			
		}
		System.out.println("***********************************************************");
		System.out.println("Volviendo al menu principal");
		
		
	}
	
	public static void mostrarModelos() throws IOException {
		/*
		 * 150 bytes cada zapato:
		 * 
		 * int ID -> 4 bytes
		 * String Modelo -> 100 bytes
		 * int Talla -> 4 bytes
		 * String color -> 30 bytes
		 * double precio -> 8 bytes
		 * int stock -> 4 bytes
		 * 
		 * 4
		 * 104
		 * 108
		 * 138
		 * 146
		 * 150
		 * 
		 * 154
		 */
		
		f.seek(0);
		ArrayList <String> listaModelos= new ArrayList<>();
		
		long cont = 4;
		while(cont<=f.length()) {
			
			f.seek(cont);
			String modelo=leerModelo();
			
			boolean estaModelo=false;
			for(String m: listaModelos) {
				if(modelo.equalsIgnoreCase(m)) {
					estaModelo=true;
				}
						
			}
			if(!estaModelo) {
				listaModelos.add(modelo);
			}
			
			cont=f.getFilePointer()+50;
							
		}
		
		System.out.println("En la tienda de zapatos hay estos modelos diferentes: ");
		int num=1;
		for(String m: listaModelos) {
			System.out.println(num+" - \""+m+"\"");
			num++;
		}
		System.out.println("Volviendo al menu principal");
		
		
	}
	
	public static void importeTotal() throws IOException {
		f.seek(0);
		
		long cont = 138;
		double precioTotal=0.0;
		double precio=0.0;
		int existencias=0;
		int totalexistencias=0;
		
		while(cont<=f.length()) {
			
			f.seek(cont);
			precio=f.readDouble();
			existencias=f.readInt();
			totalexistencias+=existencias;
			cont=f.getFilePointer()+138;
			precioTotal+=precio*existencias;
			
							
		}
		
		System.out.printf("En la tienda hay en stock %d zapatos con un precio total de %.2f € ",totalexistencias,precioTotal);
		
		
		
		
		
	}
	
	  

	private static String leerModelo() throws IOException {

		char arrayChars[] = new char[50], aux;
		for (int i = 0; i < arrayChars.length; i++) {         
			aux = f.readChar(); 
			arrayChars[i] = aux;    //los voy guardando en el array
		}
		String str = new String(arrayChars);
		str=str.trim();

		return str;
	}
	private static String leerColor() throws IOException {

		char arrayChars[] = new char[15], aux;
		for (int i = 0; i < arrayChars.length; i++) {         
			aux = f.readChar(); 
			arrayChars[i] = aux;    //los voy guardando en el array
		}
		String str = new String(arrayChars);
		str=str.trim();

		return str;
	}
	/*public static void altaZapatos2() throws IOException {
	StringBuffer buffer= null;

	f.writeInt(ID);
	ID++;
	// Este ocupa 4 bytes

	String modelo="Adidas shoes Running";

	buffer = new StringBuffer( modelo);
	buffer.setLength(50);
	f.writeChars(buffer.toString());
	// Este ocupa 100 bytes

	int talla=42;
	f.writeInt(talla);
	// este ocupa 4 bytes

	String color="Negro";
	buffer = new StringBuffer(color);
	buffer.setLength(15);
	f.writeChars(buffer.toString());
	// este ocupa 30 bytes

	double precio=46.55;
	f.writeDouble(precio);
	// este ocupa 8 bytes

	int stock=10;
	f.writeInt(stock);
	// este ocupa 4 bytes

	f.writeInt(ID);
	ID++;

	modelo="Nike Air Force 1";
	buffer = new StringBuffer( modelo);
	buffer.setLength(50);
	f.writeChars(buffer.toString());

	talla=45;
	f.writeInt(talla);

	color="Azul";
	buffer = new StringBuffer(color);
	buffer.setLength(15);
	f.writeChars(buffer.toString());

	precio=59.99;
	f.writeDouble(precio);

	stock=20;
	f.writeInt(stock);

	f.writeInt(ID);
	ID++;

	modelo="Nike Air Force 1";
	buffer = new StringBuffer( modelo);
	buffer.setLength(50);
	f.writeChars(buffer.toString());

	talla=44;
	f.writeInt(talla);

	color="Marron";
	buffer = new StringBuffer(color);
	buffer.setLength(15);
	f.writeChars(buffer.toString());

	precio=89.99;
	f.writeDouble(precio);

	stock=5;
	f.writeInt(stock);


	f.writeInt(ID);
	ID++;

	modelo="Reebok Classic Leather Legazy";
	buffer = new StringBuffer( modelo);
	buffer.setLength(50);
	f.writeChars(buffer.toString());

	talla=46;
	f.writeInt(talla);

	color="Negro";
	buffer = new StringBuffer(color);
	buffer.setLength(15);
	f.writeChars(buffer.toString());

	precio=89.95;
	f.writeDouble(precio);

	stock=12;
	f.writeInt(stock);


	f.writeInt(ID);
	ID++;

	modelo="Adidas Forest Grove";
	buffer = new StringBuffer( modelo);
	buffer.setLength(50);
	f.writeChars(buffer.toString());

	talla=43;
	f.writeInt(talla);

	color="Azul cielo";
	buffer = new StringBuffer(color);
	buffer.setLength(15);
	f.writeChars(buffer.toString());

	precio=79.95;
	f.writeDouble(precio);

	stock=20;
	f.writeInt(stock);


	f.writeInt(ID);
	ID++;

	modelo="Reebok Classic Leather Legazy";
	buffer = new StringBuffer( modelo);
	buffer.setLength(50);
	f.writeChars(buffer.toString());

	talla=42;
	f.writeInt(talla);

	color="Blanco";
	buffer = new StringBuffer(color);
	buffer.setLength(15);
	f.writeChars(buffer.toString());

	precio=90.00;
	f.writeDouble(precio);

	stock=8;
	f.writeInt(stock);



}*/


} // class

/*int i=f.readInt();
System.out.println(f.getFilePointer());
String modeloR=leerModelo();
System.out.println(f.getFilePointer());
int tallaR=f.readInt();
System.out.println(f.getFilePointer());
String colorR=leerColor();
System.out.println(f.getFilePointer());
double precioR=f.readDouble();
System.out.println(f.getFilePointer());
int stockR=f.readInt();
System.out.println(f.getFilePointer());*/

