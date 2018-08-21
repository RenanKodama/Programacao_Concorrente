package Aula03_Slide17;

import java.util.List;

public class TreadAux04 extends Thread {

    List<Thread> vetorThreads;

    public TreadAux04(List<Thread> vetorThreads) {
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
