/*
    Universidade Tecnológica Federal do Paraná
    Programação Concorrente
    
    Renan Kodama Rodrigues 1602098
*/

package Aula09_Slide15;

import Aula07_Slide11.Produtor;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Thread_Leitor extends Thread {

    Exercicio03 ex_03;
    Random gerador;
    
    public Thread_Leitor(Exercicio03 ex_03) {
        this.ex_03 = ex_03;
        this.gerador = new Random();
    }

    @Override
    public void run() {
        while (true) {
            String str = ex_03.ler();
            System.out.println("Leitor> "+str);
            sleep((gerador.nextInt(9)+1)*1000);
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
