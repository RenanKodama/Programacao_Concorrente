package Aula06_Slide16;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Buffer {

    int[] buffer;
    int qtd;
    int tam;


    public Buffer(int tam) {
        this.buffer = new int[tam];
        this.qtd = 0;
        this.tam = tam;
    }

    public synchronized void addValue(int val) {
        while (this.qtd >= this.tam) {
            try {
                this.wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Buffer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        this.buffer[this.qtd] = val;
        this.qtd++;
        this.notify();
    }

    public synchronized int getValeu() {
        int saida;

        while (this.qtd <= 0) {
            try {
                this.wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Buffer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        saida = this.buffer[this.qtd -1];
        this.qtd--;
        this.notifyAll();

        return saida;
    }

    public int getTam() {
        return this.tam;
    }

    public void init() {
        Consumidor thread_Cons = new Consumidor(this);
        Produtor thread_Prod = new Produtor(this);

        thread_Prod.start();
        thread_Cons.start();

    }
}
