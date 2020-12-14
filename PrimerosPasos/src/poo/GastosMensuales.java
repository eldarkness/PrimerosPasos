package poo;

import javax.swing.*;

public class GastosMensuales {
	public static void main (String [] args) {
		
		String [] diaSemana={"Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado", "Domingo"};
		String [] JUNIO= new String[30];
		String [] JULIO= new String[31];
		String [] AGOSTO= new String[31];
			
		int cont=0;
		for (int i=0; i<30;i++,cont++) {
				
			if(cont>6) {
				
				cont-=7;
			}			
			JUNIO[i]=diaSemana[cont];
				
		}
		cont=2;			
		
		for (int i=0;i<31;i++,cont++) {
				
			if(cont>6) {
					
				cont-=7;
			}
			JULIO[i]=diaSemana[cont];
		}
		cont=5;
			
		for(int i=0;i<31;i++,cont++) {
				
			if(cont>6) {
					
				cont-=7;
			}
			AGOSTO[i]=diaSemana[cont];
		}
			
						
		String[] diasDeTrabajo = new String[Integer.parseInt(JOptionPane.showInputDialog("Cuantos dias semanales trabajas?"))];
			
		for(int i=0; i<diasDeTrabajo.length; i++) {
				
			diasDeTrabajo[i]=JOptionPane.showInputDialog("Introduce dia de la semana");
			System.out.println(diasDeTrabajo[i]);
		}
			
		String mes=JOptionPane.showInputDialog("Que mes quieres comprobar? (Junio, Julio o Agosto");
			
		int diasTrabajados=0;
		switch(mes) {
			case "Junio":
				
				for (int i=0; i<diasDeTrabajo.length;i++) {
						
					for (int j=0;j<JUNIO.length;j++) {
							
						System.out.println("El valor de i vale: " + i + " y el de j es " + j);
						if(diasDeTrabajo[i].equalsIgnoreCase(JUNIO[j])) {
							diasTrabajados++;
						}
					}
				}
				System.out.println("En junio trabajaste " + diasTrabajados + " d�as");
				break;
					
			case "Julio":
					
				for (int i=0; i<diasDeTrabajo.length;i++) {
						
					for (int j=0;j<JULIO.length;j++) {
							
						System.out.println("El valor de i vale: " + i + " y el de j es " + j);
						if(diasDeTrabajo[i].equalsIgnoreCase(JULIO[j])) {
							diasTrabajados++;
						}
					}
				}
				System.out.println("En julio trabajaste " + diasTrabajados + " d�as");
				break;
					
			case "Agosto":
					
				for (int i=0; i<diasDeTrabajo.length;i++) {
						
					for (int j=0;j<AGOSTO.length;j++) {
							
						System.out.println("El valor de i vale: " + i + " y el de j es " + j);
						if(diasDeTrabajo[i].equalsIgnoreCase(AGOSTO[j])) {
							diasTrabajados++;
						}
					}
				}
				System.out.println("En agosto trabajaste " + diasTrabajados + " d�as");
				break;
					
		}
			
		// Gastos Mensuales Fijos
			
		double Prestamo01=32.34;
		double Prestamo02=101.64;
		double seguroSFAM=8.90;
		double peluqueria=9.0;
		double fisioterapeuta=20.0;
		double psicologa=50.0;
		double clasesBateria=60.0;
		double sesionMurciaUnder=8.0;
		double netflix=15.99;
		double disneyPlus=3.5;
		double selloCoche=136.57/2;
		double seguroCoche=257.40/6;
		double movistar=35.0;
		double gasolina=150.0;
		double humbleBundle=12.0;
		double pagoCasa=50.0;
		
		double gastosFijos=seguroSFAM+(peluqueria*1.5)+psicologa+(fisioterapeuta*3)+netflix+disneyPlus+selloCoche+movistar+gasolina+humbleBundle+seguroCoche+Prestamo01+Prestamo02+pagoCasa;
		double sueldo=diasTrabajados*40;
		double ahorro=sueldo-gastosFijos;
			
		System.out.println("Este mes (" + mes + ") has ganado " + sueldo + "€ pero los gastos fijos mensuales, incluyendo cuotas prorrateadas de seguros son de " + gastosFijos + "€\nAsi que has ahorrado " + ahorro + "€");
		
			
		
		} // main
} //class

/*for (String e: diasDeTrabajo) {

for (String i: JUNIO) {
	
	if(e.equalsIgnoreCase(i)) {
		diasTrabajados++;
	}
}
}*/