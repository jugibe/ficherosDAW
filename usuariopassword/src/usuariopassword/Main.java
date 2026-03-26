package usuariopassword;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * Dispones de un fichero usuarios.txt con formato: 
usuario:password 
ana:1234 
juan:abcd 
Haz un programa que: 
1. Pida usuario y contraseña 
2. Compruebe si existe en el fichero 
3. Permita 3 intentos 
4. Si falla, mostrar error
 */
public class Main {

	public static void main(String[] args) {
		//Variables necesarias
		final Integer TOTALINTENTOS=3;
		Integer intentos=0;
		boolean usuarioCorrecto=false;
		
		Scanner sc=new Scanner(System.in);
		String nombre,password;//datos aque pediremos por teclado
		Path path=Path.of("usuarios.txt");//ruta al al archivo
		Map<String,String> usuarios;//mapa para almacenar los datos del archivo usuario:contraseña
		
		//leer el fichero y convertirlo en un Map<String,String>
		usuarios=leerArchivo(path);
		System.out.println(usuarios); 
		
		//hacer mientras intento<TOTALINTENTOS y el usuario no este en el fichero
		while(intentos<TOTALINTENTOS&&usuarioCorrecto==false) {
			System.out.println("Introduce el usuario");
			nombre=sc.nextLine();
			System.out.println("Introduce la constraseña");
			password=sc.nextLine();
			//chequeo si el usurio esta en el mapa y su contraseña es correcta
			if(usuarios.containsKey(nombre)&&usuarios.get(nombre).equals(password)) {
				usuarioCorrecto=true;
				System.out.println("Usuario Correcto");
			}else {
				intentos++;
				System.out.println("usuario o contraseña errónea. Intento: "+ intentos);
			}
			
			
		}
		System.out.println("Fin de programa");
		
	}

	/**
	 * Lee el archivo y devuelve un map con los usuarios y contraseñas
	 * @param path: ruta del archivo
	 * @return: map<String,String> con el usuario y su contraseña
	 */
	
	private static Map<String, String> leerArchivo(Path path) {
		//Creo el map para almacenar los usuarios y las contraseñas
		Map<String,String> resultado=new HashMap<String,String>();
		//Chequear si el archivo existe
		if(!Files.exists(path)) {
			System.out.println("Archivo de usuarios no existe");
			System.exit(0);//Salimos del programa
		}
		try {
			List<String> lineasFichero= Files.readAllLines(path); //leo todas las lineas
			for(String s:lineasFichero ) {
				String[] linea= s.split(":"); //linea[0] usuario, linea [1]password
				resultado.put(linea[0],linea[1]);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return resultado;
	}
	
	
	

}
