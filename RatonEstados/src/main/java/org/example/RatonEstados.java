package org.example;

import java.util.ArrayList;

public class RatonEstados {
    public static void main(String[] args) {
        Raton mickey = new Raton("Mickey", 3);
        ArrayList<Thread.State> estadosHilo = new ArrayList();
        Thread h = new Thread(mickey);
        estadosHilo.add(h.getState());
        h.start();
        while (h.getState()!=Thread.State.TERMINATED){
            if (!estadosHilo.contains(h.getState())){
                estadosHilo.add(h.getState());
            }
        }
        estadosHilo.add(h.getState());
        for (int i = 0; i<estadosHilo.size(); i++)
            System.out.println(estadosHilo.get(i));
    }
}
