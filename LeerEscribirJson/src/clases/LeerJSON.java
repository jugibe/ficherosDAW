package clases;

import com.google.gson.Gson;
import java.nio.file.Files;
import java.nio.file.Path;

public class LeerJSON {
    public static void main(String[] args) {
        try {
            // Leer todo el archivo como String
            String json = Files.readString(Path.of("personas.json"));

            // Crear Gson
            Gson gson = new Gson();

            // Convertir JSON a array de objetos
            Persona[] personas = gson.fromJson(json, Persona[].class);

            // Mostrar datos
            for (Persona p : personas) {
                System.out.println("Nombre: " + p.getNombre() + ", Edad: " + p.getEdad());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}