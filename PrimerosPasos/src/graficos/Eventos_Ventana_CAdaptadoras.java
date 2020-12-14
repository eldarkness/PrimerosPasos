package graficos;


/*	Curso Java Eventos V Eventos de ventana II. Clases Adaptadoras. Video 69
 * 	
 * 	Las clases adaptadoras sirven para no tener que sobreescribir todos los metodos de las interfaces que vamos a implementar ya que muchos de esos metodos no los vamos a usar por lo que simplificamos codigo y ahorramos tiempo
 * 
 * 	Hay 3 clases adaptadoras cada una relacionada con un tipo de eventos: 
 * 	WindowAdapter para eventos de ventana.
 * 	MouseAdapter para eventos de raton.
 * 	KeyAdaptar para eventos de teclado
 * 
 * 	Para ello tenemos que, desde nuestra clase Oyente, heredar de una de esas clases para que asi herede todos sus metodos, y luego sobreescribir solo los que vayamos a usar.
 *  
 *  
 */

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Eventos_Ventana_CAdaptadoras {

	public static void main(String[] args) {
		
		// Instanciamos primero un MarcoVentana2
		MarcoVentana2 mimarco=new MarcoVentana2();
		
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		mimarco.setTitle("Ventana 1");
		
		mimarco.setBounds(300,300,500,350);
		
		MarcoVentana2 mimarco2= new MarcoVentana2();
		
		mimarco2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		 
		mimarco2.setTitle("Ventana 2");
		
		mimarco2.setBounds(900, 300, 500, 350);
	}

}

// Creamos una clase que herede de JFrame para luego instanciar en el main un objeto de tipo MarcoVentana2 para crear el cuadro

class MarcoVentana2 extends JFrame{   
	
	public MarcoVentana2() {
		
		setVisible(true);
		
		// Se han comentado estas lineas para que no cree dos cuadros iguales en el mismo sitio y con el mismo tamaño y con nombres iguales.
		
		//setBounds(300,300,500,350);
		//setTitle("Respondiendo");
		
		// Tambien se ha simplificado el codigo de aqui para mostrar como se puede instanciar un objeto de tipo M_VEntana2, que es nuestro oyente, sin tener que usar varias lineas instanciandolo directamente dentro del metodo addWindowListener().
		addWindowListener(new M_Ventana2());
		
		
	}
}

// Como hemos hecho que nuestro objeto oyente M_Ventana2 herede de WindowAdapter ya no necesitamos sobreescribir todos los metodos de la interfaz que estamos usando (en nuestro caso WindowListener) sino que solo reemplazamos los metodos que queremos usar.

class M_Ventana2 extends WindowAdapter {
	
	// Este metodo sera llamado cada vez que una ventana pase a estar minimizada
	public void windowIconified(WindowEvent e) {
		
		System.out.println("Ventana minimizada");
		
	}
	
}