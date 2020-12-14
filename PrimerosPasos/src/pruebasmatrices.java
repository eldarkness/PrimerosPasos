import javax.swing.JOptionPane;

public class pruebasmatrices {

	public static void main(String[] args) {
		
		String [] paises = new String [Integer.parseInt(JOptionPane.showInputDialog("¿Cuantos paises quieres escribir?"))];

		int indice=paises.length;
		
		for ( int i=0; i<paises.length; i++) {
					
			paises[i]=JOptionPane.showInputDialog("Introduce un pais (quedan " + indice + " países restantes)");
			
			indice--;
					
		}
		
		for (String i:paises) {
			
			System.out.println(i);
		}
		
		
		
	
	}
}


