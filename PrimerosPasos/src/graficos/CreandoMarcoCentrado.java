package graficos;
 
/* Curso Java. Aplicaciones gráficas. Swing II. Colocando el Frame. Vídeo 57
 * 
 * Pasos para crear un marco (ventana o cuadro) de la mitad del tamaÃ±o de nuestro monitor y posicionado en el centro de la pantalla
 * Se necesitan la clase javax.swing.JFrame y las clases Toolkit y Dimension del paquete java.awt
 * 
 * Metodo a usar de la Clase Toolkit:
 *
 *	getDefaultToolkit();
 *	getScreenSize();
 *
 */

import javax.swing.JFrame;

import java.awt.*;

public class CreandoMarcoCentrado {

	public static void main(String[] args) {
		
		MarcoCentrado mimarco= new MarcoCentrado();
		
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mimarco.setVisible(true);
	}

}

class MarcoCentrado extends JFrame{
	
	public MarcoCentrado (){
		
		// Primero usamos el metodo getDefaultToolkit() que devuelve un objeto de tipo Toolkit con la informacion de nuestro display
		Toolkit mipantalla = Toolkit.getDefaultToolkit();
		// Pasamos la resolucion de nuestra pantalla con el metodo getScreenSize a un objeto de tipo Dimension del paquete java.awt
		Dimension tamanoPantalla= mipantalla.getScreenSize();
		// Ahora necesitamos extraer el ancho y alto (width y height)
		int alturaPantalla=tamanoPantalla.height;
		int anchoPantalla=tamanoPantalla.width;
		
		setSize(anchoPantalla/2,alturaPantalla/2);  // Con esta primera linea establecemos el tamaï¿½o de nuestro marco que sera de la mitad del ancho de nuestra pantalla y la mitad del alto de la misma
		setLocation(anchoPantalla/4,alturaPantalla/4);  // Aqui hacemos que el cuadro se coloque en 1/4 del ancho de la pantalla y 1/4 del alto de la misma
		
		setTitle("Marco Centrado");  // Cambiamos el titulo del marco
		
		Image miIcono=mipantalla.getImage("starwars2.jpg"); // Primero instanciamos un objeto de tipo imagen que recibira del metodo getImage una imagen externa de la carpeta de nuestro proyecto.
														// El icono puede ir en formato ".gif", ".png" o ".jpg". Si se pone por defecto en el directorio raiz del proyecto solo hay que poner el nombre en el String
		 												// pero si lo movemos a un paquete especifico hay que especificar la ruta de la imagen por ejemplo "/src/graficos/icono.gif"
		
		setIconImage(miIcono);		// Con este metodo cambiamos la imagen del icono de las ventanas al que le pasamos por parametro que es nuestro objeto de tipo imagen.
		
	}
}
