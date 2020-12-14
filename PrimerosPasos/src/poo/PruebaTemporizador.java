package poo;

import java.awt.Toolkit;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import javax.swing.Timer;

public class PruebaTemporizador {

	public static void main(String[] args) {
		
		DameLaHora oyente= new DameLaHora();  // 

		Timer mitemporizador= new Timer(5000, oyente); // Al usar el constructor de la clase Timer debemos especificar dos argumentos, uno es el tiempo en milisegundos (segundos * 1000) y el otro es un objeto de tipo actionlistener
														// El objeto actionListener debe ser creado en una clase aparte la cual debe implementar dicha interfaz y a su vez debe desarrollar el metodo public void actionPerformed para lanzar el evento especificado.
		mitemporizador.start();
		
		JOptionPane.showMessageDialog(null, "Pulsa aceptar para detener");
		System.exit(0);
	}
}

class DameLaHora implements ActionListener{
	
	public void actionPerformed(ActionEvent e) {
		
		Date ahora=new Date();
		
		System.out.println("Te pongo la hora cada 5 seg: " + ahora);
		
		Toolkit.getDefaultToolkit().beep();
		
		
	}
}


