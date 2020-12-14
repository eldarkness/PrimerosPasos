import javax.swing.*;

public class Acceso_Aplicacion {

	public static void main(String[] args) {
		
		String clave="Arturo";
		
		String pass="";
			
		while (clave.contentEquals(pass)==false) {
		
			pass=JOptionPane.showInputDialog("Introduce la contraseña por favor");
			
			if(clave.equals(pass)==false) {
				
				System.out.println("Contraseña incorrecta");
				
							
			}
		
		}

		System.out.println("Acceso permitido");
	
	}

}