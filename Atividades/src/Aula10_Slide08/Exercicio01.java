/*
    Universidade Tecnológica Federal do Paraná
    Programação Concorrente
    
    Renan Kodama Rodrigues 1602098   
*/

package Aula10_Slide08;

public class Exercicio01 implements Runnable {

    int result;
    int n;
    boolean finish;

    
    
    public Exercicio01(int n) {
        this.finish = false;
        this.n = n;
        this.result = 1;
    }

    @Override
    public void run() {
        for (int i = 1; i <= this.n; i++) {
            this.result = this.result * i;
        }
        this.finish=true;
    }

    public boolean isFinish() {
        return finish;
    }

    public int getResult() {
        return result;
    }
}
