package graficos;

import java.awt.*;
import javax.swing.*;
import java.awt.geom.*;

/* Curso Java Aplicaciones gráficas. Swing VII. Manejando colores. Vídeo 61
 *
 * A�adiendo colores al frame
 * 
 * Se deben tener en cuenta el metodo setPaint(color) de la clase Graphics2D que sirve para establecer un color a nuestro pincel "g2" (el objeto de tipo Graphics2D)
 *  y la clase Color del paquete java.awt que tiene almacenadas constantes con los colores, aparte de poseer varios constructores para crear nuestros propios colores
 * 
 * Tambien tenemos los metodos setBackground(color) que sirve para colorear el fondo de la lamina y el metodo setForegound(color) que sirve para establecer el color 
 * que sirve para colorear lo que vas a dibujar todo lo que aparezca en la lamina (se vera en la clase TrabajandoConFuentes)
 * 
 */

public class TrabajandoColores {

	public static void main(String[] args) {
		
		MarcoColores mimarco3=new MarcoColores();
	}

}

class MarcoColores extends JFrame {
	
	public MarcoColores (){
		
		setVisible(true);
		
		setSize(800, 600);
		
		setTitle("Marco con colores");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		LaminaColores miLamina= new LaminaColores();
		
		add(miLamina);
		
		miLamina.setBackground(Color.PINK);
		
		// Otra forma de establecer un color de fondo seria con la instruccion: "miLamina.setBackground(SystemColor.window)" lo cual establece el color por defecto del sistema operativo que estemos manejando.
		
		miLamina.setBackground(SystemColor.window);
		
		
		
	}
}

class LaminaColores extends JPanel{
	
	public void paintComponent (Graphics g) {
			
		super.paintComponent(g);
		
		Graphics2D g2=(Graphics2D)g;
		
		// dibujando el rectangulo
		Rectangle2D rectangulo=new Rectangle2D.Double(180, 120, 400, 300);
		
		g2.setPaint(Color.blue);  // Con el metodo setPaint() establecemos un color al pincel y luego con el metodo .draw() dibujamos el contorno del objeto pasado como parametro en el color que le hemos establecido con el metodo anterior
		g2.draw(rectangulo);
		
		g2.setPaint(Color.RED);  // Aqui volvemos a establecer un color nuevo a nuestro pincel y nos disponemos a rellenas dle color especificado el fondo del objeto pasado como parametro
		g2.fill(rectangulo);
		
		// dibujando la elipse
		Ellipse2D elipse= new Ellipse2D.Double();
		elipse.setFrame(rectangulo);
		
		Color miColor= new Color(140,230,255);  // Establecemos el color solo que aqui en vez de usar una constante de clase hemos instanciado un objeto de tipo Color con un color personalizado que aplicaremos en la siguiente instruccion a nuestro "pincel" g2
		g2.setPaint(miColor);					// para luego aplicarlo con el metodo ".fill(). Estas dos ultimas lineas se podrian resumir en "g2.setPaint(new Color(109,172,59).brighter())"
				
		g2.fill(elipse);
		
		
	}
}