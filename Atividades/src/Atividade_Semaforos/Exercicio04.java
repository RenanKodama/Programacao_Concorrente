/*
    Universidade Tecnológica Federal do Paraná
    Programação Concorrente
    
    Renan Kodama Rodrigues 1602098

    Garantir acesso à seção crítica para no máximo N threads.
    Faça um código que possibilite que N threads estejam na seção crítica 
    simultaneamente.
*/

package Atividade_Semaforos;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Exercicio04 {

    Semaphore semaphore;
    int numThreads;
    int count;

    public Exercicio04(int sizeSemaphoro, int numThreads) {
        this.semaphore = new Semaphore(sizeSemaphoro);
        this.numThreads = numThreads;
        this.count = 0;
    }

    public void increments(String name) {
        try {
            this.semaphore.acquire();
        } catch (InterruptedException ex) {
            Logger.getLogger(Exercicio04.class.getName()).log(Level.SEVERE, null, ex);
        }

        this.count++;
        System.out.println(name + "|Contador: " + this.count);

        this.semaphore.release();
    }

    public void init() {
        for (int i = 0; i < this.numThreads; i++) {
            Increments_Threads thread = new Increments_Threads(this, "Thread" + i);
            thread.start();
        }
    }

}
