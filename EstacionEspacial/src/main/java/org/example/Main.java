package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Estacion estacion = new Estacion();

        Nave suministro = new Nave("Suministro",estacion);
        Nave exploracion = new Nave("Exploracion",estacion);
        Nave turista1 = new Nave("Turista1",estacion);
        Nave turista2 = new Nave("Turista2",estacion);

        Thread h1 = new Thread(suministro, "Hilo Suministro");
        Thread h2 = new Thread(exploracion, "Hilo exploracion");
        Thread h3 = new Thread(turista1);
        Thread h4 = new Thread(turista2);

        exploracion.setDependencia(h1);

        h1.start();
        h2.start();
        h3.start();
        h4.start();
        }
    }

