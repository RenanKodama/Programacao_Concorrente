/*
    Universidade Tecnológica Federal do Paraná
    Programação Concorrente

    Renan Kodama Rodrigues 1602098
*/

package Aula04_Slide18;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class ListaCompartilhada_Atomic {

    ArrayList<Integer> lista;
    
    AtomicInteger indice;
    int tam_MAX;
    int tam_MIN;
    int num_threads;
    int size;
    ThreadGroup threadGroup;

    public ListaCompartilhada_Atomic(int inic, int fim, int num_threads) {
        this.indice = new AtomicInteger(-1);
        
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
        this.indice.addAndGet(1);

        if (this.indice.get() == this.lista.size()) {
            return -1;
        } else {
            return this.lista.get(this.indice.get());
        }
    }
    
    public AtomicInteger getIndice(){
        return this.indice;
    }
    
    public int getSize(){
        return this.size;
    }
    
    public void numerosPrimos(){
        for(int i=0;i<this.num_threads;i++){
            Exercicio02_Atomic ex_02 = new Exercicio02_Atomic(this,this.threadGroup,"t"+i);
            
            ex_02.start();
        }
        
        
    }

}
