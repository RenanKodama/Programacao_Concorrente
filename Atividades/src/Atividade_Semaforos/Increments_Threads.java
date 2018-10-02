/*
    Universidade Tecnológica Federal do Paraná
    Programação Concorrente
    
    Renan Kodama Rodrigues 1602098  
 */

package Atividade_Semaforos;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Increments_Threads extends Thread {

    Exercicio04 ex04;
    String name;

    public Increments_Threads(Exercicio04 ex04, String name) {
        this.ex04 = ex04;
        this.name = name;
    }

    @Override
    public void run() {
        while (true) {            
            this.ex04.increments(this.name);
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
