/*
    Universidade Tecnológica Federal do Paraná
    Programação Concorrente
    
    Renan Kodama Rodrigues 1602098

    Problema: One-Dimensional Stencil
*/

package Atividade_OneDimensionalStencil.Implementacao_Basica;

import java.util.Arrays;


public class Principal {
    public static void main(String[] args) {
        
        double[] vetor = new double[]{1,2,2,1};
        
        
        Stencil_Code st_c = new Stencil_Code(vetor, 500);
        st_c.run();
        
        System.out.println(Arrays.toString(vetor));
    }
}
