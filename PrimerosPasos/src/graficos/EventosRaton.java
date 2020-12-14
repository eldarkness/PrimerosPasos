package graficos;

import java.awt.event.MouseAdapter;

/* Curso Java Eventos VIII. Eventos de ratón I. Vídeo 72
 * 
 * Para poder usar los eventos de raton necesitamos trabajar con la interfaz MouseListener que trae 5 metodos que hay que sobreescribir y que tienen el siguiente proposito:
 * mouseClicked(MouseEvent e) -> Se llama a este evento cuando el boton del raton ha sido pulsado y soltado.
 * mousePressed(MouseEvent e) -> Se llama a este evento cuando el boton del raton ha sido pulsado.
 * mouseReleased(MouseEvent e) -> Se llama a este evento cuando el boton del raton ha sido soltado.
 * mouseEntered(MouseEvent e) -> Se llama a este evento cuando el raton entra en el marco.
 * mouseExited(MouseEvent e) -> Se llama a este evento cuando el raton sale del marco
 * 
 * Este ejempo mostrara como se usan estos metodos de la interfaz MouseListener para comprender su funcionamiento pero se puede facilitar su uso haciendo que nuestra clase oyente
 * herede de la clase MouseAdapter si solo queremos usar 1 o 2 de sus metodos y asi no tener que sobreescribir los 5.
 */

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;

public class EventosRaton {

	public static void main(String[] args) {
		
		MarcoRaton mimarco= new MarcoRaton();
		
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

}

class MarcoRaton extends JFrame {
	
	public MarcoRaton () {
		
		setVisible(true);
		
		setBounds(700,300,650,450);
		
		// Como siempre instanciamos un ejemplar de la clase oyente, EventosDeRaton, y con el metodo addMouseListener le indicamos que queremos que sea nuestro oyente.
		EventosDeRaton eventoRaton= new EventosDeRaton();
		
		addMouseListener(eventoRaton);
		
	}
}

//* Implementamos la interfaz MouseListener en nuestra clase oyente EventosDeRaton. Al hacerlo debemos sobreescribir los 5 metodos que esta interfaz incorpora aunque no vayamos a usarlos.

class EventosDeRaton implements MouseListener{

	@Override
	public void mouseClicked(MouseEvent e) {
		
		System.out.println("Has hecho click");
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("Acabas de presionar");
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("Acabas de levantar");
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("Acabas de entrar");
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("Acabas de salir");
	}
	
	
}

/* Podemos hacer que nuestra clase oyente herede de la clase adaptadora MouseAdapter de la siguiente manera y asi no tendriamos que sobreescribir los 5 metodos, sino solo los que vayamos a usar

class EventosDeRaton extends MouseAdapter{
	
	public void mouseClicked(MouseEvent e) {
		
		// System.out.println("Coordenada X: " + e.getX() + ". Coordenada Y: " + e.getY());
		
		System.out.println(e.getClickCount());
			
	}
	
	
}*/
