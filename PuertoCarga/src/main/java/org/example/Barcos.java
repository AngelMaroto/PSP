package org.example;

public class Barcos implements Runnable{
    private String nombre;
    private int toneladas;
    private Puerto puerto;
    private Thread dependencia;

    public Barcos(String nombre, int toneladas, Puerto puerto) {
        this.nombre = nombre;
        this.toneladas = toneladas;
        this.puerto = puerto;
    }

    public void setDependencia(Thread otradependencia) {
        this.dependencia = otradependencia;
    }

    @Override
    public void run() {
        try {
            if (dependencia!=null){
                System.out.println("esperando a que termine "+dependencia.getName());
                dependencia.join();
                System.out.println(nombre+" ya puede comenzar");
            }
            System.out.println(nombre+" solicita entrada");
            puerto.semaforo.acquire();

            int numMuella = puerto.ocupar(nombre);

            System.out.println(nombre+" cargando "+toneladas+" toneladas");
            Thread.sleep(toneladas*100);

            puerto.liberar(numMuella,nombre);
        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            puerto.semaforo.release();
            System.out.println(nombre+" sale del puerto");
        }
    }
}
