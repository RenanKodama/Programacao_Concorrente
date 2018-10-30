
package Atividade_OneDimensionalStencil.Implementacao_Latch;

public class Stencil_Code implements Runnable{
    double[] vetor;
    int position;

    public Stencil_Code(double[] vetor, int position) {
        this.vetor = vetor;
        this.position = position;
    }

    @Override
    public void run() {
        if(this.position != 0 && this.position != (this.vetor.length-1)){
            double valor = (this.vetor[this.position-1] + this.vetor[this.position+1])/2;
            
            this.vetor[this.position] = valor;
        }
        
        
        
        
    }
    
    
    
    
    
    
}
