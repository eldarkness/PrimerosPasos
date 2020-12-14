
import java.io.*;
import java.util.Scanner;

public class Wasteland2SaveEditor {

	public static void main(String[] args) {
		
		gestionarInformacion(importarArchivoXML());
	
	}
		
	public static void gestionarInformacion(String param) {
		
		// Creamos un StringBuffer para poder trabajar mas comodamente con los datos obtenidos del fichero y pasamos esa informacion a la variable local de main Sb2
		StringBuffer Sb = new StringBuffer(param);
		StringBuffer PJ1= new StringBuffer("");
		String StringPJ1="";
			
			
		// Con estas lineas extraemos toda la informacion del personaje que vamos a modificar con las expresiones regex <pc> y </pc> indicamos que queremos sacar la informacion de un pj
		String regexPcI= "<pcs>";
		String regexPcF= "</pcs>";
		int startIndex=0;									// Ponemos los indices a 0
		int finishIndex=0;
		startIndex=Sb.indexOf(regexPcI, startIndex);		// Estas 3 lineas sirven para extraer de la cadena Sb que contiene TODO solamente lo dicho anteriormente
		finishIndex=Sb.indexOf(regexPcF, startIndex);
		StringPJ1=Sb.substring(startIndex, finishIndex);
		PJ1=new StringBuffer(StringPJ1);					// Pasamos a un StringBuffer lo extraido anteriormente	
			
		/*// Extrae el nombre del jugador en este caso Eldarkness
		startIndex=0;
		finishIndex=0;
		startIndex=PJ1.indexOf("<name>",startIndex);
		finishIndex=PJ1.indexOf("</name>",finishIndex);
		String NPJ=PJ1.substring(startIndex+9,finishIndex-3);
			
		// Se pregunta que quiere hacer con ese pj y se extrae de la variable PJ1 los datos relativos a las skills del personaje en cuestion.				
		System.out.println("Has seleccionado el PJ \"" + NPJ + "\". Que quieres saber acerca de Eldarkness? (presiona \"s\" para salir)");
			
		startIndex=0;
		finishIndex=0;
		startIndex=PJ1.indexOf("<skillXps>",startIndex);
		finishIndex=PJ1.indexOf("</skillXps>",finishIndex);
		String SPJ1=PJ1.substring(startIndex, finishIndex);
			
		// Se muestran las posibles opciones para el personaje Eldarkness			
			
		System.out.println("1.Desactivar alarmas: alarmDisarm \n2.Encantador de animales: animalWhisperer");
		System.out.println("3.Negociador: barter \n4.Armas afiladas: bladedWeapons");
		System.out.println("5.Medico de campana: fieldMedic \n6.Rifle de asalto: rifle");
				
		String askSkill = new Scanner(System.in).nextLine();
			
		int skillIndex = SPJ1.indexOf(askSkill);			
			
		String skill = SPJ1.substring(skillIndex+askSkill.length()+13, skillIndex+askSkill.length()+15);	
			
		System.out.println("La habilidad " + askSkill + " vale " + skill);
			
		//System.out.println("Has salido del programa. Apagando....");*/
		
		String nombres[] = new String[7];
		int sIndex=0;
		int fIndex=0;
		int cont=0;
		String nombre="";
		
		System.out.println("Golaa");
		
		while (startIndex != -1) {
			
			sIndex= PJ1.indexOf("<name>",sIndex);
			fIndex= PJ1.indexOf("</name>",sIndex);
						
			//nombre=PJ1.subString
			nombre=PJ1.substring(sIndex+9,fIndex-3);
			cont++;
			//sIndex=fIndex;
			
			System.out.println(nombre);
		}
		System.out.println(nombre);
	}
		
	public static String importarArchivoXML() {
				   
		File archivo = null;
		FileReader fr = null;
		BufferedReader br = null;
		String param="";
	
		try {
			
			// Apertura del fichero y creacion de BufferedReader para poder hacer una lectura comoda (disponer del metodo readLine()).
			archivo = new File ("c:\\GOG Games\\Quicksave 3.xml");
			fr = new FileReader (archivo);
			br = new BufferedReader(fr);

			// Lectura del fichero y volcado de contenido de la variable local "linea" a la variable local del metodo importarArchivoXML() "param"
			String linea;
			linea=br.readLine();
			param=linea;
			
		}
		
		catch(Exception e){
			e.printStackTrace();
			
		}finally{
		
			// En el finally cerramos el fichero, para asegurarnos
			// que se cierra tanto si todo va bien como si salta 
			// una excepcion.
			try{                    
		
				if( null != fr ){   
					fr.close();     
				}                  
		
			}catch (Exception e2){ 
				e2.printStackTrace();
			}
		}
			
		return param;
	
	} // metodo

} //class
	

