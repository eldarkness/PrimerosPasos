package graficos;

import java.awt.*;
import javax.imageio.*;
import javax.swing.*;
import java.awt.geom.*;
import java.io.*;

/* Curso Java Aplicaciones gr�ficas. Swing X Incluyendo im�genes I. V�deo 63
 * 
 * En esta clase se muestra como importar una imagen de nuestro PC a nuestro programa de java. Para ello primero tenemos que importar el archivo a un objeto de tipo File (paquete java.io)usando su constructor
 *  indicandole en los parametros del mismo la ruta de la imagen, p.e: "new File("src/graficos/nombreimagen.jpg")". Luego instanciamos un objeto de la clase Imagen (paquete java.awt) 
 *  y usamos el metodo estatico .read(File f) de la clase javax.imageio.ImageIO al que le pasamos por parametro la variable de tipo File que contiene la imagen a importar. Una vez hecho esto podemos usar 
 *  la variable g de tipo Graphics con el metodo .drawImage(imagen, x, y, observer) de la clase Graphics, donde en imagen ponemos el nombre de la variable de tipo Imagen, luego con X e Y establecemos unas coordenadas
 *  y en observer establecemos null ya que no queremos de momento que nos informe de cuanto % de la imagen le queda para terminar de cargarla en la lamina.
 *  
 * Otra cosa a tener en cuenta es que el metodo .read(File f) devuelve una excepcion que hay que capturar y procesar. Para ello usamos las palabras reservadas try {...} catch (Excepcion) {...} en donde escribiremos
 * entre los corchetes del try la sentencia read() tal y como hemos visto luego en los parentesis del catch pondremos la excepcion que nos tira que es IOExcepcion e y en los corchetes del catch tenemos que especificar 
 * como queremos que el programa actue si por ejemplo cuando va a leer el fichero este no exista, en este caso ponemos una instruccion simple que nos muestre un mensaje que diga que no se ha podido encontrar la imagen.
 * 
 * 
 */


public class PruebaImagenesI  {

	public static void main(String[] args) {
		
		MarcoImagen mimarco3=new MarcoImagen();
	}

}

class MarcoImagen extends JFrame {
	
	public MarcoImagen (){
		
		setVisible(true);
		
		setBounds(750, 300, 250, 350);
		
		setTitle("Prueba con Imagen");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		LaminaImagen miLamina=new LaminaImagen();
		
		add(miLamina);
		
		;
		
	}
}

class LaminaImagen extends JPanel{
	
	public void paintComponent (Graphics g) {
			
		super.paintComponent(g);
		
		// Metemos la imagen de la ruta especificada a la instancia de tipo File miimagen.		
		File miimagen=new File("src/graficos/starwars2.jpg");
		
		try {
			
			// Usamos el metodo estatico ImageIO.read() sobre el objeto miimagen para meter esa imagen en la variable imagen de tipo Imagen
			// Seria equivalente a: imagen=ImageIO.read(new File("src/graficos/starwars.jpg")) pero habria que borrar la lina 62 de este programa.
			imagen=ImageIO.read(miimagen);
		}
		
		//Tenemos que usar la expresion try {} catch () {} para capturar la excepcion que nos devuelve el metodo ImageIO.read() en este caso la excepcion es de tipo IOException 
		catch(IOException e) {
		
			System.out.println("La imagen no se encuentra");
		}
		
		// Dibujamos finalmente la imagen con el metodo drawImage pasandole como parametro la imagen en el objeto instanciado de tipo Imagen, las coordenadas (x e Y) 
		// y finalmente un objeto de tipo observador que en nuestro caso sera null porque no queremos que nos avise del progreso en % que lleva de carga el archivo.
		g.drawImage(imagen, 5, 5, null);
		
	}
	
	private Image imagen;
	

}