import javax.swing.*;

public class Acceso_Aplicacion {

	public static void main(String[] args) {
		
		String clave="Arturo";
		
		String pass="";
			
		while (clave.contentEquals(pass)==false) {
		
			pass=JOptionPane.showInputDialog("Introduce la contrase�a por favor");
			
			if(clave.equals(pass)==false) {
				
				System.out.println("Contrase�a incorrecta");
				
							
			}
		
		}

		System.out.println("Acceso permitido");
	
	}

}