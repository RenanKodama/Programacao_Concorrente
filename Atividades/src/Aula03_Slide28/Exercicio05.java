/*
Universidade Tecnológica Federal do Paraná
Programação Concorrente

Renan Kodama Rodrigues 1602098
    5. Faça um programa multithreaded em Java que ordene um
    vetor usando o Merge Sort recursivo. Faça com que a thread
    principal dispare duas threads para classificar cada metade do
    vetor.
*/

package Aula03_Slide28;

public class Exercicio05 extends Thread {

    int min;
    int max;
    int[] vetor;

    public Exercicio05(int min, int max, int[] vet) {
        this.min = min;
        this.max = max;
        this.vetor = vet;
    }


    @Override
    public void run() {
        MergeSortRec merge_rec = new MergeSortRec();
        merge_rec.mergeSort(this.vetor, this.min, this.min);
  
    }

}
