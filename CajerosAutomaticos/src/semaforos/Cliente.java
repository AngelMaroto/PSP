package semaforos;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class Cliente implements Runnable{
    private Semaphore semaforo;
    private int idCliente;

    public Cliente(Semaphore semaforo, int id){
        this.semaforo = semaforo;
        this.idCliente = id;
    }

    @Override
    public void run() {
        try {
            System.out.println("Cliente "+idCliente+" llega y espera a que haya un cajero libre");
            semaforo.acquire();

            System.out.println("-->Cliente "+idCliente+" esta usando el cajero ");

            Random r = new Random();
            Thread.sleep((r.nextInt(3)+1)*1000);

            System.out.println("--Cliente "+idCliente+" termina y libera el cajero ");
        } catch (InterruptedException e){
            e.printStackTrace();
        } finally {
            semaforo.release();
        }
    }
}
