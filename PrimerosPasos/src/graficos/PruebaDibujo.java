package graficos;

import java.awt.*;
import javax.swing.*;
import java.awt.geom.*;

/* Curso Java Aplicaciones gr�ficas. Swing VI Dibujando en el Frame II. V�deo 60
 * 
 * Vamos a usar la clase Graphics2D para dibujar rectangulos, circulos y lineas mas complejos que los de la clase Graphics.
 * 
 * Esta clase hereda de aquella y necesita instanciar un objeto que incorpore la interfaz Shape. Estos objetos serian: Rectangle2D, Ellipse2D o Line2D.
 * Aunque hay que tener en cuenta que las clases Ellipse2D, Rectangle2D y Line2D son abstractas por lo que no podemos instanciarla directamente.
 * Para ello debemos usas una de sus subclases que se llaman con el mismo nombre pero añadiendole ".Double" o ".Float" al final.
 * 
 * Primero tendremos que "actualizar el pincel" por lo que debemos hacer una refundicion de la variable tipo Graphics "g" a una de tipo Graphics2D para que sea compatible con los otros 3 metodos. Luego se instancia
 * un objeto de cualquiera de esos tres tipos y por ultimo para dibujarlos tenemos que usar el metodo .draw(); usando nuestra variable de tipo Graphics2D delante del metodo y entonces le pasamos el objeto instanciado
 * de uno de esos tres tipos como argumento.
 * 
 *  */


public class PruebaDibujo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MarcoConDibujos mimarco=new MarcoConDibujos();
		
		mimarco.setVisible(true);

		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}

//Creamos una clase que herede de JFrame para luego instanciar en el main un objeto de tipo MarcoConDibujos para crear el cuadro

class MarcoConDibujos extends JFrame{
	
	public MarcoConDibujos() {
		
		setTitle("Prueba de Dibujo");
		
		setSize(400,400);
		
		// Se instancia un objeto de tipo Lamina y se a�ade al cuadro con la instruccion simple add();
		
		LaminaConFiguras miLamina= new LaminaConFiguras();
		
		add(miLamina);
	}
}

//Creamos una clase que heredara de JPanel para poder luego instanciar un objeto que sera la lamina sobre la que dibujaremos

class LaminaConFiguras extends JPanel{
	
	// El metodo paintComponent de la clase JPanel nos permite dibujar figuras en el objeto instanciado de la LaminaConFiguras que hereda de JPanel.
	// Con el metodo siguiente machacamos el metodo paintComponent(Graphics g) de la clase padre.
	
	public void paintComponent(Graphics g) {
		
		// Con esta instruccion indicamos que queremos que se ejecute el codigo original del metodo paintComponent primero aunque hayamos machacado.
		// ya que ese metodo contiene codigo util que puede ser necesario para futuros programas (en este no haria falta puesto que solo vamos a dibujar una linea)
		
		super.paintComponent(g);
		
		// Como vamos a usar la clase Graphics2D necesitamos refundir la variable g que es de tipo Graphics a una de tipo Graphics2D 
		
		Graphics2D g2=(Graphics2D) g;
		
		// Se instancia un objeto de tipo Rectangle2D (que incorpora la interfaz Shape)
		
		Rectangle2D rectangulo=new Rectangle2D.Double(100,100,200,150);
		
		// con este metodo usamos la instancia de Graphics2D (la variable g2) como auxiliar para digamos hacer los trazos y le pasamos como argumento el objeto de tipo Rectangle2D recien instanciado.
		
		g2.draw(rectangulo);
		
		// Misma operacion pero esta vez con la clase Ellipse2D, solo que en vez de darle valor directamente en el constructor le indicamos en la siguiente linea que debe dibujar esa elipse en base al objeto Rectangle2D que hemos instanciado antes (rectangulo)
		
		Ellipse2D elipse= new Ellipse2D.Double();
		
		elipse.setFrame(rectangulo);
		
		g2.draw(elipse);
		
		// Con esta sentencia vamos a dibujar una linea recta que va a tener como inicio la posicion x 100 y 100 y el final en x 300 y 250 todo en una linea usando el constructor de la clase Line2D() directamente en el metodo draw();
		
		g2.draw(new Line2D.Double(100,100,300,250));
		
		// Ahora vamos a dibujar una elipse que tenga por centro el centro del rectangulo del objeto Rectangle2D que hemos estado usando en el ejemplo
		// Primero obtenemos la X y la Y del centro del rectangulo y las almacenamos en dos variables de tipo double. Le asignamos tambien el tama�o de la elipse dandole un radio
		
		double CentroEnX=rectangulo.getCenterX();
		
		double CentroEnY=rectangulo.getCenterY();
		
		double radio=125;
		
		// Instanciamos el objeto de tipo Ellipse2D pero esta vez usamos el metodo setFrameFromCenter() para decirle que queremos que el centro de la elipse sea las dos variables tipo double que creamos antes y tambien el tama�o del radio pasandole la variable radio.
		
		Ellipse2D circulo=new Ellipse2D.Double();
		
		circulo.setFrameFromCenter(CentroEnX,CentroEnY, CentroEnX+radio, CentroEnY+radio);
		
		g2.draw(circulo);
				
	
	}
}



