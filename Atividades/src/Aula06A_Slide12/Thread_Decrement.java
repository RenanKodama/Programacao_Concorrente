/*
    Universidade Tecnológica Federal do Paraná
    Programação Concorrente

    Renan Kodama Rodrigues 1602098
 */
package Aula06A_Slide12;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Thread_Decrement extends Thread {

    Exercicio03 ex_03;
    int time;

    public Thread_Decrement(Exercicio03 ex, int time) {
        this.ex_03 = ex;
        this.time = time;
    }

    @Override
    public void run() {
        while (true) {
            this.ex_03.decrement();
            sleep(this.time);
        }
    }

    public void sleep(int val) {
        try {
            Thread.sleep(val);
            //System.out.println("Thread Decrement Acordou!");
        } catch (InterruptedException ex) {
            Logger.getLogger(Produtor.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
