/*
    Universidade Tecnológica Federal do Paraná
    Programação Concorrente

    Renan Kodama Rodrigues 1602098

    3. Escreva um monitor BoundedCounter que possui um valor mínimo e máximo.  
    A classe possui dois métodos: increment() e decrement(). Ao alcançar os 
    limites mínimo ou máximo, a thread que alcan ̧cou deve ser bloqueada
 */

package Aula06A_Slide12;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Exercicio03 {

    Thread_Decrement thr_decre;     //Tread apenas para decrementar
    Thread_Increment thr_incre;     //Tread apenas para incrementar
    SeeValues_Thread thr_see;       //Tread apenas para ver valores
    
    int min;
    int max;
    int boundedCounter;

    public Exercicio03(int min, int max) {
        this.thr_decre = new Thread_Decrement(this, 10); //2º Atributo é duração
        this.thr_incre = new Thread_Increment(this, 8); //2º Atributo é duração
        this.thr_see = new SeeValues_Thread(this, 80); //2º Atributo é duração
        this.min = min;     //Valor minimo
        this.max = max;     //Valor maximo
        this.boundedCounter = (min + max) / 2;     //Counter
    }

    public synchronized void increment() {

        while (this.boundedCounter > this.max) {
            try {
                this.notify();
                this.wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Exercicio03.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        this.notify();
        this.boundedCounter++;
    }

    public synchronized void decrement() {

        while (this.boundedCounter < this.min) {
            try {
                this.notify();
                this.wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Exercicio03.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        
        this.boundedCounter--;
    }

    public void init() {
        this.thr_incre.start();
        this.thr_decre.start();
        this.thr_see.start();

    }
    
    public int getBoundedCounter(){
        return this.boundedCounter; 
    }

}
