package Aula09_Slide15;

import Aula07_Slide11.Produtor;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Thread_Consumidor extends Thread{

    Exercicio02 ex_02;

    public Thread_Consumidor(Exercicio02 ex_02) {
        this.ex_02 = ex_02;
    }

    @Override
    public void run() {
        int valor;
        while (true) {
            valor = this.ex_02.getValorLista();
            System.out.println("Valor Removido: "+valor);
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
