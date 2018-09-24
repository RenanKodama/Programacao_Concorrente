/*
    Universidade Tecnológica Federal do Paraná
    Programação Concorrente

    Renan Kodama Rodrigues 1602098
*/

package Aula06A_Slide12;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Consumidor extends Thread{

    Exercicio01 buffer;

    public Consumidor(Exercicio01 buff) {
        this.buffer = buff;
    }

    @Override
    public void run() {
        int value;
        
        while (true) {
            System.out.println("Removendo....");
            value = this.buffer.getValeu();
            System.out.println("Numero: " + value);
            sleep(value);
        }
    }

    public void sleep(int val) {

        try {
            Thread.sleep(val);
            System.out.println("Thread Consumidor Acordou!");
        } catch (InterruptedException ex) {
            Logger.getLogger(Aula06_Slide16.Produtor.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}

