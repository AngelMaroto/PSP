package programa;

import java.util.concurrent.Semaphore;

public class Licencias {
    public static void main(String[] args) {
        Semaphore s = new Semaphore(5,true);

        for (int i = 0; i < 16; i++) {
            new Thread(new Empleados(s,i)).start();
        }
    }
}
