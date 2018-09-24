/*
    Universidade Tecnológica Federal do Paraná
    Programação Concorrente

    Renan Kodama Rodrigues 1602098

    4. Implemente uma solução para o problema do Barbeiro Dorminhoco usando 
    monitores. Na barbearia há um barbeiro, uma cadeira de barbeiro e n cadeiras 
    para eventuais clientes esperarem a vez. Quando não há clientes, o barbeiro 
    senta-se na cadeira de barbeiro e cai no sono. Quando chega um cliente, 
    é preciso acordar o barbeiro. Se outros clientes chegarem enquanto o 
    barbeiro estiver cortando o cabelo de um cliente, eles se sentarão 
    (se houver cadeiras vazias) ou sairão da barbearia (se todas as cadeiras 
    estiverem ocupadas).
 */

package Aula06A_Slide12;

import java.util.logging.Level;
import java.util.logging.Logger;


public class Exercicio04 {

    int[] fila_cadeiras;
    int cadeiras_ocupadas;
    int tam;
    Thread_Barbeiro thr_barbe;
    Thread_GeradorClientes thr_gera;
    
    public Exercicio04(int cadeiras) {
        this.fila_cadeiras = new int[cadeiras];
        this.cadeiras_ocupadas = 0;
        this.tam = cadeiras;
        this.thr_barbe = new Thread_Barbeiro(this);
        this.thr_gera = new Thread_GeradorClientes(this);
    }

    public synchronized void addClient(int timeCutHair) {
        while (this.cadeiras_ocupadas >= (this.tam-1)){
            this.thr_gera.sleep(1000);
            try {
                this.wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Exercicio04.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        this.notify();
        System.out.println("Cliente Chegou!");
        this.fila_cadeiras[this.cadeiras_ocupadas] = timeCutHair;
        this.cadeiras_ocupadas++;
    }

    public synchronized void removeClient() {
        while (this.cadeiras_ocupadas <= 0) {
            this.thr_barbe.sleep(1000);
            try {
                this.wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Exercicio04.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        this.notify();
        int aux = this.fila_cadeiras[this.cadeiras_ocupadas-1];
        this.fila_cadeiras[this.cadeiras_ocupadas-1] = -1;
        this.cadeiras_ocupadas--;
        this.thr_barbe.cutHair(aux);
    }
    
    public void init(){
        this.thr_barbe.start();
        this.thr_gera.start();
        
    }

}
