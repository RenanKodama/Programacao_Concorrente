/*
    Universidade Tecnológica Federal do Paraná
    Programação Concorrente
    
    Renan Kodama Rodrigues 1602098    

    1.Enviar sinal para outra thread para indicar que um evento ocorreu.
    Faça um código que uma thread t1 e t2 são inicializadas simultaneamente, 
    mas a t2 pode somente continuar a execução após a sinalização de t1.
*/

package Atividade_Semaforos;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Exercicio01 {

    Semaphore semaphore;
    Dummy_Thread thr_01;
    Dummy_Thread thr_02;
    
    public Exercicio01() {
        this.semaphore = new Semaphore(1);
        this.thr_01 = new Dummy_Thread(this,"Thread01");
        this.thr_02 = new Dummy_Thread(this,"Thread02");
    }
    
    public void message(String message){
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
