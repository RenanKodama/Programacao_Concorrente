package Aula03_Slide28;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Exercicio03 extends Thread {

    int min;
    int max;
    int[] vetor;

    public Exercicio03(int[] vetor, int min, int max) {
        this.vetor = vetor;
        this.min = min;
        this.max = max;
    }

    @Override
    public void run() {
        int count = 0;
        int primo = 0;

        for (int i = this.min; i < this.max; i++) {
            count = 0;

            for (int j = 1; j < i; j++) {
                if (this.vetor[i] % this.vetor[j] == 0) {
                    count++;
                    primo = this.vetor[j];
                }
            }

            if (count == 2) {
                System.out.println("Primo: " + primo + " Range("+this.min+" to "+this.max+")");
            }

        }
        //sleep(5000);
    }

    public void sleep(int val) {
        try {
            Thread.sleep(val);
        } catch (InterruptedException ex) {
            Logger.getLogger(Exercicio01_02.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
