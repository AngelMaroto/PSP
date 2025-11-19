package org.example;

public class Medico extends Thread{

    private String nombre;
    private Respirador respirador;
    private boolean usarRespirador;

    public Medico(){
        this.nombre="Paco";
    }

    public Medico(String nombre, Respirador respirador, boolean usarRespirador){
        this.nombre=nombre;
        this.respirador=respirador;
        this.usarRespirador=usarRespirador;
    }


    @Override
    public void run() {
        try {
            while (true) {
                if (usarRespirador) {
                    respirador.usar();
                } else {
                    respirador.liberar();
                }
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println(nombre + " ha sido interrumpido");
        }
    }
}
