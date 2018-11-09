/*
    Universidade Tecnológica Federal do Paraná
    Programação Concorrente
    
    Renan Kodama Rodrigues 1602098
*/

package Atividade_ExecutandoTarefas08;

import java.util.Random;

public class Principal {
    
    public static void main(String[] args) {
        Random random = new Random();
        
        //Inicializar vetor
        int tamVet = 99999999;
        int[] vetor = new int[tamVet];
        
        for(int i=0;i<tamVet;i++){
            vetor[i] = random.nextInt(999999999);
        }
        
        /*EXERCICIO 01*/
        Exercicio01 ex01 = new Exercicio01(vetor, 10);
        ex01.searchBiggerNum();
        
        
        
    
    }
}
