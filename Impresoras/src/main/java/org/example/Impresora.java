package org.example;

import java.util.concurrent.Semaphore;

public class Impresora {
    private boolean[] impresorasOcupadas;
    private Semaphore semaforo;

    public Impresora(){
        this.impresorasOcupadas = new boolean[2];
        this.semaforo=new Semaphore(2, true);
    }

    public int usar(int empleado){
        int numImpresora = -1;
        try {
            semaforo.acquire();

            synchronized (this){
                numImpresora = encontrarImpresoraLibre();
                impresorasOcupadas[numImpresora]=true;
            }
            System.out.println("Empleado "+empleado+" está imprimiendo en la impresora "+(numImpresora+1));
            Thread.sleep(2000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            if (numImpresora!=-1){
                synchronized (this){
                    impresorasOcupadas[numImpresora]=false;
                }
                System.out.println("empleado "+empleado+" libera la impresora "+(numImpresora+1));
            }
            semaforo.release();
        }
        return numImpresora;
    }

    private int encontrarImpresoraLibre(){
        for (int i = 0; i < impresorasOcupadas.length ; i++) {
            if (impresorasOcupadas[i]==false)return i;
        }
        return -1;
    }
}
