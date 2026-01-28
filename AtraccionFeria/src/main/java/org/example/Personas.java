package org.example;

import java.util.Random;

public class Personas implements Runnable{

    private int id;
    private Noria noria;

    public Personas(int id, Noria noria){
        this.id=id;
        this.noria=noria;
    }


    @Override
    public void run() {
        System.out.println("Persona "+id+" llega a la cola");

        int micabina = noria.subir(id);

        try {
            Random r = new Random();
            Thread.sleep(1000+r.nextInt(2000));
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        noria.bajar(micabina,id);

    }
}
