import java.util.Scanner;

public class nummayoromenor {
	public static void main(String[] args) {
		
		int num1,num2,num3,nummayor,nummenor=0;
		
		num1=new Scanner(System.in).nextInt();
		num2=new Scanner(System.in).nextInt();
		num3=new Scanner(System.in).nextInt();
	
		if( num1>num2) {
			nummayor=num1;
			nummenor=num2;
		} else {
			nummayor=num2;
			nummenor=num1;
		}
	
		if( num3>nummayor) {
			nummayor=num3;
			
		} else if (num3<nummenor) {
			nummenor=num3;
			
		}
		
		System.out.println("El numero mayor es " + nummayor + " y el menor es " + nummenor);
	}
}