/*
    Universidade Tecnológica Federal do Paraná
    Programação Concorrente
    
    Renan Kodama Rodrigues 1602098
 */
package Atividade_Philosophers_Dinner.Solution03;

import java.util.logging.Level;
import java.util.logging.Logger;

class Philosopher implements Runnable {

    int id = 0;
    Resource fork = null;

    public Philosopher(int initId, Resource initr) {
        id = initId;
        fork = initr;
    }

    @Override
    public void run() {
        while (true) {
            try {
                System.out.println("Phil " + id + " thinking");
                Thread.sleep(30);
                System.out.println("Phil " + id + " hungry");
                sleep((5-1)*1000);
                fork.pickup(id);
                System.out.println("Phil " + id + " eating");
                Thread.sleep(40);
                fork.drop(id);
            } catch (InterruptedException e) {
                return;
            }
        }
    }

    public void sleep(int val) {
        try {
            Thread.sleep(val);
        } catch (InterruptedException ex) {
            Logger.getLogger(Aula06_Slide16.Produtor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
