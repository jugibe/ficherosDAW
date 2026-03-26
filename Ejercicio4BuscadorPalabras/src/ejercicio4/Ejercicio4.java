package ejercicio4;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
/**
 * Ejercicio 4 — Buscador tipo “grep” 
simple 
Enunciado 
Pide al usuario una palabra y muestra: 
1. Las líneas donde aparece 
2. Número de veces que aparece 
3. Número de línea 
Nivel extra 
● Búsqueda sin distinguir mayúsculas 
 */
import java.util.Scanner;

public class Ejercicio4 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String palabraBuscar;
		Path path = Path.of("texto.txt");
		int contadorPorLinea = 0;
		int contadorTotal = 0;
		int contadorLinea = 1;
		List<String> lineas = new ArrayList<>();
		
		//Preguntar la palabra a buscar
		System.out.println("Introduce la palabra a buscar");
		palabraBuscar = sc.nextLine();
		
		try {
			lineas = Files.readAllLines(path);
			
			for(String l : lineas) {
				Integer veces = contarApariciones(l, palabraBuscar);
				System.out.println("En la linea " + (lineas.indexOf(l)+1) + " la palabra " + palabraBuscar +
						" aparece un total de " + veces + " veces");
				contadorTotal = contadorTotal + veces;
			}
			
			System.out.println("En el archivo " + path.getFileName() + ", la palabra " + palabraBuscar + " aparece " + 
					contadorTotal + " veces");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
	}

	/**
	 * Metodo que me devuelve el numero de veces palabraBuscar dentro de l
	 * 
	 * @param l   representa cada una de las lineas del fichero
	 * @param palabraBuscar
	 * @return
	 */
	private static Integer contarApariciones(String l, String palabraBuscar) {
		
		Integer contador = 0;
		
		//Divido las palabras de la linea con un split
		String[] palabras = l.split("[ ,.;]");
		
		//recorro las palabras y cuento las veces que coinciden con la palabra buscar (.equals)
		for(String p : palabras) {
			
			if (p.equalsIgnoreCase(palabraBuscar)) {
				contador++;
			}
			
		}
		
		return contador;
	}

}
