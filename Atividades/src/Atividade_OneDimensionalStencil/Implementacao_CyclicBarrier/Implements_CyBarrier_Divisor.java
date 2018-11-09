/*
    Universidade Tecnológica Federal do Paraná
    Programação Concorrente
    
    Renan Kodama Rodrigues 1602098
    
*/

package Atividade_OneDimensionalStencil.Implementacao_CyclicBarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Implements_CyBarrier_Divisor implements Runnable {

    int position;
    double[] vetor;
    CyclicBarrier doneBarrier;
    
    

    public Implements_CyBarrier_Divisor(int position, double[] vetor, CyclicBarrier doneBarrier) {
        this.position = position;
        this.vetor = vetor;
        
        this.doneBarrier = doneBarrier;    
    }

    @Override
    public void run() {
        if ((this.position != 0) && this.position != (this.vetor.length - 1)) {
            double valor = (this.vetor[this.position - 1] + this.vetor[this.position + 1]) / 2;
            
            this.vetor[this.position] = valor;
        }
        
        
        try {
            this.doneBarrier.await();
        } catch (InterruptedException | BrokenBarrierException ex) {
            Logger.getLogger(Implements_CyBarrier_Divisor.class.getName()).log(Level.SEVERE, null, ex);
        }
                
    }

}
