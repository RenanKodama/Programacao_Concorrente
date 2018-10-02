/*
    Universidade Tecnológica Federal do Paraná
    Programação Concorrente
    
    Renan Kodama Rodrigues 1602098

    Garantir acesso exclusivo à seção crítica.
    Faça um código que possibilite que 2 ou mais threads realizem o incremento 
    de um contador. Faça a exclusão mútua com semáforo.
 */

package Atividade_Semaforos;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Exercicio03 {

    int count;
    Semaphore semaphore;
    Increment_Thread thr_01;
    Increment_Thread thr_02;
    Increment_Thread thr_03;

    public Exercicio03() {
        this.count = 0;
        this.semaphore = new Semaphore(1);

        this.thr_01 = new Increment_Thread(this,"thr01");
        this.thr_02 = new Increment_Thread(this,"thr02");
        this.thr_03 = new Increment_Thread(this,"thr03");
    }

    public void increment(String name) {
        try {
            this.semaphore.acquire();
        } catch (InterruptedException ex) {
            Logger.getLogger(Exercicio03.class.getName()).log(Level.SEVERE, null, ex);
        }

        this.count++;
        System.out.println(name+"|Contador: " + this.count);

        this.semaphore.release();
    }
    
    public void init(){
        this.thr_01.start();
        this.thr_02.start();
        this.thr_03.start();
    }
}
