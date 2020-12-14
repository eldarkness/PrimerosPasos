import javax.swing.JOptionPane;

public class GastosCasa {
	
	public static final double netflix=11.9925;
	public static final double disneyplus=3.495;
	public static final double movistar=90;
	public static final double spotify=6;
	public static final double telfJose=19.8;
	

	public static void main(String[] args) {
		
		// Añadir en un futuro los gastos en comida
				
		double gastoArturo;
		double gastoAlicia;
		double gastoJose;
		double electricidad;
		
		electricidad=Integer.parseInt(JOptionPane.showInputDialog("Introduce el gasto de electricidad de este mes"));
		
		
		gastoArturo=(netflix/3)+(disneyplus/3)+(movistar*0.22)+(spotify/2)+(movistar*0.1852)+(electricidad*0.3333);
		gastoAlicia=(netflix/3)+(disneyplus/3)+(movistar*0.22)+(movistar*0.1852)+(electricidad*0.3333);
		gastoJose=(netflix/3)+(disneyplus/3)+(movistar*0.1852)+(spotify/2)+telfJose+(electricidad*0.3333);
		
		
		double pagosArturo=movistar+netflix+disneyplus;
		double pagosJose=spotify+telfJose+electricidad;
		double pagosAlicia=0;
		
		
		System.out.print("Arturo ha pagado este mes: ");
		System.out.printf("%1.2f", pagosArturo);
		System.out.println("");
		System.out.print("Jose Carlos ha pagado este mes: ");
		System.out.printf("%1.2f", pagosJose);
		System.out.println("");
		double gastoTotal=gastoJose+gastoAlicia+gastoArturo;
		
		double arturoMT=pagosArturo/gastoTotal;
		double joseMT=pagosJose/gastoTotal;
		double aliciaMT=pagosAlicia/gastoTotal;
		System.out.println("El pago total ha sido de: " +(pagosArturo+pagosJose));
		System.out.println("El gasto total ha sido de: " +gastoTotal);
		System.out.println(arturoMT +"  "+ joseMT+"  "+ aliciaMT);
		
		System.out.println("Arturo ha pagado "+ Math.round(((arturoMT-0.3333)*gastoTotal))+ " euros de mas");
		System.out.println("Jose carlos ha pagado "+ Math.round(((joseMT-0.3333)*gastoTotal))+ " euros de mas");
		System.out.println("Alicia ha pagado este mes " +Math.round(0.3333*gastoTotal)+" euros de menos");
		//if(arturoMT>)
			
		
	}

}
