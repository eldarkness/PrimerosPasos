package graficos;


/*	Curso Java Eventos IV. Eventos de ventana I. Vídeo 68
 * 	En esta clase trataremos los eventos de ventana, esto es, lo que ocurre cuando una ventana es minimizada, cerrada, maximizada etc...
 * 	Para ello hemos modificado la clase base anterior para crear dos marcos, uno mas a la izquierda y el otro a la derecha y a la misma altura. Ademas a uno de ellos se le ha modificado
 *  el metodo setDefaultCloseOperation para que cuando se cierre no acabe el programa, el otro se ha dejado igual para que el programa acabe si se cierra el marco. Ademas se ha cambiado
 *  el constructor para que no asigne por defecto el tamaño y la posicion de estos sino que se ha modificado despues de instanciar el objeto en el main, asi no tenemos cuadros igualesy en el mismo sitio.
 *  
 *  Se ha creado una clase propia que implementa la interfaz WindowListener que nos obliga a sobreescribir 7 metodos, cada uno de ellos responde a un estado que puede tener cualquiera 
 *  de nuestras ventanas: desactivada, activada, minimizada, maximizada, cerrada, abierta etc...
 * 	
 *  
 *  
 */

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Eventos_Ventana {

	public static void main(String[] args) {
		
		// instanciamos primero un MarcoVentana
		MarcoVentana mimarco=new MarcoVentana();
		
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		mimarco.setTitle("Ventana 1");
		
		mimarco.setBounds(300,300,500,350);
		
		MarcoVentana mimarco2= new MarcoVentana();
		
		mimarco2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		 
		mimarco2.setTitle("Ventana 2");
		
		mimarco2.setBounds(900, 300, 500, 350);
	}

}

// Creamos una clase que herede de JFrame para luego instanciar en el main un objeto de tipo MarcoVentana para crear el cuadro

class MarcoVentana extends JFrame{   
	
	public MarcoVentana() {
		
		setVisible(true);
		
		// Se han comentado estas lineas para que no cree dos cuadros iguales en el mismo sitio y con el mismo tamaño y con nombres iguales.
		
		//setBounds(300,300,500,350);
		//setTitle("Respondiendo");
		
		// Se instancia un objeto tipo M_Ventana que sera el parametro que le pasemos al metodo addWindowListener() y sera llamado cada vez que cualquiera de nuestros marcos cambie de estado.
		M_Ventana oyenteVentana = new M_Ventana();
		
		addWindowListener(oyenteVentana);
		
		
		
	}
}

// La clase M_Ventana implementa la interfaz WindowListener y sera nuestra clase oyente, para ello hay que sobreescribir los 7 metodos que trae la interfaz, los vayamos a usar o no.

class M_Ventana implements WindowListener {
	
	// Este metodo sera llamado cada vez que una ventana pase a estar activa
	public void windowActivated(WindowEvent e) {
		
		System.out.println("Ventana activada");
	}
	
	// Este metodo sera llamado cada vez que una ventana sea cerrada, aunque no avisara con la ultima ventana puesto que el programa finalizara y no dara tiempo a lanzar el mensaje
	public void windowClosed(WindowEvent e) {
		
		System.out.println("La ventana ha sido cerrada");
	}
	
	// Este metodo sera llamado cada vez que una ventana se "empiece" a cerrar
	public void windowClosing(WindowEvent e) {
		
		System.out.println("Cerrando ventana");
	}
	
	// Este metodo sera llamado cada vez que una ventana pase a estar desactivada
	public void windowDeactivated(WindowEvent e) {
		
		System.out.println("Ventana desactivada"); 
	}
	
	// Este metodo sera llamado cada vez que una ventana pase a estar maximizada
	public void windowDeiconified(WindowEvent e) {
		
		System.out.println("Ventana restaurada");
		
	}
	
	// Este metodo sera llamado cada vez que una ventana pase a estar minimizada
	public void windowIconified(WindowEvent e) {
		
		System.out.println("Ventana minimizada");
		
	}
	
	// Este metodo sera llamado cada vez que una ventana se abra
	public void windowOpened(WindowEvent e) {
		
		System.out.println("Ventana abierta");
	} 
}