/*
Universidade Tecnológica Federal do Paraná
Programação Concorrente

Renan Kodama Rodrigues 1602098
*/

package ProgConc01;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ProblemaConco implements Runnable {

    ClasseMutavel variavel_aux;

    public ProblemaConco(ClasseMutavel variavel_aux) {
        this.variavel_aux = variavel_aux;
    }

    public void sleep() {
        try {
            Thread.sleep(2000);
            //System.out.println("WakeUpRun");
        } catch (InterruptedException ex) {
            Logger.getLogger(ClasseRun.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            //System.out.println("Thread" + i + " DORMIU!");
            System.out.println("Var: " + variavel_aux.getValor());
            //System.out.println("SleepRun");
            sleep();
        }

    }
}
