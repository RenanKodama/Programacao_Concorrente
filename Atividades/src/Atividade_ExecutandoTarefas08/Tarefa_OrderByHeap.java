/*
    Universidade Tecnológica Federal do Paraná
    Programação Concorrente
    
    Renan Kodama Rodrigues 1602098
*/

package Atividade_ExecutandoTarefas08;

import java.util.concurrent.Callable;

public class Tarefa_OrderByHeap implements Callable<DadosVetor> {
    int[] v;
    DadosVetor dadosVetor;
    
    public Tarefa_OrderByHeap(int[] v) {
        this.v = v;
        this.dadosVetor = new DadosVetor();
    }
    
    @Override
    public DadosVetor call() throws Exception {
        buildMaxHeap(v);
        int n = v.length;
 
        for (int i = v.length - 1; i > 0; i--) {
            swap(v, i, 0);
            maxHeapify(v, 0, --n);
        }
        
        this.dadosVetor.setNomeFunc("HeapSort");
        this.dadosVetor.setVet(this.v);
        return this.dadosVetor;
    }
    
 
    private void buildMaxHeap(int[] v) {
        for (int i = v.length / 2 - 1; i >= 0; i--) {
            maxHeapify(v, i, v.length);
        }
 
    }
 
    private void maxHeapify(int[] vetor, int pos, int tamanhoDoVetor) {
 
        int max = 2 * pos + 1, right = max + 1;
        if (max < tamanhoDoVetor) {
 
            if (right < tamanhoDoVetor && vetor[max] < vetor[right]) {
                max = right;
            }
 
            if (vetor[max] > vetor[pos]) {
                swap(vetor, max, pos);
                maxHeapify(vetor, max, tamanhoDoVetor);
            }
        }
    }
 
    public void swap(int[] v, int j, int aposJ) {
        int aux = v[j];
        v[j] = v[aposJ];
        v[aposJ] = aux;
    }


}
