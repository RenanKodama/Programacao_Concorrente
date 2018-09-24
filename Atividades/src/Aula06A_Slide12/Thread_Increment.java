/*
    Universidade Tecnológica Federal do Paraná
    Programação Concorrente

    Renan Kodama Rodrigues 1602098
 */
package Aula06A_Slide12;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Thread_Increment extends Thread {

    Exercicio03 ex_03;
    int time;

    public Thread_Increment(Exercicio03 ex, int time) {
        this.ex_03 = ex;
        this.time = time;
    }

    @Override
    public void run() {
        while (true) {
            this.ex_03.increment();
            sleep(this.time);
        }
    }

    public void sleep(int val) {
        try {
            Thread.sleep(val);
            //System.out.println("Thread Increment Acordou!");
        } catch (InterruptedException ex) {
            Logger.getLogger(Produtor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
