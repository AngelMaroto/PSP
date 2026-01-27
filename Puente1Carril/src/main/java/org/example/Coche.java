package org.example;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class Coche implements Runnable{

    Semaphore semaforo;
    int id;

    public Coche(Semaphore semaforo, int id){
        this.semaforo=semaforo;
        this.id=id;
    }

    @Override
    public void run() {
        try {
            System.out.println("El coche numero "+id+" intenta cruzar el puente");
            semaforo.acquire();

            Random random = new Random();

            int tiempo = (random.nextInt(3)+1)*1000;
            Thread.sleep(tiempo);

            System.out.println("El coche "+id+" cruza en"+tiempo+" milisegundos");
        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            semaforo.release();
            System.out.println("El coche "+id+" sale del puente");
        }
    }
}
