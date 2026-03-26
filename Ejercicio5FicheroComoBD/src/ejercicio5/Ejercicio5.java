package ejercicio5;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/*
 * Ejercicio 5 — Fichero como base de 
datos 
Enunciado 
Fichero alumnos.txt: 
Ana;20;DAW 
Luis;22;DAM 
Haz un menú que permita: 
1. Mostrar alumnos 
2. Añadir alumno 
3. Buscar por nombre 
4. Filtrar por grupo 

 */
public class Ejercicio5 {
	
	private static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		
		
		Path path = Path.of("alumno.txt");
		
		int opcion = 0;
		do {
			// Menu
			System.out.println("1. Mostrar alumnos");
			System.out.println("2. Añadir alumnos");
			System.out.println("3. Buscar alumnos por nombre");
			System.out.println("4. Filtrar por grupo");
			System.out.println("0. Salir");
			opcion = sc.nextInt();
			sc.nextLine();
			switch(opcion) {
			case 0:
				System.out.println("Fin del programa");
				break;
			case 1: 
				ArrayList<Alumno> lista = leerFichero(path);
				lista.stream().forEach(System.out::println);
				break;
			case 2:
				Alumno alumno = pedirAlumno();
				insertarAlumno(alumno, path);
				break;
			case 3:
				System.out.println("Introduce el nombre del alumno: ");
				String nombre = sc.nextLine();
				// En este metodo solo vamos a imprimir los datos
				buscarAlumno(path, nombre);
				break;
			case 4:
				System.out.println("Introduce el grupo: ");
				String grupo = sc.nextLine();
				// En este metodo vamos a devolver una lista con todos los alumnos del grupo
				List<Alumno> listaGrupos = buscarGrupo(path, grupo);
				listaGrupos.stream().forEach(System.out::println);
				break;
			default:
				System.out.println("Opcion Erronea");
				break;
			}
		} while (opcion != 0);
	}
	/**
	 * Buscar alumnos por grupo
	 * @param path
	 * @param grupo
	 * @return
	 */
	private static List<Alumno> buscarGrupo(Path path, String grupo) {
		
		ArrayList<Alumno> resultado = new ArrayList<Alumno>();
		
		try(BufferedReader buffer = Files.newBufferedReader(path)){
			
			String linea;
			
			while((linea=buffer.readLine()) != null) {
				// Separador
				String[] datosAlumno = linea.split(";");
				
				// datosAlumno[0] = nombre, datosAlumno[1] = edad, datosAlumno[2] = grupo
				if (datosAlumno[2].equalsIgnoreCase(grupo)) {
					
					resultado.add(new Alumno(datosAlumno[0], Integer.parseInt(datosAlumno[1])
							, datosAlumno[2]));
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultado;
	}
	/**
	 * Buscar alumnos por nombre
	 * @param path
	 * @param nombre
	 */
	private static void buscarAlumno(Path path, String nombre) {
		
		try(BufferedReader buffer = Files.newBufferedReader(path)){
			
			String linea;
			
			while((linea=buffer.readLine()) != null) {
				// Separador
				String[] datosAlumno = linea.split(";");
				
				// datosAlumno[0] = nombre, datosAlumno[1] = edad, datosAlumno[2] = grupo
				if (datosAlumno[0].equalsIgnoreCase(nombre)) {
					System.out.println("Nombre: "+datosAlumno[0]
							+" Edad: "+datosAlumno[1]
							+" Grupo: "+datosAlumno[2]);
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	/**
	 * Insertar alumnos en el fichero
	 * @param alumno
	 * @param path
	 */
	private static void insertarAlumno(Alumno alumno, Path path) {
		
		try {
			Files.writeString(path, alumno.getNombre()+";"+alumno.getEdad()+";"+alumno.getGrupo()+"\n"
					,StandardOpenOption.APPEND);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * Pedir alumno del fichero
	 * @return
	 */
	private static Alumno pedirAlumno() {
		
		System.out.println("Introduce el nombre");
		String nombre = sc.nextLine();
		
		System.out.println("Introduce la edad");
		Integer edad = sc.nextInt();
		sc.nextLine();
		
		System.out.println("Introduce el grupo");
		String grupo = sc.nextLine();
		
		return new Alumno(nombre, edad, grupo);
	}
	/**
	 * Leer el fichero para sus consiguientes usos
	 * @param path
	 * @return
	 */
	private static ArrayList<Alumno> leerFichero(Path path) {
		
		ArrayList<Alumno> resultado = new ArrayList<Alumno>();
		
		try(BufferedReader buffer = Files.newBufferedReader(path)){
			
			String linea;
			
			while((linea=buffer.readLine()) != null) {
				// Separador
				String[] datosAlumno = linea.split(";");
				
				// datosAlumno[0] = nombre, datosAlumno[1] = edad, datosAlumno[2] = grupo
				resultado.add(new Alumno(datosAlumno[0], Integer.parseInt(datosAlumno[1])
						, datosAlumno[2]));
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultado;
	}
}
