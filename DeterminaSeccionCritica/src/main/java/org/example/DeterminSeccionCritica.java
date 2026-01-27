package org.example;

public class DeterminSeccionCritica extends Thread{

    private int contador;
    private static int acumulador;
    private void ajustaContador(){this.contador-=5;}
    private void ajustaAcumulador(){this.acumulador-=5;}

    public void run(){
        for (int j=0; j<10; j++) {

            contador++;
            System.out.println("valor del contador "+contador);
            acumulador++;
            System.out.println("valor del acumulador "+acumulador);
            if (contador==6) ajustaContador();
            if (acumulador==6)ajustaAcumulador();
        }
    }

    public static void main(String[] args) {
        for (int i=0; i<10; i++)
            new DeterminSeccionCritica().start();
    }
}
