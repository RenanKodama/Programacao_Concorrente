package Aula09_Slide15;

import Aula07_Slide11.Produtor;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Thread_Produtor extends Thread {

    Exercicio02 ex_02;

    public Thread_Produtor(Exercicio02 ex_02) {
        this.ex_02 = ex_02;
    }

    @Override
    public void run() {
        while (true) {

        }

    }
    
    public void sleep(int val) {
        try {
            Thread.sleep(val);
        } catch (InterruptedException ex) {
            Logger.getLogger(Produtor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
