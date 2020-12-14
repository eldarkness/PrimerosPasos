package poo2;

/* Esta seria la forma logica de declarar un tipo enumerado, que no es mas que declarar un objeto de tipo enum en el que le damos a la hora de crearlo unos valores predefinidos 
 * que luego seran usados por el programa. Este ejemplo esta hecho de la forma mas basica por eso se ha comentado y se ha colocado debajo otra opcion mas compleja, con metodos setters
 * y getters y un constructor en el que el usuario puede interactuar de forma mas activa.
 

public class Uso_Tallas {
	
	enum Talla { MINI, MEDIANO, GRANDE, MUY_GRANDE};		

		public static void main(String[] args) {
		// TODO Auto-generated method stub
		Talla s=Talla.MINI;
		
		Talla m=Talla.MEDIANO;
		
		Talla l=Talla.GRANDE;
		
		Talla xl=Talla.MUY_GRANDE;
	}

}

*/

import java.util.Scanner;

public class Uso_Tallas {
		
		enum Talla{
			
			MINI("S"),MEDIANO("M"),GRANDE("L"),MUY_GRANDE("XL");
			
			private Talla(String abreviatura) {
				
				this.abreviatura=abreviatura;
			}
			
			public String dameAbreviatura() {
				
				return abreviatura;
			}
			
			private String abreviatura;
		}
			

		public static void main(String[] args) {
			
			Scanner entrada= new Scanner(System.in);
			
			System.out.println("Escribe una talla: MINI, MEDIANO, GRANDE, MUY_GRANDE");
			
			String entradaDatos=entrada.next().toUpperCase();
			
			Talla la_talla=Enum.valueOf(Talla.class, entradaDatos);
			
			System.out.println("Talla=" + la_talla);
			
			System.out.println("Abreviatura=" + la_talla.dameAbreviatura());
			
		}
		
}