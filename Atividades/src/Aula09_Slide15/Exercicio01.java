/*
    Faça um programa usando Lock para simular a atualiza ̧c ̃ao de
    um contador que  ́e acessado por m ́ultiplas threads.  O
    contador pode diminuir e aumentar.
 */
package Aula09_Slide15;

import java.util.concurrent.locks.ReentrantLock;

public class Exercicio01 {

    int contador;
    ReentrantLock lock;

    public Exercicio01() {
        this.contador = 0;
        this.lock = new ReentrantLock();
    }

    public void incrementDecrement(boolean increase) {
        this.lock.lock();
        try {
            if (increase) {
                this.contador++;
            } else {
                this.contador--;
            }
        } finally {
            this.lock.unlock();
        }
    }

    public void verValor() {
        System.out.println("Valor: " + this.contador);
    }

    public void init() {
        Thread_IncrementDecrement thr_01 = new Thread_IncrementDecrement(this, true);
        Thread_IncrementDecrement thr_02 = new Thread_IncrementDecrement(this, false);
        
        thr_01.start();
        thr_02.start();
    }

}
