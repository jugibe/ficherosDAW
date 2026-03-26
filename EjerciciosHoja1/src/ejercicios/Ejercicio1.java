package ejercicios;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

/**
 * 
 *  Crea una aplicación que pida una frase por teclado y la añada a un archivo frases.txt
    que se encuentre en la ruta “/documentos/frases.txt” partiendo de la raíz de tu proyecto.
 * 
 * @author Javier Martín Bosque 23/03/2026
 */

public class Ejercicio1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//insertamos la ruta del archivo
		Path ruta = Path.of("/documentos/frases.txt");
		System.out.println("introduzca una frase: ");
		String frase = sc.nextLine();
		//añadir la frase al archivo
		try {
			if(!Files.exists(ruta)) {
				Files.createDirectory(ruta.getParent());
			}
			Files.writeString(ruta, frase+"\n", StandardCharsets.UTF_8, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
	
}
