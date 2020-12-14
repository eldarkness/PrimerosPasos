import java.util.*;

import javax.swing.JOptionPane;

/*
 * 1 Crear un array de N elementos (crearlo por teclado o de forma aleatoria), 2 ordenarlo de mayor a menor y viceversa.
 * 3 Buscar el n�x (se pedira por consola) en el array y si existe hallar su factorial y fibonacci. En caso que no se pueda
 * o no exista el numero u otro tipo de error informar siempre al usuario.
 */
public class Ejemplo06 {

	public static void main(String[] args) {
		
		// 1. Crea un array y le pedimos al usuario que introduzca los datos
		int [] myarray= new int[Integer.parseInt(JOptionPane.showInputDialog("Introduce tamano de array"))];
		for (int i=0; i<myarray.length;i++) {
			myarray[i]=Integer.parseInt(JOptionPane.showInputDialog("Introduce el valor para el indice: "+ i));
			System.out.println(myarray[i]);
		}
		
		// 2. Ordena el array
		Arrays.sort(myarray);
		
		System.out.println("Te ordeno el array: ");
		for (int i=0; i<myarray.length;i++) {
		
			System.out.println("\t"+myarray[i]);
		}
		
		// 3. Pide un numero al usuario y lo busca en el array si existe dentro del array lanza metodos factorial y fibonacci 
		int cont=0;
		int num1=0;
		do {
			num1=Integer.parseInt(JOptionPane.showInputDialog("Introduce un numero y si lo encuentro en el array te hago su factorial y su fibonaci (introduce 0 para salir)"));
			
			for (int i=0; i<myarray.length;i++) {
				
				if(num1==myarray[i]) {
					cont++;
					break;
				}
			}
			
			if(cont==1) {
				// Factorial
				System.out.println("El factorial de " + num1 + " es " +Factorial(num1));// Factorial
				// Fibonazzi
				Fibonacci(num1);
				cont=0;
			} else if (cont==0 && num1!=0) {
				System.out.println("El numero no se encuentra en el array introduce otro");
			}
			
		} while(num1!=0);
		
		System.out.println("Programa terminado");
		
	}
	
	public static int Factorial(int num) {
		
		int resultado=1;  // Se declara la variable
		int numero=num;
		if ( numero<0) {  // En esta primera parte del if se comprueba si el numero es negativo para sacar el mensaje pertinente
			System.out.println("El numero debe ser 0 o mayor");
		} else if (numero==0) { // Aqui se comprueba si el numero es 0 para dar la respuesta personalizada
			System.out.println("El factorial de 0 es 1 por convenio");
		} else { // Sino se cumple nada de lo anterior se ejecuta esta parte que es la que tiene mas importancia del ejercicio
			
			for (int i=numero; i>0; i--) {
				resultado=resultado*i;
			}	// Fin del bucle for
		} // Fin del if
		return resultado;
	}
	
	public static int Fibonacci(int numero) {
		
		int num=numero;
		int fibonacci=0;
				
			if(num==0) {
				System.out.println("La sucesion para el numero " + num+ " es 0");
			} else if (num==1) {
				System.out.println("La sucesion para el numero " + num+ " es 1");
			} else if (num==2) {
				System.out.println("La sucesion para el numero " + num+ " es 1");
			} else if (num==3) {
				System.out.println("La sucesion para el numero " + num+ " es 2");
			} else if (num>3) {
				fibonacci=Fibonacci(num-1)+Fibonacci(num-2);
				System.out.println("La sucesion para el numero " + num+ " es " + fibonacci);
			} // Fin del if-else anidado
			
			return fibonacci;
		} 

		
} // class 

