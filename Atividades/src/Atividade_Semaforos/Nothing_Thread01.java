/*
    Universidade Tecnológica Federal do Paraná
    Programação Concorrente
    
    Renan Kodama Rodrigues 1602098  
 */
package Atividade_Semaforos;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Nothing_Thread01 extends Thread {

    Exercicio07 ex07;
    String name;
    
    public Nothing_Thread01(Exercicio07 ex07,String name) {
        this.ex07 = ex07;
        this.name = name;
    }

    @Override
    public void run() {
        while (true) {
            ex07.semaphore01(name);
            //this.sleep(2000);
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
