/*
Universidade Tecnológica Federal do Paraná
Programação Concorrente

Renan Kodama Rodrigues 1602098

    4. Faça uma Thread que monitora um conjunto de threads e
    exiba quais threads receberam sinais de interrupção.
*/

package Aula03_Slide17;

import java.util.List;


public class Exercicio04 extends Thread {

    List<Thread> vetorThreads;

    public Exercicio04(List<Thread> vetorThreads) {
        this.vetorThreads = vetorThreads;
    }

    public void sleep(int tempo) {
        try {
            System.out.println("Sleep");
            Thread.sleep(tempo);
            System.out.println("WakeUp");

        } catch (InterruptedException ex) {
            //Logger.getLogger(ClasseRun.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void run() {
        //iniciando vetor
        for (Thread vetor : this.vetorThreads) {
            vetor.start();
        }

        //criando e iniciando interrupções
        Thread aux = new TreadAux04(this.vetorThreads);
        aux.start();

        sleep(1000);

        //verificando interrupções
        List<Thread> threads = this.vetorThreads;
        while (true) {
            for (Thread vetor : threads) {
                if (vetor.isInterrupted()) {
                    System.out.println("A Thread " + vetor.getId() + " Gerou Interrupção...");
                    sleep(1000);
                }
            }
        }
    }

}
