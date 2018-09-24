/*
    Universidade Tecnológica Federal do Paraná
    Programação Concorrente

    Renan Kodama Rodrigues 1602098
*/

package Aula06A_Slide12;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Produtor extends Thread {

    Exercicio01 buffer;

    public Produtor(Exercicio01 buff) {
        this.buffer = buff;
    }

    @Override
    public void run() {
        Random gerador = new Random();
        int number;

        while (true) {
            number = gerador.nextInt(10)+1;
            this.buffer.addValue(number);
            sleep(number);
        }
    }

    public void sleep(int val) {
        try {
            Thread.sleep(val);
            System.out.println("Thread Produtor Acordou!");
        } catch (InterruptedException ex) {
            Logger.getLogger(Produtor.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
