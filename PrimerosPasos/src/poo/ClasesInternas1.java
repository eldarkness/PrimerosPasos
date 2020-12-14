package poo;

import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.Timer;
import java.awt.Toolkit;

/* Clases internas para que se utilizan
 * 
 *  Se usan para acceder a los campos privados de la clase externa sin necesidad de usar metodos de acceso
 *  Para ocultar esta clase a las demas clases del mismo paquete, parecido a encapsular una variable pero con una clase entera
 * 	Para crear clases internan "an�nimas" muy utiles para gestionar eventos y retrollamadas
 * 	Cuando queremos que solo una clase acceda a los campos de ejemplar de otra clase (nos ahorramos los metodos de acceso)
 */

public class ClasesInternas1 {

	public static void main(String[] args) {
		
		Reloj mireloj= new Reloj(3000, true);
		
		mireloj.enMarcha();
		
		JOptionPane.showMessageDialog(null, "Pulsa Aceptar para salir");
		
		System.exit(0);
	}

}

class Reloj {
	
	public Reloj(int intervalo, boolean sonido) {
		
		this.intervalo=intervalo;
		this.sonido=sonido;
	}
	
	public void enMarcha() {
		
		ActionListener oyente = new DameLaHora2(); // Equivalente a "DameLaHora2 oyente= new DameLaHora2();"
		
		Timer mitemporizador= new Timer(intervalo, oyente);
		
		mitemporizador.start();
	}
	
	private int intervalo;
	
	private boolean sonido;

	private class DameLaHora2 implements ActionListener{
		
		public void actionPerformed(ActionEvent evento) {
			
			Date ahora= new Date();
			System.out.println("Te pongo la hora cada 3 segundos " + ahora);
			
			if(sonido) {
				
				Toolkit.getDefaultToolkit().beep();
			}
			
	
		}
	}

}