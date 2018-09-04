/*
    Universidade Tecnológica Federal do Paraná
    Programação Concorrente

    Renan Kodama Rodrigues 1602098
*/

package Aula04_Slide18;

import java.util.ArrayList;

public class ListaCompartilhada {

    ArrayList<Integer> lista;
    int indice;
    int tam_MAX;
    int tam_MIN;
    int num_threads;
    int size;
    ThreadGroup threadGroup;

    public ListaCompartilhada(int inic, int fim, int num_threads) {
        this.indice = -1;
        this.tam_MAX = fim;
        this.tam_MIN = inic;
        this.num_threads = num_threads;
        this.threadGroup = new ThreadGroup("Grupo01");
        
        this.lista = new ArrayList<>();

        for (int i = tam_MIN; i < tam_MAX; i++) {
            this.lista.add(i);
        }
        
        this.size = this.lista.size();

    }
    
    public int getNumber() {
        this.indice++;

        if (this.indice == this.lista.size()) {
            return -1;
        } else {
            return this.lista.get(this.indice);
        }
    }
    
    public int getIndice(){
        return this.indice;
    }
    
    public int getSize(){
        return this.size;
    }
    
    public void numerosPrimos(){
        for(int i=0;i<this.num_threads;i++){
            Exercicio01 ex_01 = new Exercicio01(this,this.threadGroup,"t"+i);
            
            ex_01.start();
        }
    }

}
