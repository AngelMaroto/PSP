package org.example;

public class Empleado implements Runnable{
    private int idEmpleado;
    private final Impresora gestorImpresoras;

    public Empleado(Impresora gestorImpresoras, int idEmpleado) {
        this.gestorImpresoras = gestorImpresoras;
        this.idEmpleado = idEmpleado;
    }

    @Override
    public void run() {
        System.out.println("Empleado "+idEmpleado+" quiere imprimir");
        gestorImpresoras.usar(idEmpleado);

    }
}
