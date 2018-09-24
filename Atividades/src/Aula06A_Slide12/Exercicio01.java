/*
    Universidade Tecnológica Federal do Paraná
    Programação Concorrente

    1. Atividade: Implemente uma solução com monitor para o problema do
    Produtor-Consumidor usando um buffer circular
 */
package Aula06A_Slide12;

import Aula06_Slide16.Buffer;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Exercicio01 {

    int[] buffer;
    int pos;
    int tam;

    public Exercicio01(int tam) {
        this.buffer = new int[tam];
        this.pos = 0;
        this.tam = tam;
    }

    public synchronized void addValue(int val) {
        while (this.pos >= this.tam) {
            try {
                this.wait();
                System.out.println("Buffer Cheio!");
            } catch (InterruptedException ex) {
                Logger.getLogger(Buffer.class.getName()).log(Level.SEVERE, null, ex);
            }
            this.pos = 0;
        }
        
        this.buffer[this.pos] = val;
        this.pos++;
        this.notify();
    }

    public synchronized int getValeu() {
        int saida;
        
        while (this.pos <= 0) {
            try {
                this.wait();
                System.out.println("Buffer Vazio!");
            } catch (InterruptedException ex) {
                Logger.getLogger(Buffer.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }

        saida = this.buffer[this.pos-1];
        this.pos--;
        this.notifyAll();

        return saida;
    }

    public void init() {
        Consumidor thread_Cons = new Consumidor(this);
        Produtor thread_Prod = new Produtor(this);

        thread_Prod.start();
        thread_Cons.start();

    }
}
