package Aula06_Slide16;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Consumidor extends Thread {

    Buffer buffer;

    public Consumidor(Buffer buff) {
        this.buffer = buff;
    }

    @Override
    public void run() {
        while (true) {
                System.out.println("Removendo....");
                sleep(1000);
                
                System.out.println("Numero: " + this.buffer.getValeu());
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
