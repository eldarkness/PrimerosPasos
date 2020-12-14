import java.util.Scanner;
import javax.swing.*;

public class dosNumerosYOpe {

	public static void main(String[] args) {
		
		/*int num1=new Scanner(System.in).nextInt();
		int num2=new Scanner(System.in).nextInt();
		String signo=new Scanner(System.in).nextLine();
		
		switch(signo){
		
		case "/":
			System.out.println(num1 + " entre " + num2 + " es igual a: " + (num1/num2));
			
		}
		
		
		
		System.out.println();*/
		
		
		/*System.out.println("asdaihds");
		String cadena= new Scanner (System.in).nextLine();
		
		if (cadena.charAt(0)=='S') {
			
			
			
		}*/
		Scanner teclado=new Scanner(System.in);
		
		int[] myarray= new int[Integer.parseInt(JOptionPane.showInputDialog("Introduce el tamaño del array"))];
			
		int sumatotal=0;
		double media=0;
		
		for (int i=0;i<myarray.length;i++) {
			System.out.println("Introduce");
			myarray[i]=teclado.nextInt();
		}
		for (int i=0;i<myarray.length;i++) {
			sumatotal=sumatotal+myarray[i];
		}
		
		System.out.println(sumatotal);
		
		
		media=(double)sumatotal/(myarray.length);
		
		System.out.println("La media de los numeros introducidos es " + media);
	}
}


