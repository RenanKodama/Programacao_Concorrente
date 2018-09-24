/*
    Universidade Tecnológica Federal do Paraná
    Programação Concorrente

    Renan Kodama Rodrigues 1602098

    2. Escreva um monitor Counter que possibilita um processo
    dormir até o contador alcançar um valor.  A classe Counter
    permite duas operações: increment() e sleepUntil(int x).
 */
package Aula06A_Slide12;


public class Exercicio02 {

    int time_toWeakUp;
    int i;
    Dummy_Thread dummy;

    public Exercicio02(int time) {
        this.i = 0;
        this.dummy = new Dummy_Thread(this);
        this.time_toWeakUp = time;
    }

    public synchronized void increment() {
        this.i++;
    }

    public synchronized void dummy() {
        System.out.println("Thread Dummy Dormiu!");

        while (this.i <= this.time_toWeakUp) {
            this.dummy.sleep(1000);
            increment();

            //this.wait();
        }

        //this.notify();
        System.out.println("Thread Dummy Acordou!");
        System.out.println("Fanzendo nada....");
        this.i = 0;
    }

    public void init() {
        this.dummy.start();
    }

}
