package org.example;

public class MainPuerto {
    public static void main(String[] args){
        Puerto puerto = new Puerto();
        Barcos b1 = new Barcos("Barco 1", 20,puerto);
        Barcos b2 = new Barcos("Barco 2", 30,puerto);
        Barcos b3 = new Barcos("Barco 3", 25,puerto);
        Barcos b4 = new Barcos("Barco 4", 15,puerto);
        Barcos b5 = new Barcos("Barco 5", 10,puerto);

        Thread h1 = new Thread(b1);
        Thread h2 = new Thread(b2);
        Thread h3 = new Thread(b3);
        Thread h4 = new Thread(b4);
        Thread h5 = new Thread(b5);

        b1.setDependencia(h5);

        h1.start();
        h2.start();
        h3.start();
        h4.start();
        h5.start();
    }
}
