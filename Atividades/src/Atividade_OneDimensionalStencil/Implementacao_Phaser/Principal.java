/*
    Universidade Tecnológica Federal do Paraná
    Programação Concorrente
    
    Renan Kodama Rodrigues 1602098

    Problema: One-Dimensional Stencil
    Implementação: Barreiras cíclicas
      
*/

package Atividade_OneDimensionalStencil.Implementacao_Phaser;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Principal {

    public static void main(String[] args) {

        double[] vetor = new double[]{1, 65, 65, 1};
        
        Stencil_Code threadPrincipal = new Stencil_Code(vetor, 5000);
        threadPrincipal.start();
        
        try {
            threadPrincipal.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println(Arrays.toString(vetor));

    }
}
