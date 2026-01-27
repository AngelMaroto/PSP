package org.example;

public class Imprimir {
    public static void main(String[] args) {
        Impresora impresoraCompartida = new Impresora();
        for (int i = 0; i < 9; i++) {
            new Thread(new Empleado(impresoraCompartida, i)).start();
        }
    }
}
