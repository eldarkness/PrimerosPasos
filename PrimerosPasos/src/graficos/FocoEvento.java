package graficos;

import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.*;

/*	Curso Java Eventos X. Eventos de foco. Vídeo 74 (y mitad video 75)
 * 	
 *	En esta clase veremos como desencadenar eventos cuando un componente dentro de un cuadro gane o pierda el foco. Lo haremos con un ejemplo en el que usaremos un cuadro de tipo JTextField 
 *	para comprobar si una direccion de email es valida.
 *
 *	Usaremos una clase que hereda de JFrame y una lamina que heredara de JPanel, tal y como hemos hecho anteriormente, en la que añadiremos dos ejemplares de la clase JTextField que son 
 *	dos cuadros de texto en los que podemos escribir cualquier cosa. Uno de esto cuadros sera nuestro objeto fuente y le añadiremos un oyente que sera de la clase LanzaFocos que implementara
 *	la interfaz FocusListener y que encapsularemos dentro de la clase de la Lamina.
 *
 * 	Para que los metodos de la interfaz puedan acceder al objeto de tipo JTextField o sea a nuestros cuadros de texto, estos deben ser declaramos dentro de la clase LaminaFoco pero fuera
 *  del metodo paintComponent que es el que usaremos para "escribir" estos cuadros en la lamina.
 *  
 */

public class FocoEvento {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MarcoFoco mimarco= new MarcoFoco();
		
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}

class MarcoFoco extends JFrame{
	
	public MarcoFoco() {
		
		setVisible(true);
		
		setBounds(300,300,600,450);
		
		add(new LaminaFoco());
		
	} 
}

class LaminaFoco extends JPanel{
	
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		
		setLayout(null);
		
		cuadro1=new JTextField();
		
		cuadro2=new JTextField(); 
		
		cuadro1.setBounds(120, 10, 150, 20);
		
		cuadro2.setBounds(120, 50, 150, 20);
		
		add(cuadro1);
		
		add(cuadro2);
		
		LanzaFocos elFoco= new LanzaFocos();
		
		cuadro1.addFocusListener(elFoco);
		
	}
	
	private class LanzaFocos implements FocusListener{

		@Override
		public void focusGained(FocusEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void focusLost(FocusEvent e) {
			
			String email=cuadro1.getText();
			
			boolean comprobacion=false;
			
			for(int i = 0; i<email.length() ;i++) {
				
				if(email.charAt(i)=='@') {
					
					comprobacion=true;
				}
				
			}
			
			if(comprobacion) {
				
				System.out.println("Email correcto");
				
			}else {
				
				System.out.println("No es correcto");
			}
			
			
		}
		
		
	}
	
	// Las variables de tipo JTextField se declaran fuera del constructor (y de los demas metodos) para que el metodo focusLost de la clase Lanzafocos pueda acceder a ellas
	JTextField cuadro1;
	
	JTextField cuadro2;
}

