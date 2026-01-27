package org.example;

import java.util.concurrent.Semaphore;

public class Puente {
    public static void main(String[] args) {
        Semaphore s = new Semaphore(1);
        for (int i = 0; i < 11; i++) {
            new Thread(new Coche(s, i)).start();
        }
    }
}
