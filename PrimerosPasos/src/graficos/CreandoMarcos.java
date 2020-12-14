package graficos;

/* Curso Java. Aplicaciones gr�ficas Swing I. V�deo 55 y 56
 * 
 * Los ventanas o marcos (frames en ingles) son interfaces de usuario que vienen en el paquete javax.swing. Dentro de ese paquete hay una clase llamada JFrame que hereda de la clase Frame
*  del paquete java.awt la cual usa ventanas predefinidas por el S.O. para crear esas interfaces por eso se extendio la clase para permitir al usuario crear sus propias interfaces
*
*	Caracteristicas de los frames:
*
*	-Nacen invisibles. Se necesita el metodo setVisible para hacerlos visibles
*	-Nacen con un tamaño inutil (de 0x0 pixeles). Se necesita el metodo setSize para darles tamaño
*	-Conviene decir que debe hacer el programa si se cierra un frame.
*	-Por defeecto aparecen en la esquina superior izq pero se puede cambiar esto usando la clase Toolkit para captar la resolucion del ordenador donde se va a ejecutar el programa y luego especificandole el punto exacto.
*	-Tambien se puede poner un titulo al cuadro, que por defecto no tiene.
*
*	Metodos utiles de la clase JFrame (suyos propios y heredados)
*	
*	setVisible(); -> Para hacer visible el cuadro que por defecto nace invisible
*	setLocation(x,y); -> Para darle una localizacion al cuadro (por defecto esquina superior izquierda)
*	setSize(int ancho, int alto); -> Para darle un tamaño (por defecto 0x0 pixeles)
*	setBounds(x,y,int ancho,int largo); -> Union de los dos metodos anteriores
*	setIconImage(image image); -> Para cambiar la imagen de java que aparece en la esquina (en linux no aparece)
*	setTitle(String titulo); -> Para ponerle titulo al cuadro que por defecto esta vacio
*	setResizable(boolean resizable); -> Para hacer que el cuadro pueda ser redimensionado por el usuario (por defecto si se puede)
*	setExtendedState(int state); -> Se usa para maximizar la ventana. se puede usar un valor entero o una constante de la clase JFrame.
*
*/

import javax.swing.*;

public class CreandoMarcos  {
	
	public static void main(String[] args) {
		
		miMarco marco1=new miMarco();
		
		marco1.setVisible(true);
				
		marco1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}


class miMarco extends JFrame{
	
	public miMarco() {
		
		//setSize(500,300);
		
		//setLocation(500,300);
		
		int ancho=Integer.parseInt(JOptionPane.showInputDialog("Introduce un ancho"));
		int largo=Integer.parseInt(JOptionPane.showInputDialog("Introduce un alto"));
		
		setBounds(600,500,ancho,largo);
		
		//setResizable(false);
		
		//setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		setTitle("Mi ventana");
				
		
	}
}