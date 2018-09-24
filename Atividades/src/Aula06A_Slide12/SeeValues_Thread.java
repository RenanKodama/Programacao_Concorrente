/*
Universidade Tecnológica Federal do Paraná
Programação Concorrente

Renan Kodama Rodrigues 1602098
 */
package Aula06A_Slide12;

import java.util.logging.Level;
import java.util.logging.Logger;

public class SeeValues_Thread extends Thread {

    Exercicio03 ex;
    int time;

    public SeeValues_Thread(Exercicio03 ex, int time) {
        this.ex = ex;
        this.time = time;
    }

    @Override
    public void run() {
        while(true){
            System.out.println("Bounded Value: "+this.ex.getBoundedCounter());
            sleep(this.time);
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
