/*
    Universidade Tecnológica Federal do Paraná
    Programação Concorrente
    
    Renan Kodama Rodrigues 1602098   
 */
package Atividade_Semaforos;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Blocked_Thread extends Thread {

    Exercicio05 ex05;
    String name;
    
    public Blocked_Thread(Exercicio05 ex05, String name) {
        this.ex05 = ex05;
        this.name = name;
    }

    @Override
    public void run() {
        while (true) {
            ex05.increment(name);
            sleep(3000);
        }
    }

    public void sleep(int val) {
        try {
            Thread.sleep(val);
        } catch (InterruptedException ex) {
            Logger.getLogger(Aula06_Slide16.Produtor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
