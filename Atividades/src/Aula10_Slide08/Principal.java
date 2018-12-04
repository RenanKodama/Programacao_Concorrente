/*
    Universidade Tecnológica Federal do Paraná
    Programação Concorrente
    
    Renan Kodama Rodrigues 1602098   
*/

package Aula10_Slide08;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Principal {

    static volatile int result;

    public static void main(String[] args) {
//
//        Exercicio01 ex_01 = new Exercicio01(4);
//        ex_01.run();
//        while (true) {
//            if (ex_01.isFinish()) {
//                System.out.println("Resultado: " + ex_01.getResult());
//                break;
//            }
//        }
//        
        
        Exercicio02 ex_02 = new Exercicio02(4);
        try {
            System.out.println("Resultado: "+ex_02.call());
        } catch (Exception ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
