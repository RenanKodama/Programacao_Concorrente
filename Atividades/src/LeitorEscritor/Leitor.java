package LeitorEscritor;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Leitor extends Thread {

    String texto;

    public Leitor(String texto) {
        this.texto = texto;
    }

    @Override
    public void run() {
        while(true){
            
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
