/*
    Universidade Tecnológica Federal do Paraná
    Programação Concorrente
    
    Renan Kodama Rodrigues 1602098
    
    Problema: One-Dimensional Stencil
    Implementação: Latch
        - Criar um novo latch para cada iteração com um contador igual N-2.
        - Criar N-2 tarefas para serem executadas em paralelo por threads. Uma thread principal espera
            todas as tarefas. Cada tarefa calcula o valor de 1 elemento do vetor.
        - Uma tarefa termina e avisa a thread principal que finalizou.
*/


package Atividade_OneDimensionalStencil.Implementacao_Latch;

import java.util.Arrays;
import java.util.concurrent.CountDownLatch;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Principal {
    public static void main(String[] args) {
        
        double[] vetor = new double[]{1,2,2,1};
        CountDownLatch done = new CountDownLatch(1);
        Stencil_Code threadPrincipal = new Stencil_Code(vetor, 500, done);
        
        try {
            threadPrincipal.start();
            done.await();
            System.out.println(Arrays.toString(vetor));
        } catch (InterruptedException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
