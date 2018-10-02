/*
    Universidade Tecnológica Federal do Paraná
    Programação Concorrente
    
    Renan Kodama Rodrigues 1602098    
*/

package Aula07_Slide11;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Buffer_Circular {

    int[] buffer;
    int pos;
    int tam;

    Semaphore mutex;
    Semaphore vazio;
    Semaphore cheio;

    public Buffer_Circular(int tam) {
        this.buffer = new int[tam];
        this.pos = 0;
        this.tam = tam;

        this.mutex = new Semaphore(1);
        this.vazio = new Semaphore(0);
        this.cheio = new Semaphore(tam);
    }

    public void addValue(int val) {
        try {
            this.cheio.acquire();
            this.mutex.acquire();
        } catch (InterruptedException ex) {
            Logger.getLogger(Buffer_Circular.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(this.pos >= this.tam){
            this.pos = 0;
            System.out.println("Zerou!");
        }
        this.buffer[this.pos] = val;
        this.pos++;
        this.mutex.release();
        this.vazio.release();

    }

    public int getValeu() {
        int saida;

        try {
            this.vazio.acquire();
            this.mutex.acquire();
        } catch (InterruptedException ex) {
            Logger.getLogger(Buffer_Circular.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        saida = this.buffer[this.pos - 1];
        this.pos--;
        this.mutex.release();
        this.cheio.release();

        return saida;
    }

    public void init() {
        Consumidor thread_Cons = new Consumidor(this);
        Produtor thread_Prod = new Produtor(this);

        thread_Prod.start();
        thread_Cons.start();
    }
}
