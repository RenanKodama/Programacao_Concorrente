/*
    Universidade Tecnológica Federal do Paraná
    Programação Concorrente
    
    Renan Kodama Rodrigues 1602098
    
    6. Faça um programa que execute três algoritmos de ordenação para um
    conjunto de valores e exiba o resultado apenas do algoritmo que finalizar
    primeiro (use invokeAny ).
*/

package Atividade_ExecutandoTarefas08;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Exercicio06 {

    Collection<Callable<DadosVetor>> listTarefas;

    ExecutorService threadPool;
    int[] vet;

    public Exercicio06(int[] vetorInt) {
        this.listTarefas = new ArrayList<>();
        this.threadPool = Executors.newFixedThreadPool(3);
        this.vet = vetorInt;
    }

    public void init() {
        Tarefa_OrderByBubble bubb = new Tarefa_OrderByBubble(this.vet);
        Tarefa_OrderByHeap heap = new Tarefa_OrderByHeap(this.vet);
        Tarefa_OrderByQuick quick = new Tarefa_OrderByQuick(this.vet);

//        Future<Integer[]> future01 = this.threadPool.submit(bubb);
//        Future<Integer[]> future02 = this.threadPool.submit(heap);
//        Future<Integer[]> future03 = this.threadPool.submit(quick);
//        
        this.listTarefas.add(bubb);
        this.listTarefas.add(heap);
        this.listTarefas.add(quick);

        DadosVetor dados = null;

        while (dados == null) {
            try {
                dados = this.threadPool.invokeAny(this.listTarefas);
            } catch (InterruptedException | ExecutionException ex) {
                Logger.getLogger(Exercicio06.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        System.out.println("Uma Tarefa Concluida!");
        System.out.println("Tipo da Busca: " + dados.getNomeFunc());

        for (int i = 0; i < dados.getVet().length; i++) {
            System.out.print(" " + dados.getVet()[i]);
        }
        
        this.threadPool.shutdown();
    }

}
