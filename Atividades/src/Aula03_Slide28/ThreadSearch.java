package Aula03_Slide28;

public class ThreadSearch extends Thread {

    int min;
    int max;
    int valor_ToFind;
    int[] vetor;

    public ThreadSearch(int min, int max, int val, int[] vet, ThreadGroup tg, String st) {
        super(tg, st);
        this.min = min;
        this.max = max;
        this.valor_ToFind = val;
        this.vetor = vet;
    }

    @Override
    public void run() {

        for (int i = this.min; i < this.max; i++) {
            if ((i < this.vetor.length) && (this.vetor[i] == this.valor_ToFind)) {
                System.out.println("A Thread " + Thread.currentThread().getName()
                        + " encontrou " + this.valor_ToFind);

                Thread.currentThread().interrupt();
            }
        }

    }

}
