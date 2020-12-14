
public class Metodo_Math_Pow {

	public static void main(String[] args) {
		
		// A veces interesa convertir una variable de un tipo a otro, a esto se le llama refundicion
		// para ello escribimos delante de la operacion el tipo de variable al que queremos convertir entre parentesis.
		
		double base=5;
		
		double exponente=3;
		
		int resultado=(int)Math.pow(base, exponente);
		
		System.out.println("El resultado de " + base + " elevado a " + exponente + " es " + resultado);
		
	
	}
}
