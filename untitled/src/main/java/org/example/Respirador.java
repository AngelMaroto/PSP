package org.example;

public class Respirador {
    private boolean enUso = false;

    public synchronized void liberar() throws InterruptedException {
        while (!enUso) {
            wait(); // espera si el respirador ya está libre
        }
        enUso = false;
        System.out.println("Respirador Libre");
        notifyAll(); // notifica a los hilos esperando
    }

    public synchronized void usar() throws InterruptedException {
        while (enUso) {
            wait(); // espera si el respirador está ocupado
        }
        enUso = true;
        System.out.println("Respirador ocupado");
        notifyAll();
    }
}
