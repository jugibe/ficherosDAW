package ejercicios;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Ejercicio 2.- Crea una aplicación que añada a un fichero log.txt en la ruta “/logs/log.txt” la
siguiente información.
• Programa ejecutado “fecha y hora de la ejecución”
 */
public class Ejercicio2 {
	
	// String frase2 = this.getClass().getSimpleName(); // Mirar
	
	public static void main(String[] args) {
		Path ruta = Path.of("logs/log.txt");
		
		try {
			if(!Files.exists(ruta)) {
				Files.createDirectory(ruta.getParent());
			}
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
			String frase = LocalDateTime.now().format(formatter).toString()+"\n";
			Files.writeString(ruta, frase, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
