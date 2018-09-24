/*
    Universidade Tecnológica Federal do Paraná
    Programação Concorrente

    Renan Kodama Rodrigues 1602098
 */
package Aula06A_Slide12;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Thread_Barbeiro extends Thread {

    Exercicio04 ex_04;

    public Thread_Barbeiro(Exercicio04 ex) {
        this.ex_04 = ex;
    }

    @Override
    public void run() {
        
        while(true){
           this.ex_04.removeClient();
        }

    }

    public void sleep(int val) {
        try {
            System.out.println("Thr. Barbeiro Dormiu!");
            Thread.sleep(val);
            System.out.println("Thr. Barbeiro Acordou!");
        } catch (InterruptedException ex) {
            Logger.getLogger(Produtor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void cutHair(int timeToCut) {
        try {
            System.out.println("Thr. Barbeiro Ocupado!");
            Thread.sleep(timeToCut);
            System.out.println("Thr. Barbeiro Livre!");
        } catch (InterruptedException ex) {
            Logger.getLogger(Produtor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
