/*
    Universidade Tecnológica Federal do Paraná
    Programação Concorrente
    
    Renan Kodama Rodrigues 1602098   

    5.Após n threads sincronizarem em um ponto em comum, um trecho específico 
    (ponto crítico) pode ser executado por cada uma delas.
    Faça um código que possibilite barrar N threads em um ponto específico de 
    execução e, após todas alcançarem o ponto, todas devem executar o trecho 
    de código após esse ponto.
 */
package Atividade_Semaforos;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Exercicio05 {

    Semaphore semphore;
    Semaphore mutex;

    int countThreads;
    int sizeWall;
    int numThreads;
    
    int count;

    public Exercicio05(int numThreads, int sizeWall) {
        this.countThreads=0;
        this.count = 0;
        this.sizeWall = sizeWall;
        this.numThreads = numThreads;
                
        this.semphore = new Semaphore(0);
        this.mutex = new Semaphore(1);   
    }

    public void increment(String message) {
        try {
            this.mutex.acquire();
        } catch (InterruptedException ex) {
            Logger.getLogger(Exercicio05.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        this.countThreads++;
        
        System.out.println("Numero de Threads: "+this.countThreads);
        
        if (this.countThreads >= sizeWall) {
            this.semphore.release();
        }
        
        this.mutex.release();

        try {
            this.semphore.acquire();
        } catch (InterruptedException ex) {
            Logger.getLogger(Exercicio05.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        this.count++;
        System.out.println(message+"|Contador: "+this.count);
    }

    public void init(){
        for(int i=0;i<this.numThreads;i++){
            Blocked_Thread thread = new Blocked_Thread(this, "Thread"+i);
            thread.start();
        }
    }
}
