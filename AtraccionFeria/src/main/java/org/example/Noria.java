package org.example;

import java.util.concurrent.Semaphore;

public class Noria {

    public boolean[] cabinas = {false, false, false, false};
    Semaphore semaforo = new Semaphore(4, true);

    private static int recaudacionTotal = 0;

    public int subir(int idPersona){
        int cabina = -1;
        try {
            semaforo.acquire();

            synchronized (this){
               for(int i = 0; i < cabinas.length; i++){
                   if(!cabinas[i]){
                       cabinas[i]=true;
                       cabina=i;

                       recaudacionTotal+=5;
                       System.out.println("Persona "+idPersona+" paga, total de recaudacion "+recaudacionTotal);
                       break;
                   }
               }
            }
            if(cabina!=-1){
                System.out.println("Persona "+idPersona+" se monta en la cabina "+cabina);
            }

        }catch (InterruptedException e){
            e.printStackTrace();
        }
        return cabina;
    }
    public void bajar(int numCabina, int idPersona){
        synchronized (this){
            cabinas[numCabina]=false;
        }
        System.out.println("persona "+idPersona+" baja de la cabina "+numCabina);
        semaforo.release();
    }

}
