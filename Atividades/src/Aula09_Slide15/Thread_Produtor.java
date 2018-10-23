package Aula09_Slide15;

import Aula07_Slide11.Produtor;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Thread_Produtor extends Thread {

    Exercicio02 ex_02;
    Random gerador;
    
    public Thread_Produtor(Exercicio02 ex_02) {
        this.gerador = new Random();
        this.ex_02 = ex_02;
    }

    @Override
    public void run() {
        int valor;
        while (true) {
            valor = this.gerador.nextInt(9)+1;
            ex_02.setValorLista(valor);
            System.out.println("Valor Inserido: "+valor);
            sleep(valor);
        }

    }
    
    public void sleep(int val) {
        try {
            Thread.sleep(val);
        } catch (InterruptedException ex) {
            Logger.getLogger(Produtor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
