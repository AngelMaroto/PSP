package programa;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class Empleados implements Runnable{
    private Semaphore semaforo;
    private int idEmpleado;

    public Empleados(Semaphore semaforo, int id){
        this.semaforo=semaforo;
        this.idEmpleado=id;
    }

    @Override
    public void run() {
        try {
            System.out.println("El empleado numero " + idEmpleado + " intenta usar el programa");
            semaforo.acquire();

            Random r =  new Random();

            int tiempo = (r.nextInt(5)+1);

            System.out.println("El empleado "+idEmpleado+" empieza a usar el programa "+tiempo+" segundos");

            Thread.sleep(tiempo*1000);

            System.out.println("El empleado "+idEmpleado+" termina de usar el programa");
        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            semaforo.release();
        }
    }
}
