/*
    Universidade Tecnológica Federal do Paraná
    Programação Concorrente
    
    Renan Kodama Rodrigues 1602098    
 */
package Atividade_Semaforos;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Dummy_Thread extends Thread {
    Exercicio01 ex01;
    String name;

    
    public Dummy_Thread(Exercicio01 ex01, String name) {
        this.ex01 = ex01;
        this.name = name;
    }

    @Override
    public void run() {
        while(true){
            this.ex01.message(this.name+" Fazendo nada...");
            this.sleep(2000);
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
