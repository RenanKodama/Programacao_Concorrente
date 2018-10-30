/*
    Universidade Tecnológica Federal do Paraná
    Programação Concorrente
    
    Renan Kodama Rodrigues 1602098
    
    Pegar ambos garfos:  atomicamente garantir que um fil ́osofo
    pega os dois garfos simultaneamente.
 */
package Atividade_Philosophers_Dinner.Solution02;

import java.util.concurrent.Semaphore;

class DiningPhilosopher implements Resource {

    int n = 0;
    Semaphore[] fork = null;
    Semaphore lock;

    public DiningPhilosopher(int initN) {
        n = initN;
        this.lock = new Semaphore(1);
        fork = new Semaphore[n];
        for (int i = 0; i < n; i++) {
            fork[i] = new Semaphore(1);
        }
    }

    @Override
    public void pickup(int i) {
        try {
            this.lock.acquire();
            fork[i].acquire();
            fork[(i + 1) % n].acquire();
            this.lock.release();
        } catch (InterruptedException ex) {
        }
    }

    @Override
    public void drop(int i) {
        fork[i].release();
        fork[(i + 1) % n].release();
    }

    public static void main(String[] args) {
        DiningPhilosopher philosopher = new DiningPhilosopher(5);
        for (int i = 0; i < 5; i++) {
            new Thread(new Philosopher(i, philosopher)).start();
        }
    }
}
