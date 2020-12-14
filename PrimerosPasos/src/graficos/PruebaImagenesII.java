package graficos;

import java.awt.*;
import javax.imageio.*;
import javax.swing.*;
import java.awt.geom.*;
import java.io.*;

/* Curso Java Aplicaciones grï¿½ficas. Swing X Incluyendo imï¿½genes II. Vï¿½deo 64
 * 
 * 
 * 
 * 
 */


public class PruebaImagenesII  {

	public static void main(String[] args) {
		
		MarcoImagenII mimarco3=new MarcoImagenII();
	}

}

class MarcoImagenII extends JFrame {
	
	public MarcoImagenII (){
		
		setVisible(true);
		
		setBounds(750, 300, 450, 550);
		
		setTitle("Prueba con Imagen");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		LaminaImagenII miLamina=new LaminaImagenII();
		
		add(miLamina);
		
		;
		
	}
}

class LaminaImagenII extends JPanel{
	
	public LaminaImagenII() {
		
		// Metemos la imagen de la ruta especificada a la instancia de tipo File miimagen.		
		File miimagen=new File("src/graficos/imagesII.png");
		
		try {
			
			// Usamos el metodo estatico ImageIO.read() sobre el objeto miimagen para meter esa imagen en la variable imagen de tipo Imagen
			// Seria equivalente a: imagen=ImageIO.read(new File("src/graficos/starwars.jpg")) pero habria que borrar la lina 62 de este programa.
			imagen=ImageIO.read(miimagen);
		}		
		
		//Tenemos que usar la expresion try {} catch () {} para capturar la excepcion que nos devuelve el metodo ImageIO.read() en este caso la excepcion es de tipo IOException 
		catch(IOException e) {
		
			System.out.println("La imagen no se encuentra");
		}
	}
	
	public void paintComponent (Graphics g) {
			
		super.paintComponent(g);
				
		// Declaramos dos variables para almacenar la altura y anchura de la imagen en cuestion, despues la dibujamos con el metodo drawImage()
		int anchuraImagen=imagen.getWidth(this);
		int alturaImagen=imagen.getHeight(this);
		
		g.drawImage(imagen, 0, 0, null);
		
		// Con estos bucles anindados nos aseguramos que se recorre con uno de ellos el eje x y con el otro el eje y y se va copiando la imagen una detras de otra dejasndo una separacion del tamaño de la misma imagen	
		for (int i=0; i<450;i++) {
			
			for (int j=0; j<550; j++) {
				
				// Los dos primeros valores se refieren al punto inicial de la imagen, luego los dos siguientes hacen referencia al ancho y alto de lo que se quiere copiar y los dos ultimos valores a donde se quiere copiar la imagen.
				g.copyArea(0, 0, anchuraImagen, alturaImagen, anchuraImagen*i, alturaImagen*j);
				
			}
		}
		
		
	}
	
	private Image imagen;
	

}