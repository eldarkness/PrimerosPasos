package graficos;

/*	Curso Java. Eventos I y II. V�deo 65 y 66
 *  Vamos a usar la clase EventObject para manejar el objeto evento y tambien sus subclases ActionEvent y WindowEvent. ActionEvent sirve para manejar eventos que se activan al usar el raton
 *  ya sea click simple, doble click o click derecho. WindowEvent sirve para manejar los eventos que tienen lugar cuando se modifica el tama�o de una ventana ya sea minimizarla, maximizarla etc....
 * 
 */

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class PruebaEventosII {

	public static void main(String[] args) {
		
		MarcoBotonesII mimarco=new MarcoBotonesII();
		
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 
	}

}

// Creamos una clase que herede de JFrame para luego instanciar en el main un objeto de tipo MarcoConTexto para crear el cuadro

class MarcoBotonesII extends JFrame{   
	
	public MarcoBotonesII() {
		
		setVisible(true);
		
		setBounds(700,300,500,300);
		
		setTitle("Botones y Eventos");
		
		// Se instancia un objeto de tipo Lamina y se a�ade al cuadro con la instruccion simple add();
		LaminaBotonesII miLamina= new LaminaBotonesII();
		
		add(miLamina);
		
	}
}

// Creamos una clase que heredara de JPanel para poder luego instanciar un objeto que sera la lamina sobre la que escribiremos 

class LaminaBotonesII extends JPanel{
		
		// Creamos los 3 objetos de tipo JButton a los que les daremos un nombre especifico en su constructor
		JButton botonAzul=new JButton("Azul");
		
		JButton botonRojo=new JButton("Rojo");
		
		JButton botonAmarillo=new JButton("Amarillo");
		
		
		public LaminaBotonesII() {
			
			// Añadimos los botones en el constructor de la lamina
			add(botonAzul);
			
			add(botonRojo);
			
			add(botonAmarillo);
			
			// Creamos las 3 instancias de la clase ColorFondo, estos ejemplares de clase pasaran el argumento Color.* al constructor para cada objeto de la clase
			
			ColorFondo Amarillo= new ColorFondo(Color.yellow);
			
			ColorFondo Azul=new ColorFondo(Color.blue);
			
			ColorFondo Rojo=new ColorFondo(Color.red);
			
			// Les asignamos a los botones (nuestro objeto fuente) el metodo addActionListener que es lo que creara el evento que desencadena la accion. 
			// Al hacerlo se llamara al metodo public void actionPerformed de la clase ColorFondo para cada objeto (Azul, Rojo o Amarillo).
			botonAzul.addActionListener(Azul);
			
			botonRojo.addActionListener(Rojo);
			
			botonAmarillo.addActionListener(Amarillo);
		}
		
		// Declaramos una clase interna que implementa la interfaz ActionListener y que recibe en el constructor un parametro de tipo Color. Este parametro recibira un argumento de tipo color que sera creado en cada ejemplar de la clase 
		private class ColorFondo implements ActionListener{
			
			// El constructor da un estado inicial a cada ejemplar de clase dandole un valor a la variable encapsulada colorDeFondo en base al argumento que se pasa cuando se instancia un objeto de esta clase.
			public ColorFondo(Color c) {
				
				colorDeFondo=c;
				
			}
			
			// Este metodo es llamado cada vez que se pulsa uno de los botones de la lamina y segun el ejemplar de clase que se le pase como argumento la variable colorDeFondo tendra un color almacenado u otro.
			public void actionPerformed (ActionEvent e) {
				
				setBackground(colorDeFondo);
			}
			
			private Color colorDeFondo;
			
		}
}


