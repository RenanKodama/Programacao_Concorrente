/*
Universidade Tecnológica Federal do Paraná
Programação Concorrente

Renan Kodama Rodrigues 1602098
*/

package Aula03_Slide28;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Principal {

    public static void main(String[] args) {
        
        //Gerador de numeros randons
        int vetor[] = new int[1000000];  
        for(int i=0;i<vetor.length;i++){
            vetor[i] = i+1;
        }
        
        /*      EXERCICIO 01        */
//        Exercicio01_02 ex01_02 = new Exercicio01_02();
//        ex01_02.start();


        /*      EXERCICIO 03        */
//        Exercicio03 ex03_th1 = new Exercicio03(vetor, 0, 20000);
//        Exercicio03 ex03_th2 = new Exercicio03(vetor, 20000 , 40000);
//        Exercicio03 ex03_th3 = new Exercicio03(vetor, 40000 , 60000);
//        Exercicio03 ex03_th4 = new Exercicio03(vetor, 60000 , 80000);
//        Exercicio03 ex03_th5 = new Exercicio03(vetor, 80000 , 100000);  
//        
//        ex03_th1.start();
//        ex03_th2.start();
//        ex03_th3.start();
//        ex03_th4.start();
//        ex03_th5.start();



        /*      EXERCICIO 04        */
//        Exercicio04 ex04 = new Exercicio04(80000,4,vetor);
//        ex04.inicializar();


        /*      EXERCICO 05         */
        Exercicio05 ex05_th1 = new Exercicio05(0, 5000000, vetor);
        Exercicio05 ex05_th2 = new Exercicio05(5000000, 10000000, vetor);
        Exercicio05 ex05_th3 = new Exercicio05(0, 10000000, vetor);
        
        try {
            ex05_th1.start();
            ex05_th1.join();
            ex05_th2.start();
            ex05_th2.join();
            ex05_th3.start();
        } catch (InterruptedException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println("Vetor Ordenado... ");
        for(int i : vetor){
            System.out.println(" "+i);
        }
        
    }
}
