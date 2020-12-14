package graficos;

import java.awt.*;
import javax.swing.*;
import java.awt.geom.*;

/* Curso Java. Aplicaciones gráficas. Swing VIII. Cambiando la letra en el Frame. Vídeo 62
 * 
 * En esta clase cambiaremos el tipo, el tamaño y el estilo de la fuente que vamos a utilizar, asi como su color.
 * 
 * Usaremos el metodo setFont(Fuente) de la clase Graphics2D para establecer un tipo de fuente para la letra y tambien el metodo setColor(Color) para establecer un color al igual que haciamos 
 * para dibujar las figuras por lo que necesitaremos nuestro objeto instanciado "g2" de la clase Graphics2D.
 * Tambien usaremos el metodo constructor de la clase Font, que recibe 3 parametros: Font(tipo, estilo, tamaño).
 * Y para finalizar usaremos el metodo drawString("Frase a escribir", pos x, pos y) para escribir lo que queramos con la fuente y el color especificadas previamente.
 * 
 * Tambien se usara el metodo setForeground(Color) mencionado anteriormente para comprobar que se puede estableces un color predefinido a todo lo qque se vaya a escribir encima de la lamina.
 * Este metodo se puede usar tanto en la clase de tipo JPanel (la lamina) directamente o en la clase de tipo JFrame usando la instancia de clase miLamina.
 * 
 */

public class TrabajandoConFuentes {

	public static void main(String[] args) {
		
		MarcoConFuentes mimarco3=new MarcoConFuentes();
	}

}

class MarcoConFuentes extends JFrame {
	
	public MarcoConFuentes (){
		
		setVisible(true);
		
		setSize(400, 400);
		
		setTitle("Prueba con fuentes");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		LaminaConFuentes miLamina=new LaminaConFuentes();
		
		add(miLamina);
		
		miLamina.setForeground(Color.blue);
		
	}
}

class LaminaConFuentes extends JPanel{
	
	public void paintComponent (Graphics g) {
			
		super.paintComponent(g);
		
		Graphics2D g2=(Graphics2D)g;
				
		// Vamos a escribir Juan con el tipo de letra courier en negrita, de tamaño 26 y en color azul.
		Font miFuente= new Font("Courier", Font.BOLD, 26);
		
		g2.setFont(miFuente);
		
		g2.setColor(Color.BLUE);
		
		g2.drawString("Juan", 100,100);
		
		// Ahora vamos a escribir Curso de Java con el tipo de letra arial en cursiva, de tamaño 24 y en el color especificado en el constructor, un poco mas abajo	del nombre anterior
		g2.setFont(new Font("Arial", Font.ITALIC, 24));
		
		g2.setColor(new Color(128,90,50).brighter());
		
		g2.drawString("Curso de Java", 100, 200);
		
	}
}