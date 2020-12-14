import javax.swing.JOptionPane;

public class alturapesoideal {
	
	public static void main(String[] args) {
		
		int altura=Integer.parseInt(JOptionPane.showInputDialog("Dime tu altura en centimetros"));
		
		String sexo = JOptionPane.showInputDialog("Dime tu sexo ('H' Hombre | 'M' Mujer");
		
				
		if (sexo.equalsIgnoreCase("M")) {
			
			System.out.println("Tu peso ideal es " + (altura-120));
		
		} else if (sexo.equalsIgnoreCase("H")) {
			
			System.out.println("Tu peso ideal es " + (altura-110));
		}
	
	
	} //main


}//class
