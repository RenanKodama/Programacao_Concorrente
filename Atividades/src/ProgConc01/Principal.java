/*
Universidade Tecnológica Federal do Paraná
Programação Concorrente

Renan Kodama Rodrigues 1602098
*/ 
package ProgConc01;

//import java.util.Scanner;


public class Principal {
    public static void main(String[] args) {
        
//        Scanner entrada = new Scanner(System.in);
//        int quantidade = entrada.nextInt();     
//        for(int i=0;i<quantidade;i++){    
//            new Thread(new ClasseRun()).start();
//            new Thread(new ClasseThread()).start();
//            
//            System.out.println("\nalgumacoisa\n");
//        }
    
    
        ClasseMutavel aux = new ClasseMutavel();
        new Thread(new ProblemaConco(aux)).start();
        new Thread(new ProblemaConco(aux)).start();
        new Thread(new ProblemaConco(aux)).start();
        new Thread(new ProblemaConco(aux)).start();
    }
}
