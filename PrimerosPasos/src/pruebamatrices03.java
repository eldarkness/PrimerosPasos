import javax.swing.*;

public class pruebamatrices03 {

	public static void main (String [] args) {

		// Vamos a crear dos arrays bidimensionales, uno de tipo int y otro de tipo String

		int [][] myarraybi = new int [2][3];

		myarraybi[0][0]=10;
		myarraybi[0][1]=20;
		myarraybi[0][2]=30;
		myarraybi[1][0]=40;
		myarraybi[1][1]=50;
		myarraybi[1][2]=60;

		for (int [] e: myarraybi) {
			
			for (int z: e) {

				System.out.println(z);
			
			}
		}
		
		String [][] myarraybi02= new String [Integer.parseInt(JOptionPane.showInputDialog("Especifica el tamaño del array de tipo String (eje x"))][Integer.parseInt(JOptionPane.showInputDialog("Especifica el tamaño del array de tipo String (eje y)"))];
		
		
	}
}

