/*
    Universidade Tecnológica Federal do Paraná
    Programação Concorrente
    
    Renan Kodama Rodrigues 1602098

    Problema: One-Dimensional Stencil
    Implementação: Barreiras cíclicas
        - Criar uma barreira cíclica com N-2 partes.
        - Criar N-2 tarefas para serem executadas em paralelo por threads.
        - No final de cada iteração, cada thread espera na barreira até todas outras alcançarem.
        - Arrays são invertidos e nova iteração inicia.
        Observar que:
            - Nenhuma thread é liberada depois de cada iteração, então o thread 
            pool deve ter no mínimo o número de tarefas (N-2).
*/

package Atividade_OneDimensionalStencil.Implementacao_CyclicBarrier;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Principal {

    public static void main(String[] args) {

        double[] vetor = new double[]{1, 2, 2, 1};
        
        Stencil_Code threadPrincipal = new Stencil_Code(vetor, 500);
        
        threadPrincipal.start();
        
        try {
            threadPrincipal.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        System.out.println(Arrays.toString(vetor));

    }
}
