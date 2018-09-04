/*
Universidade Tecnológica Federal do Paraná
Programação Concorrente

Renan Kodama Rodrigues 1602098
*/

package Aula03_Slide17;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SleepThreadAux extends Thread {
    
    List<Thread> vetorThreads;

    public SleepThreadAux(List<Thread> vetorThreads) {
        this.vetorThreads = vetorThreads;
    }

    
    public void sleep(int tempo) {
        try {
            Thread.sleep(tempo);
        } catch (InterruptedException ex) {
            //Logger.getLogger(ClasseRun.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void run() {
        for (Thread vetor : this.vetorThreads) {
            sleep(3500);
            System.out.println("Interrompendo Thread " + vetor.getId() + " ...");
            vetor.interrupt();
            sleep(5500);
        }
    }
}
