/*
Universidade Tecnológica Federal do Paraná
Programação Concorrente

Renan Kodama Rodrigues 1602098
*/

package Aula03_Slide28;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Sleeping extends Thread {

    Sleeping(ThreadGroup threadGroup, String t1) {
        super(threadGroup, t1);
    }

    @Override
    public void run() {
            
            try {
                Random gerador = new Random();
                Thread.sleep((gerador.nextInt(10)) * 1000);

            } catch (InterruptedException ex) {
                Logger.getLogger(Sleeping.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            for(int i=0;i<1000000;i++){
                for(int j=0;j<10000000;j++){
                    for(int k=0;k<1000000;k++){
                        
                    }
                }
            }
    }
}
