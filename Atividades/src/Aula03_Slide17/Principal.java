/*
Universidade Tecnológica Federal do Paraná
Programação Concorrente

Renan Kodama Rodrigues 1602098
*/

package Aula03_Slide17;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Principal {

    public static void main(String[] args) {

        /*Ex.1.*/
//        for(int i=0;i<3;i++){
//            new Thread(new Exercicio01()).start();
//        }
//-----------------------------------------------------------------------

        /*Ex.2.*/
//        new Thread(new Exercicio02("arquivoLeitura.txt")).start();
//-----------------------------------------------------------------------

        /*Ex.3.*/ /*Usa o Ex.2. como complemento*/
//        Exercicio03 exemplo03 = new Exercicio03();
//        exemplo03.start();

        /*Ex.4.*/
//        List<Thread> vetorThreads = new ArrayList<>();
//
//        //criando vetor
//        for (int i = 0; i < 5; i++) {
//            vetorThreads.add(new Thread(new SleepThreadAux(vetorThreads)));
//        }
//        
//        Thread exemplo04 = new Thread(new Exercicio04(vetorThreads));
//        exemplo04.start();

        
        /*Ex.5.*/
        int somaReceber=0;
        
        Exercicio05 exemplo05 = new Exercicio05(somaReceber);
        //Thread exemplo05 = new Thread(new Exercicio05(somaReceber));
        exemplo05.start();
        
        try {
            exemplo05.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        System.out.println(exemplo05.getValorSomar());
        System.out.println("Serviço Finalizado! ....");
    }
}
