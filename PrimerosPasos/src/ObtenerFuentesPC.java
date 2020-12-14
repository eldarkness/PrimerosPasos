

import java.awt.GraphicsEnvironment;
import javax.swing.*;

public class ObtenerFuentesPC {

	public static void main(String[] args) {
		
		String [] nombresDeFuentes = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
		
		String fuente= JOptionPane.showInputDialog("Introduce un nombre de fuente");
		boolean estaLaFuente= false;
				
		for(String e: nombresDeFuentes) {
			
			System.out.println(e);
			
			if(e.equals(fuente)) {
				
				estaLaFuente=true;
			}
		
		}
	
		if(estaLaFuente) {
			
			System.out.println("La fuente esta instalada en el sistema");
		} else {
			
			System.out.println("La fuente no esta instalada en el sistema");
		}
	}
}
