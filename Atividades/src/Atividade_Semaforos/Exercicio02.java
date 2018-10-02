/*
    Universidade Tecnológica Federal do Paraná
    Programação Concorrente
    
    Renan Kodama Rodrigues 1602098  

    2.Enviar sinalização para um ponto de encontro entre threads.
    Faça um código que uma thread t1 e t2 são inicializadas e t1 espera por t2 e vice-versa.
    Exemplo:
    t1:
        trecho1.1
        trecho1.2
    t2:
        trecho2.1
        trecho2.2
    
    thecho1.1 ocorre antes trecho2.2 e threcho2.1 ocorre antes de trecho1.2.
*/

package Atividade_Semaforos;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Exercicio02 {

    Semaphore semaphore;
    Trecho_Thread thr_01;
    Trecho_Thread thr_02;
    
    public Exercicio02() {
        this.semaphore = new Semaphore(1);
        this.thr_01 = new Trecho_Thread(this,"1");
        this.thr_02 = new Trecho_Thread(this,"2");
    }
    
    public void trecho(String message){
        try {
            this.semaphore.acquire();
        } catch (InterruptedException ex) {
            Logger.getLogger(Exercicio01.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(message);
        this.semaphore.release();
    }
    
    public void init(){
        this.thr_01.start();
        this.thr_02.start();
    }
}