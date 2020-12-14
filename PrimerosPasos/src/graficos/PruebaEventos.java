package graficos;

/*	Curso Java. Eventos I y II. V�deo 65 y 66
 *  Vamos a usar la clase EventObject para manejar el objeto evento y tambien sus subclases ActionEvent y WindowEvent. ActionEvent sirve para manejar eventos que se activan al usar el raton
 *  ya sea click simple, doble click o click derecho. WindowEvent sirve para manejar los eventos que tienen lugar cuando se modifica el tama�o de una ventana ya sea minimizarla, maximizarla etc....
 * 
 */

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class PruebaEventos {

	public static void main(String[] args) {
		
		MarcoBotones mimarco=new MarcoBotones();
		
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 
	}

}

// Creamos una clase que herede de JFrame para luego instanciar en el main un objeto de tipo MarcoConTexto para crear el cuadro

class MarcoBotones extends JFrame{   
	
	public MarcoBotones() {
		
		setVisible(true);
		
		setBounds(700,300,500,300);
		
		setTitle("Botones y Eventos");
		
		// Se instancia un objeto de tipo Lamina y se a�ade al cuadro con la instruccion simple add();
		LaminaBotones miLamina= new LaminaBotones();
		
		add(miLamina);
		
	}
}

// Creamos una clase que heredara de JPanel para poder luego instanciar un objeto que sera la lamina sobre la que escribiremos 

class LaminaBotones extends JPanel implements ActionListener{
		
		// Creamos los 3 objetos de tipo JButton a los que les daremos un nombre especifico en su constructor
		JButton botonAzul=new JButton("Azul");
		
		JButton botonRojo=new JButton("Rojo");
		
		JButton botonAmarillo=new JButton("Amarillo");
		
		
		public LaminaBotones() {
			
			// Añadimos los botones en el constructor de la lamina
			add(botonAzul);
			
			add(botonRojo);
			
			add(botonAmarillo);
			
			// Les asignamos a los botones (nuestro objeto fuente) el metodo addActionListener que es lo que creara el evento que desencadena la accion.
			botonAzul.addActionListener(this);
			
			botonRojo.addActionListener(this);
			
			botonAmarillo.addActionListener(this);
		}
		
		public void actionPerformed(ActionEvent e) {
			
			// Dentro del metodo actionPerformed de la interfaz ActionListener tenemos que cercionarnos de que objeto lanzo la excepcion para saber que accion usar
			// Lo hacemos creando un objeto de tipo Object (la clase cosmica de la que todas las clases heredan por lo que todo es un Object en java) llamado botonPulsado y le decimos que coja 
			// la fuente de la variable e que es la del evento. Despues de esto ya solo tenemos que crear un if para saber que objeto desencadeno el evento y poder realizar la opcion especifica
			Object botonPulsado=e.getSource();
			
			if(botonPulsado==botonAzul) {
				
				setBackground(Color.blue);
			
			} else if (botonPulsado==botonRojo) {
				
				setBackground(Color.red);
				
			} else if (botonPulsado==botonAmarillo) {
				
				setBackground(Color.yellow);
			}
		}
		
		
}
	
	