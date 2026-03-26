package ejercicio3;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;

/*
 * Ejercicio 3 — Limpieza de fichero 
Enunciado 
Dado un fichero con líneas repetidas: 
hola 
adios 
hola 
hola 
adios 
Haz un programa que: 
1. Elimine duplicados 
2. Mantenga el orden original 
3. Sobrescriba el fichero 
Nivel extra 
● Ignorar mayúsculas/minúsculas 

 * */
public class Ejercicio3 {

	public static void main(String[] args) {
		// crear path
		Path path = Path.of("archivo.txt");

		String linea = "";
		ArrayList<String> lineasNoRepetidas = new ArrayList<String>();
		// leer el fichero con BufferedReader
		try (BufferedReader br = Files.newBufferedReader(path)) { // try with resources
			while ((linea = br.readLine()) != null) {
				// si linea no esta contenida en el arraylist la añado
				if (!(lineasNoRepetidas.contains(linea))) {
					lineasNoRepetidas.add(linea);
				}
			}
			//Sobreescribir el archivo con las lineas no repetidas
			Files.write(path, lineasNoRepetidas, StandardOpenOption.TRUNCATE_EXISTING);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
