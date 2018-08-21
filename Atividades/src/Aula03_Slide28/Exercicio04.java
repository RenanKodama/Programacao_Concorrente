package Aula03_Slide28;

public class Exercicio04 {

    int valor;
    int qtd_Threads;
    int[] vetor;
    ThreadGroup threadGroup;

    public Exercicio04(int valor, int qtd_Threads, int[] vetor) {
        this.valor = valor;
        this.qtd_Threads = qtd_Threads;
        this.vetor = vetor;
        this.threadGroup = new ThreadGroup("Group01");
    }

    public void inicializar() {
        System.out.println("Iniciando Threads....");

        int min = 0;
        int incre = (this.vetor.length) / this.qtd_Threads;
        int max = incre;

        for (int i = 0; i < this.qtd_Threads; i++) {
            ThreadSearch thrS = new ThreadSearch(min, max, this.valor, this.vetor, threadGroup, "t" + i);
            min = max;
            max += max;
            thrS.start();
        }

    }
}
