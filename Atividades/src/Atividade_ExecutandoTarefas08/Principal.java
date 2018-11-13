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
        
        //Inicializar vetor Exercicio 01
        int tamVet = 99999999;
        int[] vetor = new int[tamVet];
        
        for(int i=0;i<tamVet;i++){
            vetor[i] = random.nextInt(999999999);
        }
        
        //Inicializar matriz Exercicio 02
        int sizeX = 1000;
        int sizeY = 1000;
        int[][] matriz = new int[sizeY][sizeY];
        
        for(int i=0;i<sizeX;i++){
            for(int j=0;j<sizeY;j++){
                matriz[i][j] = random.nextInt(999)+1;
            }
        }
        
        
        
        
        
        /*EXERCICIO 01*/
//        Exercicio01 ex01 = new Exercicio01(vetor, 10);
//        ex01.searchBiggerNum();
        
        /*EXERCICIO 02*/
//        Exercicio02 ex02 = new Exercicio02(matriz, 10, sizeX, sizeY);
//        ex02.sumMatriz();

        /*EXERCICIO 03*/
        Exercicio03 ex03 = new Exercicio03(matriz, matriz, sizeX);
        ex03.multiMatriz();
    
    }
}
