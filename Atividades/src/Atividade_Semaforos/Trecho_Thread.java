/*
    Universidade Tecnológica Federal do Paraná
    Programação Concorrente
    
    Renan Kodama Rodrigues 1602098  
 */

package Atividade_Semaforos;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Trecho_Thread extends Thread {

    Exercicio02 ex02;
    String name;
    int trecho;

    
    public Trecho_Thread(Exercicio02 ex02,String name) {
        this.ex02 = ex02;
        this.trecho = 0;
        this.name = name;
    }
    
    @Override
    public void run() {
        while (true) {
            this.trecho += 1;
            ex02.trecho("Trecho"+this.name+"."+this.trecho);
            sleep(2000);
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
