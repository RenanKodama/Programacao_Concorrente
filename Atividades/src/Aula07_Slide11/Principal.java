/*
    Universidade Tecnológica Federal do Paraná
    Programação Concorrente
    
    Renan Kodama Rodrigues 1602098    

    1. Faça a implementação do produtor consumidor com fila circular usando 
    o bloqueio com semaforos

    OBS: Consumidor mais lento (modificar sleep) 
 */
package Aula07_Slide11;

public class Principal {

    public static void main(String[] args) {
        Buffer_Circular bfc = new Buffer_Circular(5);
        bfc.init();
    }
}
