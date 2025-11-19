package org.example;

public class Hospitañ {

    static void main(String[] args) {
        Medico medico = new Medico();
        CoordinadorUrgencias coordinador = new CoordinadorUrgencias("Coordinador Luis", medico);

        medico.start();
        coordinador.start();
    }
}
