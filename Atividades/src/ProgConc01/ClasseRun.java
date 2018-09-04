/*
Universidade Tecnológica Federal do Paraná
Programação Concorrente

Renan Kodama Rodrigues 1602098
*/

package ProgConc01;

import java.util.logging.Level;
import java.util.logging.Logger;


public class ClasseRun implements Runnable{

    @Override
    public void run() {
        System.out.println("SleepRun");
        try {
            Thread.sleep(6000);
            System.out.println("WakeUpRun");
        } catch (InterruptedException ex) {
            Logger.getLogger(ClasseRun.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
