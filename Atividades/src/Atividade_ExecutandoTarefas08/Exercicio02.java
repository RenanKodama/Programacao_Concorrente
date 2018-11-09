/*
    /*
    Universidade Tecnológica Federal do Paraná
    Programação Concorrente
    
    Renan Kodama Rodrigues 1602098

    2. Faça um programa que calcule a soma dos elementos de uma matriz
    MxN. Divida o programa em tarefas que somam as linhas. O programa
    deve possibilitar especificar o número de threads para resolver o problema.
*/

package Atividade_ExecutandoTarefas08;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Exercicio02 {
    int[][] matriz;
    int numThreads;
    int sizeX;
    int sizeY;
    ArrayList<Future<Integer>> listTarefas;
    ExecutorService threadPool;
    

    public Exercicio02(int[][] matriz, int numThreads, int sizeX, int sizeY) {
        this.matriz = matriz;
        this.numThreads = numThreads;
        this.listTarefas = new ArrayList<>();
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        this.threadPool = Executors.newFixedThreadPool(numThreads);
    }
    
    public void sumMatriz(){
        int posicao_Linha = 0;
        int somaTotal=0;
        
        while(posicao_Linha < this.sizeX){
            Tarefa_SumMatrix tarefa = new Tarefa_SumMatrix(posicao_Linha, this.sizeY, this.matriz);
            Future<Integer> future = this.threadPool.submit(tarefa);
            
            this.listTarefas.add(future);
            posicao_Linha++;
        }
        
        for(Future<Integer> ft : this.listTarefas){
            while(!ft.isDone()){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Exercicio02.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
        for(Future<Integer> ft : this.listTarefas){
            try {
                somaTotal += ft.get();
            } catch (InterruptedException | ExecutionException ex) {
                Logger.getLogger(Exercicio02.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        this.threadPool.shutdown();
        System.out.println("Soma Total: "+somaTotal);
        
    }
    
    
    
    
    
    
}
