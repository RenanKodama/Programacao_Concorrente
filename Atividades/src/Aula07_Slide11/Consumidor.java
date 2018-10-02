/*
    Universidade Tecnológica Federal do Paraná
    Programação Concorrente

    Renan Kodama Rodrigues 1602098
*/

package Aula07_Slide11;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Consumidor extends Thread{

    Buffer_Circular buffer;
    
    public Consumidor(Buffer_Circular buff) {
        this.buffer = buff;
    }

    @Override
    public void run() {
        int value;
        
        while (true) {
            System.out.println("Removendo....");
            value = this.buffer.getValeu();
            System.out.println("Numero: " + value);
            sleep(value*10);
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

