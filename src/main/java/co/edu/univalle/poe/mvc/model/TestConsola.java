package co.edu.univalle.poe.mvc.model;

public class TestConsola {
    public static void main(String[] args) {
        System.out.println("--- INICIANDO TEST DEL JUEGO ---");

        JuegoHangman juego = new JuegoHangman("java");

        System.out.println("Palabra al inicio: " + juego.obtenerPalabraOculta());

        // Simulamos que el jugador presiona la letra 'a'
        System.out.println("\n-- El jugador presiona 'a' --");
        juego.probarLetra('a');
        System.out.println("Palabra ahora: " + juego.obtenerPalabraOculta());

        // Simulamos que presiona la 'a' otra vez (no debería restar intentos)
        System.out.println("\n-- El jugador presiona 'a' otra vez --");
        juego.probarLetra('a');

        // Simulamos que presiona una letra que no está ('z')
        System.out.println("\n-- El jugador presiona 'z' --");
        juego.probarLetra('z');
        System.out.println("Intentos restantes: " + juego.getIntentosRestantes());
    }
}