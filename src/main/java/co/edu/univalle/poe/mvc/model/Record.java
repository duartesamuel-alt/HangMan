package co.edu.univalle.poe.mvc.model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import static java.nio.file.Path.of;

public class Record {
    private static final Path RUTA_PALABRAS =  Path.of("src", "main", "resources", "palabras.txt");
    private static final Path RUTA_HISTORIAL = Path.of("src", "main", "resources", "historial.txt");
    private BufferedWriter writer;
    private BufferedReader reader;

    private Estado estado;


    // Cambio en los parametros del metodo para adapatarlo a las necesidades de la asignacion de la profe
    public Estado saveRecord(String nombre, String palabra, String resultado, int errores) {

        // Se agrega tal cual la linea como se pedia en el PDF de la asignacion
        String linea = nombre + "," + palabra + "," + resultado + "," + errores;

        try {
            // Usamos RUTA_HISTORIAL y agregamos StandardOpenOption.APPEND para NO borrar lo anterior (Como vimos en la ultima clase de la profesora)
            writer = Files.newBufferedWriter(RUTA_HISTORIAL, StandardCharsets.UTF_8, java.nio.file.StandardOpenOption.CREATE, java.nio.file.StandardOpenOption.APPEND);
            writer.write(linea);
            writer.newLine();
            writer.close();
            estado = Estado.GUARDADO_OK;
        } catch (IOException e) {
            estado = Estado.GUARDADO_ERROR;
        }
        return estado;
    }

    public List<String> cargarPalabras(){
        List<String> listaPalabras = new ArrayList<>();
        try {
            reader = Files.newBufferedReader(RUTA_PALABRAS);
            String linea = reader.readLine();

            while(linea != null){
                listaPalabras.add(linea);
                linea = reader.readLine();

            }
            reader.close();


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return listaPalabras;
    }
}
