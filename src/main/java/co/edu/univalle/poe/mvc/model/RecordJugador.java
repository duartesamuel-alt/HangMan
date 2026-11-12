package co.edu.univalle.poe.mvc.model;

public class RecordJugador {
    String nombre;
    int puntaje;

    public RecordJugador(String nombre, int puntaje){
        this.nombre=nombre;
        this.puntaje=puntaje;
    }

    public String getNombre() {
        return nombre;
    }

    public int getPuntaje() {
        return puntaje;
    }
}
