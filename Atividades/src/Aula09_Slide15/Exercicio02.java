/*
    Universidade Tecnológica Federal do Paraná
    Programação Concorrente
    
    Renan Kodama Rodrigues 1602098 

    Crie uma classe SharedFifoQueue e use Conditions para
    controlar se a fila está vazia ou cheia. Teste usando threads
    produtoras e consumidoras.
 */

package Aula09_Slide15;

import java.util.ArrayList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Exercicio02 {

    ArrayList<Integer> lista;
    int tamLista;
    Lock lock;
    Condition notFull;
    Condition notEmpty;

    public Exercicio02(int tamLista) {
        this.lista = new ArrayList<>();
        this.tamLista = tamLista;
        this.lock = new ReentrantLock();
        this.notEmpty = lock.newCondition();
        this.notFull = lock.newCondition();
    }

    public int getValorLista() {
        int valor=-1;
        this.lock.lock();
        
        try {
            while(this.lista.size() <= 0){
                System.out.println("Thread Consu. Esperando...");
                this.notEmpty.await();
            }
            
            valor = this.lista.get(0);
            this.lista.remove(0);
            this.tamLista--;
            this.notFull.signal();
            
        } catch (InterruptedException ex) {
            Logger.getLogger(Exercicio02.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            this.lock.unlock();
        }
        return valor; 
    }

    public void setValorLista(int valor) {
        this.lock.lock();
        try {
            while (this.lista.size() >= this.tamLista) {
                System.out.println("Thread Prod. Esperando...");
                this.notFull.await();
            }

            this.tamLista++;
            this.lista.add(valor);
            this.notEmpty.signal();

        } catch (InterruptedException ex) {
            Logger.getLogger(Exercicio02.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            this.lock.unlock();
        }
    }
    
    public void init(){
        Thread_Consumidor thr_consu = new Thread_Consumidor(this);
        Thread_Produtor thr_produ = new Thread_Produtor(this);
        
        thr_consu.start();
        thr_produ.start();
    }

}
