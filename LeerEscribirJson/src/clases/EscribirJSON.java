package clases;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.nio.file.Files;
import java.nio.file.Path;

public class EscribirJSON {
    public static void main(String[] args) {
        try {
            Persona[] personas = {
                new Persona("Ana", 25),
                new Persona("Luis", 30),
                new Persona("María", 22),
                new Persona("Carlos", 28),
                new Persona("Elena", 35)
            };

            Gson gson = new GsonBuilder().setPrettyPrinting().create();

            String json = gson.toJson(personas);

            Files.writeString(Path.of("personas.json"), json);

            System.out.println("JSON escrito correctamente.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}