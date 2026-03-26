package ejercicio5;

public class Alumno {
	private String nombre;
	private int edad;
	private String grupo;
	/**
	 * Constructor
	 * @param nombre
	 * @param edad
	 * @param grupo
	 */
	public Alumno(String nombre, int edad, String grupo) {
		this.nombre = nombre;
		this.edad = edad;
		this.grupo = grupo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public String getGrupo() {
		return grupo;
	}
	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}
	@Override
	public String toString() {
		return "nombre=" + nombre + "\nEdad=" + edad + "\nGrupo=" + grupo + "\n";
	}
	
	
	
}
