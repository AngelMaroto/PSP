package org.example;

import java.util.concurrent.Semaphore;

public class Aparcamiento {
    private final boolean[] plazas = new boolean[50];
    private final Semaphore semaforo = new Semaphore(50, true);

    public int entrar(String matricula) throws InterruptedException {
        semaforo.acquire();  // Espera a que un permiso esté disponible

        synchronized(plazas) {
            for (int i = 0; i < plazas.length; i++) {
                if (!plazas[i]) {
                    plazas[i] = true;  // Ocupa la plaza
                    System.out.println("Coche " + matricula + " ocupa plaza " + (i + 1));
                    return i;
                }
            }
        }
        return -1;  // No debería pasar si la lógica es correcta
    }

    public void salir(int plaza, String matricula) {
        synchronized(plazas) {
            plazas[plaza] = false;  // Libera la plaza
            System.out.println("Coche " + matricula + " libera plaza " + (plaza + 1));
        }
        semaforo.release();  // Libera el permiso
    }
}

