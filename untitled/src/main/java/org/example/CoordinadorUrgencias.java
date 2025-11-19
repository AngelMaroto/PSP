package org.example;

public class CoordinadorUrgencias extends Thread{
    private String nombre;
    private Medico doctor;

    public CoordinadorUrgencias(String nombre, Medico doctor){
        this.nombre=nombre;
        this.doctor=doctor;
    }

    @Override
    public void run(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        doctor.interrupt();
    }
}
