/*
    Universidade Tecnológica Federal do Paraná
    Programação Concorrente
    
    Renan Kodama Rodrigues 1602098    
*/

package Aula09_Slide15;

import Aula07_Slide11.Produtor;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Thread_IncrementDecrement extends Thread {

    Exercicio01 ex_01;
    boolean increase;
    

    public Thread_IncrementDecrement(Exercicio01 ex_01,boolean increase) {
        this.ex_01 = ex_01;
        this.increase =  increase;
    }

    @Override
    public void run() {
        while(true){
            this.ex_01.incrementDecrement(this.increase);
            this.ex_01.verValor();
            //sleep(2000);
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
