
public class Ejemplo_Array_2D {

	public static void main(String[] args) {
		
		double acumulado;
		double interes=0.1;

		double [][] saldo=new double[6][5];
	
			for (int i=0; i<6;i++) { // Funciona de la siguiente manera en la primera vuelta pone el valor 0,0 de la matriz a 10000 y 
			
			saldo[i][0]=10000;
			acumulado=10000;
			
				for(int j=1;j<5;j++) { // Al entrar en este segundo bucle for, lo que hace es sumar el interes gracias a la formula acumulado+(acumulado*interes) en los valores de la matriz 0,1; 0,2; 0,3; 0,4
								   //saltandose el valor 0,0 que ya habia sido rellenado de primeras.
				 				
				acumulado=acumulado+(acumulado*interes);
				
				saldo[i][j]=acumulado;
		
				}
			
			interes=interes+0.01; // Esta sentencia hace que cada vez que se recorre una columna de la matriz cambia el interes por lo que cuando el interprete vuelva al primer bucle se repita todo el 
									// proceso pero esta vez aplicandole un 0.01 mas de interes a la base y asi consecutivamente hastya que llegue al valor de matriz 6,5
			}
		
			
			for (int z=0;z<6;z++){
				
				for(int h=0;h<5;h++) {
					
					System.out.printf("%1.2f", saldo[z][h]);
					
					System.out.print(" ");
				}
			
				System.out.println();
			}
			
			System.out.println();
			System.out.println();

			for(double[] elemental:saldo) {
			
				for(double i:elemental) {
				
					System.out.printf("%1.2f", i);
					System.out.print(" ");
				
				}
		
				System.out.println();
			}
		

	}

}
