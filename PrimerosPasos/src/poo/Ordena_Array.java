package poo;

import java.util.Arrays;

public class Ordena_Array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] myarray= new int[20];
		
		for (int i=0; i<myarray.length;i++) {
			
			myarray[i]=(int)(Math.round(Math.random()*100));
			
		}
		
		for (int i: myarray) {
			
			System.out.println(i);
			
		}
		
		System.out.println("Voy a ordenar el array");
		Arrays.sort(myarray);
		
		for (int i: myarray) {
			
			System.out.println(i);
		}
		
		
	}

}
