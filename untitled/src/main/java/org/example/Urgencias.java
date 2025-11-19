package org.example;

public class Urgencias {
    public static void main(String[] args) {  // agregar public static void main
        Respirador respirador = new Respirador();

        Medico medicoA = new Medico("Paco", respirador, false);
        Medico medicoB = new Medico("Juan", respirador, true);  // Usar constructor con respirador y flag

        medicoA.start();
        medicoB.start();
    }
}
