/*
    Universidade Tecnológica Federal do Paraná
    Programação Concorrente
    
    Renan Kodama Rodrigues 1602098 

    Faça uma classe ArrayListThreadSafe usando ReadWriteLock.
    Teste usando threads que realizam leitura e escrita para essa
    estrutura.
 */

package Aula09_Slide15;

import java.util.concurrent.locks.ReentrantReadWriteLock;


public class Exercicio03 {
    String texto;
    ReentrantReadWriteLock readWriteLock;

    public Exercicio03() {
        this.texto = "";
        this.readWriteLock = new ReentrantReadWriteLock();
    
    }
    
    public void escrever(String texto){
        this.readWriteLock.writeLock().lock();
        try {
            this.texto += texto;
        } finally {
            this.readWriteLock.writeLock().unlock();
        }
    }
    
    
    public String ler(){
        this.readWriteLock.readLock().lock();
        try {
            return this.texto;
        } finally {
            this.readWriteLock.readLock().unlock();
        }
    }
    
    public void init(int numLeitores, int numEscritores){
        for(int i=0;i<numLeitores;i++){
            Thread_Leitor thr_leitores = new Thread_Leitor(this);
            thr_leitores.start();
        }
        
        for(int i=0;i<numEscritores;i++){
            Thread_Escritor thr_escritores = new Thread_Escritor(this);
            thr_escritores.start();
        }
        
    }
    
}
