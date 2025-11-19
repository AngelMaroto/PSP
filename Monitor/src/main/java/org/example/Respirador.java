package org.example;

public class Respirador {
    private Boolean enUso=false;

    public void liberar(){
        enUso=true;
        System.out.println("Respirador Libre");
        notifyAll();
    }

    public synchronized void usar(){
        try {
            while (enUso){
                wait();
            }
            enUso=true;
            System.out.println("Respirador Libre");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
