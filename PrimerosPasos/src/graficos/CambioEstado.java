package graficos;

/*	Curso Java Eventos VI Eventos de ventana III. Controlando estado ventana. Vídeo 70
 * 	
 * 	En esta clase conseguiremos que el programa nos informe cada vez que nuestra ventana cambie de estado, para ello usaremos la interfaz WindowStateListener que solo trae un metodo 
 *  para sobreescribir: windowStateChanged(WindowEvent e). Este metodo es capaz de detectar cuando una ventana ha cambiado de estado y ejecutara automaticamente el codigo escrito en el
 *  
 *  Ademas podremos usar los metodos de la clase WindowEvent, getNewState() y getOldState() para que nos devuelvan el estado nuevo de la ventana y el estado anterior de la ventana respectivamente
 *  Para ello necesitamos usar la instancia de tipo WindowEvent (e) que declaramos en la signatura del metodo windowStateChanged para despues poder trabajar con la constante de tipo int que devuelve
 */

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class CambioEstado {

	public static void main(String[] args) {
		
		MarcoEstado mimarco= new MarcoEstado();
		
		mimarco.setTitle("Controlando estado marco");
		
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	

	}

}

class MarcoEstado extends JFrame {
	
	public MarcoEstado () {
		
		setVisible(true);
		
		setBounds(300,300,500,350);
		
		CambiaEstado nuevoEstado= new CambiaEstado();
		
		// Para poner a nuestra clase oyente a la escucha hay que usar esta vez el metodo addWindowStateListener en vez de el addWindowListener puesto que es de un tipo diferente
		addWindowStateListener(nuevoEstado);
		
	
	}
}

// La clase CambiaEstado es la clase oyente para nuestro ejemplo, implementa la interfaz WindowStateListener y debe sobreescribir el metodo windowStateChanged que recibe un parametro de tipo WindowEvent al que denominamos e por defecto.
class CambiaEstado implements WindowStateListener {
	
	//Este metodo ejecutara el codigo de abajo cada vez la ventana cambie de estado
	public void windowStateChanged(WindowEvent e){
		
		//System.out.println("El estado de la ventana ha cambiado");
		
		//System.out.println(e.getNewState());
		
		if(e.getNewState() == Frame.MAXIMIZED_BOTH) {
			
			System.out.println("La ventana ha sido maximizada");
		
		} else if (e.getNewState()==Frame.NORMAL) {
			
			System.out.println("La ventana esta normal");
		
		} else if(e.getNewState()==Frame.ICONIFIED) {
			
			System.out.println("La ventana esta minimizada");
		}
	}
}

