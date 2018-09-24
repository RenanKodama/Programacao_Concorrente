/*
    Universidade Tecnológica Federal do Paraná
    Programação Concorrente

    Renan Kodama Rodrigues 1602098
 */
package Aula06A_Slide12;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Dummy_Thread extends Thread {

    Exercicio02 ex_02;

    public Dummy_Thread(Exercicio02 ex) {
        this.ex_02 = ex;
    }

    @Override
    public void run() {
        while (true) {
            this.ex_02.dummy();
        }
    }

    public void sleep(int val) {
        try {
            Thread.sleep(val);
            //System.out.println("Thread Dummy Acordou!");
        } catch (InterruptedException ex) {
            Logger.getLogger(Aula06_Slide16.Produtor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
