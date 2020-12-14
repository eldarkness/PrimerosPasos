package poo;

import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.Timer;
import java.awt.Toolkit;

/* Las clases internas locales son clases dentro de metodos
 * 
 * Cuando se utilizan y porque?:
 * 
 * Son utiles cuando solo se va a utilizar (instanciar) la clase interna una vez con el objetivo de simplificar aun mas el codigo
 * Su ambito queda restringido al metodo donde son declaradas con la ventaja de:
 * 		-Estan muy encapsuladas, ni siquiera la clase externa a la que pertenecen puede acceder a ella directamente.
 * 		 Tan solo puede acceder a ella el metodo donde estan declaradas.
 * 		-El codigo resulta mas simple
 * No pueden llevar ningun modificador de acceso.
 */


public class ClasesInternas2 {

	public static void main(String[] args) {
		
		Reloj2 mireloj2= new Reloj2();
		
		mireloj2.enMarcha2(3000, true);
		
		JOptionPane.showMessageDialog(null, "Pulsa Aceptar para salir");
		
		System.exit(0);
	}

}

class Reloj2 {

		//Hemos borrado el constructor puesto que el metodo enMarcha2() recibe ahora los dos parametros que le pasabamos a este. Por lo tanto tambien hemos eliminado los campos de clase de Reloj2
		//ya que ahora esas dos variables (int intervalo2 y boolean sonido2) son variables locales del metodo enMarcha2(). Ademas como la clase interna DameLaHora3 puede acceder directamente a
		//la variable sonido hay que declarar esta como final al ser una variable local del metodo.
	public void enMarcha2(int intervalo2, boolean sonido2) {  // Metodo que alberga la clase interna
		
		class DameLaHora3 implements ActionListener{  // Clase Interna Local
			
			public void actionPerformed(ActionEvent evento2) {
				
				Date ahora2= new Date();
				System.out.println("Te pongo la hora cada 3 segundos " + ahora2);
				
				if(sonido2) {
					
					Toolkit.getDefaultToolkit().beep();
				}
				
		
			}
		}
		
		ActionListener oyente2 = new DameLaHora3(); // Equivalente a "DameLaHora2 oyente= new DameLaHora2();"
		
		Timer mitemporizador2= new Timer(intervalo2, oyente2);
		
		mitemporizador2.start();
	}
	
	// Se han borrado los campos de clase
	
}