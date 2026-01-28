package org.example;

import java.util.concurrent.Semaphore;

public class Estacion {
    private boolean[] bahias = {false, false};

    public Semaphore aforo = new Semaphore(2, true);

    public synchronized int acoplar(String nombreNave){
        for(int i =0; i < bahias.length; i++){
            if(!bahias[i]){
                bahias[i]=true;
                System.out.println(nombreNave+" se acopla en la bahia "+i);
                return i;
            }
        }
        return -1;
    }

    public synchronized void desacoplar(int bahia, String nombreNave){
        bahias[bahia]=false;
        System.out.println("la nave "+nombreNave+" se desacopla de la bahia "+bahia);
    }
}
