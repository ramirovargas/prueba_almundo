package entidades;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Empleado {

    boolean libre;

    public boolean isLibre() {
        return libre;
    }

    public void setLibre(boolean libre) {
        this.libre = libre;
    }

    public boolean atenderLlamada() throws InterruptedException {

        Random r = new Random();
        int[] fiveRandomNumbers = r.ints(1, 5000, 10000).toArray();
        int randomNumber = r.ints(1, 5000, 10000).findFirst().getAsInt();

        try {
            setLibre(false);
            Thread.sleep(randomNumber);
            setLibre(true);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return this.libre;
    }


}
