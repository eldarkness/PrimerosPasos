package graficos;

import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;

import javax.swing.JFrame;

/*
 * En este ejemplo vamos a crear dos ventanas en el que cambiara el titulo de cada una de ellas cuando sean el focus y dejaran de tener un titulo cuando lo pierdan.
 * 
 * Para ello usaremos la interfaz WindowFocusListener (o la clase adaptadora WindowAdapter) y sus dos metodos windowGainedFocus(FocusEvent e) y windowLostFocus(FocusEvent e)
 * 
 * Este programa esta hecho con una sola clase que hereda de JFrame y que incorpora dicha interfaz por lo que tambien sera el objeto oyente.
 * 
 */
public class FocoVentana extends JFrame implements WindowFocusListener{

	public static void main(String[] args) {
	
		// Para poder usar el metodo iniciar() necesitamos un ejemplar de clase de tipo FocoVentana para poder invocarlo, que solo se usara para llamar a este metodo
		FocoVentana miv= new FocoVentana();
		
		miv.iniciar();
	
	}
	
	// Este metodo sera el encargado de iniciar los dos marcos con sus respectivos metodos
	
	public void iniciar() {
		
		marco1=new FocoVentana();
		
		marco2=new FocoVentana();
		
		marco1.setVisible(true);
		
		marco2.setVisible(true);
		
		marco1.setBounds(300,100,600,350);
		
		marco2.setBounds(1200,100,600,350);
		
		marco1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		marco2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		marco1.addWindowFocusListener(this);
		
		marco2.addWindowFocusListener(this);
	}
	
	// Los dos metodos que hay que sobreescribir determinaran que acciones se llevaran a cabo cuando las ventanas pierdan o ganen el focus
	@Override
	public void windowGainedFocus(WindowEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==marco1) {
			
			marco1.setTitle("Tengo el foco!!");
			
		} else {
			
			marco2.setTitle("Tengo el foco!!");
		}
	}

	@Override
	public void windowLostFocus(WindowEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==marco1) {
			
			marco1.setTitle("");
			
		} else {
			
			marco2.setTitle("");
		}
	}
	
	// Al hacerlo todo en una sola clase los dos marcos deben ser declaramos en la clase principal pero fuera del main y de cualquier otro metodo, porque o sino no podrian ser accedidos por los demas metodos o por el programa principal. 
	
	FocoVentana marco1;
	
	FocoVentana marco2;

}
