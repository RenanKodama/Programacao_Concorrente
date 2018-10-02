/*
    Universidade Tecnológica Federal do Paraná
    Programação Concorrente
    
    Renan Kodama Rodrigues 1602098  
 */

package Atividade_Semaforos;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Increment_Thread extends Thread {

    Exercicio03 ex03;
    String name;

    public Increment_Thread(Exercicio03 ex03, String name) {
        this.ex03 = ex03;
        this.name = name;
    }

    @Override
    public void run() {
        while (true) {            
            this.ex03.increment(this.name);
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
