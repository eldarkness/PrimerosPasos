package graficos;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class SuperMarco {

	public static void main(String[] args) {
		
		MarcoTotalBotones mimarco1= new MarcoTotalBotones();
		
		mimarco1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		mimarco1.setBounds(300, 300, 500, 300);
		
		MarcoTotal mimarco2= new MarcoTotal();
		
		mimarco2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		mimarco2.setBounds(600, 600, 500, 300);
		
	}

}


class MarcoTotalBotones extends JFrame{
	
	public MarcoTotalBotones() {
		
		setTitle("Marco con botones");
		
		add(new LaminaTotal());
		
		setVisible(true);
	}
	
}

class LaminaTotal extends JPanel{
	
	JButton botonverde=new JButton("Verde");
	JButton botonazul=new JButton("Azul");
	JButton botonrojo=new JButton("Rojo");
	JButton botonnegro=new JButton("Negro");
	
	public LaminaTotal() {
		
		add(botonverde);
		add(botonazul);
		add(botonrojo);
	
		ColorFondo verde= new ColorFondo(Color.green);
		ColorFondo azul= new ColorFondo(Color.blue);
		ColorFondo rojo= new ColorFondo(Color.red);
		
		botonverde.addActionListener(verde);
		botonazul.addActionListener(azul);
		botonrojo.addActionListener(rojo);
			

	}
		
	
	private class ColorFondo implements ActionListener{
		
		public ColorFondo(Color c) {
			
			color=c;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			
			setBackground(color);
		}
		
		private Color color;
	}
}

 


class MarcoTotal extends JFrame{
	
	public MarcoTotal () {
		
		setTitle("Marco Total");
		
		setVisible(true);
		
		addMouseListener(new EventoTotalRaton());
		
					
	}
}



class EventoTotalRaton implements MouseListener {

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
}

class EventoTotalAccion implements ActionListener{
	
	public void actionPerformed(ActionEvent e) {
		
		
		
		
	}
	
}


	