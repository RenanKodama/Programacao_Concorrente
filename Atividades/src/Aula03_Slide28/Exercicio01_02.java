/*
Universidade Tecnológica Federal do Paraná
Programação Concorrente

Renan Kodama Rodrigues 1602098

    1. Faça um programa em Java que consulte periodicamente o
    estado de um conjunto de threads.

    2. Faça um programa em Java para testar um conjunto de
    operações sobre um grupo de threads. Use o ThreadGroup.
*/




package Aula03_Slide28;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Exercicio01_02 extends Thread {

    ThreadGroup threadGroup = new ThreadGroup("Group01");

    Sleeping t1;
    Sleeping t2;
    Sleeping t3;
    Sleeping t4;
    Sleeping t5;
    Sleeping t6;

    public void reloadThread() {
        System.out.println("Carregar Threads...");
        t1 = new Sleeping(threadGroup, "t1");
        t2 = new Sleeping(threadGroup, "t2");
        t3 = new Sleeping(threadGroup, "t3");
        t4 = new Sleeping(threadGroup, "t4");
        t5 = new Sleeping(threadGroup, "t5");
        t6 = new Sleeping(threadGroup, "t6");
        
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
    }

    public void infoThreads() {

        Thread[] listThread = new Thread[threadGroup.activeCount()];
        threadGroup.enumerate(listThread);

        System.out.println("Threads Ativas: " + threadGroup.activeCount());
        System.out.println("Max. Permissão: "+threadGroup.getMaxPriority());
        System.out.println("Info: ");
        
        for (Thread thr : listThread) {
            System.out.println("\tId: "+ thr.getId());
            System.out.println("\tName: "+thr.getName());
            System.out.println("\tState: "+thr.getState());
        }
        sleep(5000);
    }
    
    public void sleep(int val){
        try {
            Thread.sleep(val);
        } catch (InterruptedException ex) {
            Logger.getLogger(Exercicio01_02.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void run() {
        reloadThread();
        while (true) {
            sleep(2000);
            if (threadGroup.activeCount() == 0) {
                reloadThread();
            }
            infoThreads();
        }
    }
}
