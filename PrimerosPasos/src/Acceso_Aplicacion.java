import javax.swing.*;

public class Acceso_Aplicacion {

	public static void main(String[] args) {
		
		String clave="Arturo";
		
		String pass="";
			
		while (clave.contentEquals(pass)==false) {
		
			pass=JOptionPane.showInputDialog("Introduce la contraseņa por favor");
			
			if(clave.equals(pass)==false) {
				
				System.out.println("Contraseņa incorrecta");
				
							
			}
		
		}

		System.out.println("Acceso permitido");
	
	}

}