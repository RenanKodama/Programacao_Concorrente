/*
    Universidade Tecnológica Federal do Paraná
    Programação Concorrente

    Renan Kodama Rodrigues 1602098

    Atividade Aula04 Slide numero: 18
*/

package Aula04_Slide18;



public class Principal {

    public static void main(String[] args) {
        long startTime;
        long endTime;
        
                
        /*EXERCICIO 01*/
//        ListaCompartilhada lista = new ListaCompartilhada(1, 1000000, 6);
//        lista.numerosPrimos();

        
        /*EXERCICIO 02 (Atomicidade)*/
//        startTime = System.nanoTime();
//        ListaCompartilhada_Atomic lista_atom = new ListaCompartilhada_Atomic(1, 10000000, 6);
//        lista_atom.numerosPrimos();
//        endTime = System.nanoTime() - startTime;
//        System.out.println("Tempo Total com Atomicidade: "+(endTime/10000)+"ns");

        
        /*EXERCICIO 02 (Bloco Sincronizado)*/
//        startTime = System.nanoTime();
//        ListaCompartilhada_Block lista_block = new ListaCompartilhada_Block(1, 10000000, 6);
//        lista_block.numerosPrimos();
//        endTime = System.nanoTime() - startTime;
//        System.out.println("Tempo Toal com Bloco Sincro.: "+(endTime/10000)+"ns");

        
        /*EXERCICIO 02 (Metodo Sincronizado)*/
//        startTime = System.nanoTime();
//        ListaCompartilhada_Method lista_method = new ListaCompartilhada_Method(1, 10000000, 6);
//        lista_method.numerosPrimos();
//        endTime = System.nanoTime() - startTime;
//        System.out.println("Tempo Total com Metodo Sincro.: "+(endTime/10000)+"ns");
        
    }
}
