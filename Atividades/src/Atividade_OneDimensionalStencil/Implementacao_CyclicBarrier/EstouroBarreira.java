/*
    Universidade Tecnológica Federal do Paraná
    Programação Concorrente
    
    Renan Kodama Rodrigues 1602098
*/


package Atividade_OneDimensionalStencil.Implementacao_CyclicBarrier;

public class EstouroBarreira implements Runnable {

    Stencil_Code stCode;

    public EstouroBarreira(Stencil_Code classe) {
        this.stCode = classe;
    }

    @Override
    public void run() {
        this.stCode.count_itera++;
    }

}
