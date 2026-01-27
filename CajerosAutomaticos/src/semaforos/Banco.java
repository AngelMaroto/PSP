package semaforos;

import java.util.concurrent.Semaphore;
public class Banco {
 public static void main(String[] args){
     //Creamos el semáforo con 3 permisos
     //el parámetro true garantiza una cola FIFO

     Semaphore cajeros = new Semaphore(3, true);
     for (int i = 0; i < 11; i++) {
         new Thread(new Cliente(cajeros, i)).start();
 }
 }
}
