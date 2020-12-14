package graficos;

import java.awt.Color;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ActionMap;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

/*	Curso Java Eventos XII, XIII, IVX, XV. Mï¿½ltiples fuentes I, II, III y IV. Vï¿½deos 76-79.
 * 	En esta clase haremos que nuestro objeto oyente (la lamina) tenga multiples fuentes, en esta caso seran 3 botones qye pondran la lamina en amarillo, azul o rojo. 
 * 	Tambien conseguiremos esto con una combinacion de teclas para cada una de los 3 colores que cambiaran el color de la lamina.
 * 
 * 	Necesitaremos usar la interfaz Action que trae 6 metodos que deberemos sobreescribir mas el metodo actionPerformed(actionEvent e) que hereda de la interfaz ActionListener o heredar de la clase AbstractAction que ya tiene implementados los 6 metodos excepto actionPerformed
 * 	-setEnabled(boolean b)
 * 	-isEnabled(boolean b)
 * 	-putValue(String clave, Object valor)
 * 	-getValue(String clave)
 * 	-addPropertyChangedListener)(PropertyChangedListener oyente)
 * 	-removePropertyChangedListener(PropertyChangedListener oyente)
 * 
 * 	Para ello usaremos unos botones del tipo JButton que recibiran en el constructor un parametro de tipo Action que no es ni mas ni menos que una clase propia que implementara la interfaz action o heredara de la clase AbstractAction
 * 
 * 	Este clase propia tendra un constructor que recibira 4 parametros que iran ligados al objeto fuente como son el nombre, un icono, una instancia de tipo color y finalmente una pequeña descripcion. Estos datos se almacenaran en el objeto de tipo JButton
 * 	y viajaran al objeto de tipo evento cuando este se cree, almacenandose cada uno de ellos de la forma "clave: valor" para cada uno de los 4 datos. Estas claves: valor se especifican en el constructor de nuestra clase propia con el metodo putValue()
 * 	y cogeran esa informacion cuando instanciemos cada uno de los ejemplares de dicha clase. Para rescatar informacion sobre esas claves: valor y usar esos datos necesitamos el metodo getValue(), de esta manera podemos recuperar por ejemplo el nombre de ese objeto,
 *	su descripcion, etc...
 *
 *	Para crear los objetos fuente que sean una combinacion de teclas hay que usar tambien varias clases:
 *	InputMap, JComponent, KeyStroke y ActionMap
 * 	
 */

public class PruebaAcciones {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MarcoAccion marco= new MarcoAccion();
		
		marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		marco.setVisible(true);
		
	}

}

class MarcoAccion extends JFrame {
	
	public MarcoAccion() {
		
		setTitle("Prueba acciones");
		
		setBounds(600,350,600,300);
		
		PanelAccion lamina= new PanelAccion();
		
		add(lamina);
	}
}

class PanelAccion extends JPanel{
	
		
		public PanelAccion() {
			
			AccionColor accionAmarillo=new AccionColor("Amarillo", new ImageIcon("src/graficos/images.jpg"), Color.yellow);
			AccionColor accionAzul= new AccionColor("Azul", new ImageIcon("src/graficos/images.png"), Color.blue);
			AccionColor accionRojo= new AccionColor("Rojo", new ImageIcon("src/graficos/"), Color.red);
			
			/*
			JButton botonAmarillo= new JButton(accionAmarillo);
			add(botonAmarillo);
			JButton botonAzul= new JButton(accionAzul);
			add(botonAzul);
			JButton botonRojo= new JButton(accionRojo);
			add(botonRojo);
			*/
			
			add(new JButton(accionAmarillo));
			add(new JButton(accionAzul));
			add(new JButton(accionRojo));
			
			/*
			JButton botonazul= new JButton("Azul");
			JButton botonamarillo= new JButton("Amarillo");
			JButton botonrojo= new JButton("Rojo");
			add(botonazul);
			add(botonrojo);
			add(botonamarillo);*/
			
			// 1er paso: Mapa de entrada, solo hay que crearlo una vez y vale para todas las combinaciones
			InputMap mapaEntrada=getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
			
			// 2º paso: Crear la combinacion de teclas (para el amarillo)	
			KeyStroke teclaAmarillo=KeyStroke.getKeyStroke("ctrl A");
			// 3er paso: Vinculamos la combinacion de teclas de la linea anterior con un nombre
			mapaEntrada.put(teclaAmarillo, "fondo_amarillo");
			// 4º paso A: Instanciamos un objeto de tipo ActionMap para poder luego usar su metodo put. Este paso solo hay que hacerlo una vez para crear la variable auxiliar de tipo ActionMap que necesitamos para usar su metodo put()
			ActionMap mapaAccion=getActionMap();
			// 4º paso B: Con el metodo put de la clase ActionMap usamos la instancia anterior para vincular ya finalmente el objeto que hemos vinculado con el metodo put a una combinacion de teclas (en esta caso "fondo_amarillo") con la accion ya creada de nuestra clase propia (AccionColor) que hereda de la clase AbstractAction
			mapaAccion.put("fondo_amarillo", accionAmarillo);
			
			// Combinacion de teclas para el azul y el rojo (de forma mas resumida)
			
			mapaEntrada.put(KeyStroke.getKeyStroke("ctrl B"), "fondo_azul");
			
			mapaEntrada.put(KeyStroke.getKeyStroke("ctrl R"), "fondo_rojo");
			
			mapaAccion.put("fondo_azul", accionAzul);
			
			mapaAccion.put("fondo_rojo", accionRojo);
			
		}

		private class AccionColor extends AbstractAction{
			
			public AccionColor(String nombre, Icon icono, Color color_boton) {
				
				putValue(Action.NAME, nombre);
				
				putValue(Action.SMALL_ICON, icono);
				
				putValue(Action.SHORT_DESCRIPTION, "Poner la lamina de color " + nombre);
				
				putValue("color_de_fondo", color_boton);
			}
			 
			public void actionPerformed(ActionEvent e) {
				
				Color c=(Color)getValue("color_de_fondo");
				
				setBackground(c);
				
				System.out.println("Nombre del boton: " + getValue(Action.NAME)+ ". Descripcion "+ getValue(Action.SHORT_DESCRIPTION));
				
				
			}
			
			
		}
}

