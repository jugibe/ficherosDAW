package ejercicios;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

/**
 * Crea con el bloc de notas un fichero texto.txt con la palabra HOLA, lee su contenido
byte a byte con un InputStream  y muestra los bytes obtenidos por consola. Interpreta el resultado.
• Usa read() para leer byte a byte.
• usa read(byte []) para leer.
• Usa Files.readAllBytes(path)
 */
public class Ejercicio7 {

	public static void main(String[] args) {
		//Creo la ruta
		Path ruta=Path.of("texto.txt");
		
		if(!Files.exists(ruta)) {
			System.out.println("Fuchero inexistente");
			return;
		}
		byte[] n= new byte[7];
		int bytesleidos;
		InputStream in;
		
		try {
			in=Files.newInputStream(ruta);
			while((bytesleidos=in.read(n))!=-1) {
				System.out.println("Bytesleidos "+ bytesleidos);
				System.out.println(Arrays.toString(n));
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
