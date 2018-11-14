/*
    Universidade Tecnológica Federal do Paraná
    Programação Concorrente
    
    Renan Kodama Rodrigues 1602098

    3. Faça um programa concorrente para multiplicar duas matrizes.
 */
package Atividade_ExecutandoTarefas08;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Exercicio03 {

    int[][] matriz01;
    int[][] matriz02;
    int sizeXY;
    int[][] matrizResult;
    ArrayList<Future<Integer>> listTarefas;
    ExecutorService threadPool;

    public Exercicio03(int[][] matriz01, int[][] matriz02, int sizeXY) {
        this.matriz01 = matriz01;
        this.matriz02 = matriz02;
        this.sizeXY = sizeXY;

        this.threadPool = Executors.newFixedThreadPool(sizeXY);
        this.listTarefas = new ArrayList<>();
    }

    public void multiMatriz() {
        
        System.out.println("Inicializando Tarefas ...");
        for (int i = 0; i < this.sizeXY; i++) {
            for (int j = 0; j < this.sizeXY; j++) {

                Tarefa_MultiMatriz tarefa = new Tarefa_MultiMatriz(this.matriz01, this.matriz02, i, j, this.sizeXY);

                Future<Integer> future = this.threadPool.submit(tarefa);
                this.listTarefas.add(future);
            }
        }
        
        System.out.println("Aguardando Conclusão....");
        for (Future<Integer> ft : this.listTarefas) {
            while (!ft.isDone()) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Exercicio03.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
        int countAux = 0;
        for(Future<Integer> ft : this.listTarefas){
            try {
                System.out.print(" "+ft.get());
                countAux++;
                if(countAux >= this.sizeXY){
                    System.out.println();
                    countAux=0;
                }
                
            } catch (InterruptedException | ExecutionException ex) {
                Logger.getLogger(Exercicio03.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        

        System.out.println("Matriz Resultado: ");
        for (int i = 0; i < this.sizeXY; i++) {
            for (int j = 0; j < this.sizeXY; j++) {
                System.out.print(" " + matrizResult[i][j]);
            }
            System.out.println();
        }
        
        this.threadPool.shutdown();
    }

}
