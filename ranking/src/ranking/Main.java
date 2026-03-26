package ranking;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Fichero puntuaciones.txt: 
Ana:10 
Luis:25 
Ana:15 
Haz un programa que: 
1. Sume las puntuaciones por jugador 
2. Muestre ranking ordenado de mayor a menor 
3. Guarde el resultado en ranking.txt
 */
public class Main {
	public static void main(String[] args) {
		Path path=Path.of("puntuaciones.txt");//ruta al al archivo
		Path rutaRanking=Path.of("ranking.txt");
		Map<String,Integer> puntuaciones;//mapa para almacenar los datos del archivo usuario:contraseña
		
		//leer el fichero y convertirlo en un Map<String,String>
		puntuaciones=leerArchivo(path);
		System.out.println(puntuaciones); 
		
		//ordenar  el mapa por valor
		List<Map.Entry<String, Integer>> listaPuntuaciones=new ArrayList<>(puntuaciones.entrySet());
		listaPuntuaciones.sort((a,b)->-a.getValue().compareTo(b.getValue()));
		System.out.println(listaPuntuaciones);
	
		//Escribir el resultado ordenado en ranking.txt
		
		
		
	}
	
	/**
	 * Lee el archivo y devuelve un map con los usuarios y puntuacion
	 * @param path: ruta del archivo
	 * @return: map<String,Integer> con el usuario y su puntuacion
	 */
	
	private static Map<String, Integer> leerArchivo(Path path) {
		//Creo el map para almacenar los usuarios y las contraseñas
		Map<String,Integer> resultado=new HashMap<String,Integer>();
		//Chequear si el archivo existe
		if(!Files.exists(path)) {
			System.out.println("Archivo de usuarios no existe");
			System.exit(0);//Salimos del programa
		}
		try {
			List<String> lineasFichero= Files.readAllLines(path); //leo todas las lineas
			for(String s:lineasFichero ) {
				String[] linea= s.split(":"); //linea[0] usuario, linea [1] puntuacion
				if(!resultado.containsKey(linea[0])) {
					resultado.put(linea[0], Integer.parseInt(linea[1]));
				}else {
					resultado.put(linea[0], resultado.get(linea[0])+Integer.parseInt(linea[1]));
					//valor anterior resultado.get(linea[0])
					//sumo el vlao0 rdel fichero Integer.parseInt(linea[1])
				}
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return resultado;
	}
}
