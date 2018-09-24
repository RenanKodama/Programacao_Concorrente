/*
    Universidade Tecnológica Federal do Paraná
    Programação Concorrente

    Renan Kodama Rodrigues 1602098
 */
package Aula06A_Slide12;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Thread_GeradorClientes extends Thread {

    Exercicio04 ex_04;

    public Thread_GeradorClientes(Exercicio04 ex) {
        this.ex_04 = ex;
    }

    @Override
    public void run() {
        Random gerador = new Random();
        while (true) {
            this.ex_04.addClient((gerador.nextInt(3) + 1));
        }
    }

    public void sleep(int val) {
        try {
            System.out.println("GeradorClient Dormiu!");
            Thread.sleep(val);
            System.out.println("GeradorClient Acordou!");

        } catch (InterruptedException ex) {
            Logger.getLogger(Produtor.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
