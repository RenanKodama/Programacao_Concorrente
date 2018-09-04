/*
Universidade Tecnológica Federal do Paraná
Programação Concorrente

Renan Kodama Rodrigues 1602098

    1. Faça um programa em Java que inicie três threads e, cada
    thread, espere um tempo aleatório para terminar.
*/

package Aula03_Slide17;

import ProgConc01.ClasseRun;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Exercicio01 extends Thread {
    
    @Override
    public void run() {
        sleep();
    }

    public void sleep() {
        try {
            Random gerador = new Random();
            int tempo = (gerador.nextInt(10)+1)*1000;
            System.out.println("SleepThread "+tempo+"ms");
            Thread.sleep(tempo);
            System.out.println("WakeUpRun");
            
        } catch (InterruptedException ex) {
            Logger.getLogger(ClasseRun.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
