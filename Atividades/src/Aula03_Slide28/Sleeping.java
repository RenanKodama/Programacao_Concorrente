package Aula03_Slide28;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Sleeping extends Thread {

    Sleeping(ThreadGroup threadGroup, String t1) {
        super(threadGroup, t1);
    }

    @Override
    public void run() {
            
            try {
                Random gerador = new Random();
                Thread.sleep((gerador.nextInt(10)) * 1000);

            } catch (InterruptedException ex) {
                Logger.getLogger(Sleeping.class.getName()).log(Level.SEVERE, null, ex);
            }

    }
}
