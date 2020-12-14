
public class Manipula_cadenas2 {

	public static void main(String[] args) {
		
		// El metodo .substring extrae subcandenas de caracteres dentro de otras cadenas. Su forma de funcionar es
		// indicandole primero desde que caracter queremos empezar a extraer e indicandole donde queremos dejar de extraer.
		
		String frase="Hoy es un estupendo dia para aprender a programar en Java";
	 
		String fraseresumen=frase.substring(0, 28) + " irnos a la playa y olvidarnos de todo..." + " y " +
		frase.substring(29, 57);
		
		System.out.println(fraseresumen);
	}

}
