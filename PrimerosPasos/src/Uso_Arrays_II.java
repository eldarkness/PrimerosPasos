import  javax.swing.*;

public class Uso_Arrays_II {

	public static void main(String[] args) {
		
		String [] paises=new String[8];
		
		for(int i=0; i<8; i++) {
			
			paises[i]=JOptionPane.showInputDialog("Introduce un pais " + (i+1));
			
		}		
		
				
		int num=0;
		
		for(String elemento:paises) {
			
			System.out.println("El pais " + num + " es: " + elemento);
			num++;
		}
		
		/*paises[0]="España";
		paises[1]="Mexico";
		paises[2]="Colombia";
		paises[3]="Perú";
		paises[4]="Chile";
		paises[5]="Argentina";
		paises[6]="Ecuador";
		paises[7]="Venezuela";
		
				
		for (int i=0; i<paises.length; i++ ) {
			
			System.out.println("El pais " + (i+1) + " es " + paises[i]);
		
		}
		
		String[] paises= {"España","Mexico","Colombia","Peru","Chile","Argentina",
		"Ecuador","Venezuela"};*/	
	}

}
