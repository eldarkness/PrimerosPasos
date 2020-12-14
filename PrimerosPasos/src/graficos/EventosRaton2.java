package graficos;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;

/* Curso Java Eventos IX. Eventos de ratón II. Vídeo 73
 * 
 * En esta clase trataremos de forma mas avanzada la clase MouseEvent para obtener por ejemplo la posicion X e Y del raton cuando ocurra un evento o cuantas veces hizo click el usuario 
 * 
 * Para ello usaremos los metodos getX() y getY() de la clase MouseEvent y el metodoo getClickCount()
 * 
 * Tambien podemos saber que boton del raton fue pulsado con el metodo getModifiersEx() y las constantes de clase BUTTON1_DOWN_MASK, BUTTON2_DOWN_MASK, BUTTON3_DOWN_MASK que la clase MouseEvent hereda de InputEvent.
 * 
 * 
 */

public class EventosRaton2 {

	public static void main(String[] args) {
		
		MarcoRaton2 mimarco= new MarcoRaton2();
		
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

}

class MarcoRaton2 extends JFrame {
	
	public MarcoRaton2 () {
		
		setVisible(true);
		
		setBounds(700,300,650,450);
		
		// Como siempre instanciamos un ejemplar de la clase oyente, EventosDeRaton, y con el metodo addMouseListener le indicamos que queremos que sea nuestro oyente.
		EventosDeRaton2 eventoRaton= new EventosDeRaton2();
		
		addMouseListener(eventoRaton);
		addMouseMotionListener(new EventosDeRaton3());
		
	}
}

// Podemos hacer que nuestra clase oyente herede de la clase adaptadora MouseAdapter de la siguiente manera y asi no tendriamos que sobreescribir los 5 metodos, sino solo los que vayamos a usar

class EventosDeRaton2 extends MouseAdapter{
	
	public void mouseClicked(MouseEvent e) {
		
		// System.out.println("Coordenada X: " + e.getX() + ". Coordenada Y: " + e.getY());
		
		System.out.println(e.getClickCount());
			
	}
	
	public void mousePressed(MouseEvent e) {
		
		if(e.getModifiersEx()==MouseEvent.BUTTON1_DOWN_MASK) {
			
			System.out.println("Has pulsado el boton izquierdo");
		
		} else if (e.getModifiersEx()==MouseEvent.BUTTON2_DOWN_MASK) {
			
			System.out.println("Has pulsado la rueda central");
			
		} else if (e.getModifiersEx()==MouseEvent.BUTTON3_DOWN_MASK) {
			
			System.out.println("Has pulsado el boton derecho");
		
		}
	}

}

class EventosDeRaton3 implements MouseMotionListener{

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("Estas arrastrando");
				
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("Estas moviendo el raton");
	}
	
	
}



