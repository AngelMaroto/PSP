package org.example;

public class DeterminaSeccionCritica extends Thread{

    private int contador;
    private static int acumulador;
    private void ajustaContador(){this.contador-=500;}
    private void ajustaAcumulador(){this.acumulador-=500;}

    /*public void run(){
        for (int j = 0; j < 1000; j++) {
            contador++;
            acumulador++; //la seccion critica esta aqui ya que acumulador es una variable compartida y
            // cada hilo modifica o incrementa su valor, contador no es parte de la seccion porque cada hilo tiene su copia
            //ya que esta variable no es estática


            if (contador==600) ajustaContador();
            if (acumulador==600) ajustaAcumulador();
            System.out.println("Hilo: " + Thread.currentThread().getName() +
                    ", j: " + j +
                    ", contador: " + contador +
                    ", acumulador: " + acumulador);

        }
    }*/

    //SOLUCION
    public void run(){
        for (int j = 0; j < 1000; j++) {
            contador++;
            synchronized (DeterminaSeccionCritica.class) {
                acumulador++;
                if (acumulador == 600) ajustaAcumulador();
            }
            if (contador == 600) ajustaContador();
            System.out.println("Hilo: " + Thread.currentThread().getName() +
                    ", j: " + j +
                    ", contador: " + contador +
                    ", acumulador: " + acumulador);
        }
    }
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new DeterminaSeccionCritica().start();
            System.out.println("Valor de i: "+i);
        }

    }
}
