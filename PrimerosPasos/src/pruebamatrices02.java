import java.awt.*;

import javax.swing.JOptionPane;

public class pruebamatrices02 {

	public static void main (String [] args ) {

		int [] myarray01 = new int[5];

		myarray01[0]=5;
		myarray01[1]=10;
		myarray01[2]=15;
		myarray01[3]=20;
		myarray01[4]=25;

		int [] myarray02 = new int [Integer.parseInt(JOptionPane.showInputDialog("Introduce el tamaño del array"))];

		for (int i=0; i<myarray02.length; i++) {

			myarray02[i] = Integer.parseInt(JOptionPane.showInputDialog("Dime el valor del indice: " + i));

		}
		

		for (int i=0; i<myarray01.length; i++) {

			System.out.println(myarray01[i]);
		}

		for (int e: myarray02) {

			System.out.println(e);
		}
	
		String [] myarray03 = new String [Integer.parseInt(JOptionPane.showInputDialog("Introduce un tamaño para el Array"))];
		
		for (String z: myarray03) {
			
			z=JOptionPane.showInputDialog("Introduce un nombre");
			System.out.println("Has introducido " + z);
		
		}
	
		
	
	}
}