package graficos;

/*	Curso Java. Aplicaciones gráficas Swing IV. Escribiendo en el Frame. Vídeo 58
 *	Curso Java Aplicaciones gráficas. Swing V. Dibujando en el Frame I. Vídeo 59
 * 
 * 	En esta clase usaremos la clase Graphics para escribir una cadena de texto y hacer dibujos simples de lineas, rectangulos y arcos.
 * 	Esta clase esta muy limitada puesto que no permite cambiar ni el trazo de las lineas, ni colorearlas asi que para dibujos mas complejos usaremos mas adelante la clase Graphics2D que hereda de aquella.
 * 
 */

//Importamos la clase JPanel del paquete javax.swing
import javax.swing.*;
import java.awt.*;

public class EscribiendoEnMarco {

	public static void main(String[] args) {
		
		MarcoConTexto mimarco=new MarcoConTexto();
		
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 
	}

}

// Creamos una clase que herede de JFrame para luego instanciar en el main un objeto de tipo MarcoConTexto para crear el cuadro

class MarcoConTexto extends JFrame{   
	
	public MarcoConTexto() {
		
		setVisible(true);
		
		setSize(600,450);
		
		setLocation(400,200);
		
		setTitle("Primer texto");
		
		// Se instancia un objeto de tipo Lamina y se añade al cuadro con la instruccion simple add();
		Lamina miLamina= new Lamina();
		
		add(miLamina);
	}
}

// Creamos una clase que heredara de JPanel para poder luego instanciar un objeto que sera la lamina sobre la que escribiremos 

class Lamina extends JPanel{
	
	// Con este metodo machacamos el metodo paintComponent(Graphics g) que la clase JPanel hereda por defecto
	public void paintComponent(Graphics g) {
		
		// Con esta instruccion indicamos que queremos que se ejecute el codigo original del metodo paintComponent primero aunque hayamos machacado.
		// ya que ese metodo contiene codigo util que puede ser necesario para futuros programas (en este no haria falta puesto que solo vamos a dibujar una linea)
		super.paintComponent(g);
		
		// Con este metodo indicamos que con el objeto instanciado de tipo Graphics (que actue como un pincel) dibujemos un String en la lamina.
		g.drawString("Estamos aprendiendo swing", 100, 100 );
		
		// Este metodo dibujara un rectangulo en la posicion x 50 y 50 		
		g.drawRect(50, 50, 200, 200);
				
		// Este metodo dibujara una linea que va del punto X 100 e Y 100 al punto X 120 e Y 150		
		g.drawLine(100,100,300,200 );
			
		// Este metodo dibujara un arco con el angulo especificado
		g.drawArc(50, 100, 100,200 ,120, 150 );
		
	}
	
	
}