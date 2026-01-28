package org.example;

public class Nave implements Runnable{
    private String nombre;
    private Estacion estacion;
    public Thread dependencia;

    public Nave(String nombre, Estacion estacion){
        this.nombre = nombre;
        this.estacion = estacion;
    }

    public void setDependencia(Thread otradependencia){
        this.dependencia = otradependencia;
    }

    @Override
    public void run() {
        try {
            if(dependencia!=null){
                System.out.println(nombre+" esta orbitando a la espera de la nave "+dependencia.getName());
                dependencia.join();
                System.out.println(nombre+" recibe señal y puede entrar");
            }
            System.out.println("nave "+nombre+" solicita permiso para entrar");
            estacion.aforo.acquire();

            int bahia = estacion.acoplar(nombre);
            System.out.println("la nave"+nombre+"realiza operaciones");
            Thread.sleep(2000);
            estacion.desacoplar(bahia,nombre);
        }catch(InterruptedException e){
            e.printStackTrace();
        }finally {
            estacion.aforo.release();
            System.out.println("nave "+nombre+" sale de la zona");
        }
    }
}
