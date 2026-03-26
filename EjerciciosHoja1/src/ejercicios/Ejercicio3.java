package ejercicios;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

/**
 * Ejercicio 3.- Crea una aplicación que lea el fichero log.txt y lo escriba por consola.
 * 
 * @author Eder Gracia
 * @version 1.0 23/03/26
 */

public class Ejercicio3 {

	public static void main(String[] args) {
		
		Path ej3 = Path.of("logs/log.txt");
		
		try {
			if(!Files.exists(ej3)){
				System.out.println("archivo no existe");
				return;
			}
			List<String> lineasLog = Files.readAllLines(ej3);
			for(String s : lineasLog) {
				System.out.println(s);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
