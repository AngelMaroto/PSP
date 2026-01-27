package org.example;

import java.util.concurrent.Semaphore;

public class Puerto {
    public boolean[] muelles = {false, false, false};
    public Semaphore semaforo = new Semaphore(3,true);

    public synchronized int ocupar(String nombreBarco){
        for (int i = 0; i < muelles.length; i++) {
            if (!muelles[i]){
                muelles[i]=true;
                System.out.println("el barco "+nombreBarco+
                        "ocupa el muelle "+i);
                return i;
            }
        }
        return -1;
    }

    public synchronized void liberar(int numeroMuelle, String nombreBarco){
        muelles[numeroMuelle]=false;
        System.out.println("el barco "+nombreBarco+" libera el muelle "+numeroMuelle);
    }
}
