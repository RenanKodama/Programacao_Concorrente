/*
    Universidade Tecnológica Federal do Paraná
    Programação Concorrente
    
    Renan Kodama Rodrigues 1602098
    
*/

package Atividade_OneDimensionalStencil.Implementacao_Basica;

public class Stencil_Code implements Runnable {

    double[] vetor;
    int position;
    int iteracoes;

    public Stencil_Code(double[] vetor, int iteracoes) {
        this.vetor = vetor;
        this.iteracoes = iteracoes;
        this.position = 0;
    }

    @Override
    public void run() {
        int count_itera = 0;

        System.out.println("Iniciando Stencil Code...." + this.vetor.length);

        while (count_itera <= (this.iteracoes)) {

            if (this.position == (this.vetor.length)) {
                this.position = 0;
            }

            if ((this.position != 0) && this.position != (this.vetor.length - 1)) {
                double valor = (this.vetor[this.position - 1] + this.vetor[this.position + 1]) / 2;

                this.vetor[this.position] = valor;
            }
            this.position++;
            count_itera++;
        }
        
        System.out.println("Fim Stencil Code!");
    }

}
