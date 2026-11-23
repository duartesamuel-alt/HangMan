package co.edu.univalle.poe.mvc.model;

// Traemos set y HashSet, un set es como una caja donde no se puede meter el mismo objeto dos veces. SI intentamos meter dos veces la letra "a", la caja la ignorara, eso nos viene perfecto para las letras adivinadas en el juego

import java.util.HashSet;
import java.util.Locale;
import java.util.Set;


public class JuegoHangman {
    private String palabraSecreta;
    private Set<Character> letrasAdivinadas; // Guarda letras individuales no palabras completas
    private int intentosRestantes;
    private boolean juegoTerminado;
    private boolean gano;


    //Constructor
    public JuegoHangman(String palabraSecreta){

        this.palabraSecreta = palabraSecreta.toLowerCase();  //TolowerCase pasa la palabra a minusculas por si acaso
        this.letrasAdivinadas = new HashSet<>(); // Crea la caja vacia que te mencione antes
        this.intentosRestantes = 6; // Los intentos que se mencionan como requisito en el PDF
        this.juegoTerminado = false;
        this.gano = false;
    }

    public void probarLetra(char letra){
        letra = Character.toLowerCase(letra);

        // Si la letra ya está en el Set, no hacemos nada
        if (letrasAdivinadas.contains(letra)) {
            System.out.println("La letra '" + letra + "' ya fue probada.");
            return;
        }

        // Agregamos la letra al Set
        letrasAdivinadas.add(letra);

        // Verificamos si la letra NO está en la palabra
        if (!palabraSecreta.contains(String.valueOf(letra))) {
            intentosRestantes--;
            System.out.println("¡Fallo! La letra '" + letra + "' no está. Te quedan " + intentosRestantes + " intentos.");
        } else {
            System.out.println("¡Bien! La letra '" + letra + "' está en la palabra.");
        }
        verificarEstadoJuego();
    }


    public int getIntentosRestantes() { return intentosRestantes; }

    public boolean isJuegoTerminado() { return juegoTerminado; }

    public boolean isGano() { return gano; }

    public String getPalabraSecreta() {return palabraSecreta; }



    public String obtenerPalabraOculta(){
        String resultado = "";

        for(int i = 0; i < palabraSecreta.length();i++ ){
            char letraActual = palabraSecreta.charAt(i);

            if (letrasAdivinadas.contains(letraActual)) {
                resultado = resultado + letraActual + " ";
            } else {
                resultado = resultado + "_ ";
            }
        }
        return resultado;
    }

    // Metodo Auxiliar para verificar si gano o perdio
    private void verificarEstadoJuego(){
        // si los intentos llegan a 0 , el jugador pierde
        if (intentosRestantes <= 0){
            juegoTerminado = true;
            gano = false;
            System.out.println("DERROTA La palabra era " + palabraSecreta);
            return;
        }

        //Si la palabra oculta no tiene guiones bajos, gano
        // (Reemplazamos los espacios para verificar mas facil)
        String palabraOculta = obtenerPalabraOculta().replace(" ", "");
        if (palabraOculta.equals(palabraSecreta)) {
            juegoTerminado = true;
            gano = true;
            System.out.println("VICTORIA Has adivinado la palabra: " + palabraSecreta);

        }



    }
}
