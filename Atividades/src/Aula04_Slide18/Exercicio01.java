/*
Universidade Tecnológica Federal do Paraná
Programação Concorrente

Renan Kodama Rodrigues 1602098

    1.  Faça um programa em Java que use Threads para encontrar
        os n ́umeros primos dentro de um intervalo.  O m ́etodo que
        contabiliza os n ́umeros primos deve possuir como entrada:
        valor inicial e final do intervalo, n ́umero de threads.
*/

package Aula04_Slide18;

import Aula03_Slide28.Exercicio01_02;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Exercicio01 extends Thread {

    ListaCompartilhada lista;

    public Exercicio01(ListaCompartilhada l, ThreadGroup tg, String t1) {
        super(tg, t1);
        this.lista = l;
    }

    @Override
    public void run() {
        int numero;
        int count = 0;

        while (this.lista.getIndice() < this.lista.getSize()) {
            numero = this.lista.getNumber();
            count = 0;

            if (numero != -1) {
                for (int i = 1; i <= numero; i++) {
                    if (numero % i == 0) {
                        count++;
                    }
                }
                if (count == 2) {
                    System.out.println("Numero Primo: " + numero);
                }
            }
            sleep(1000);
        }
    }

    public void sleep(int val) {
        try {
            Thread.sleep(val);
        } catch (InterruptedException ex) {
            Logger.getLogger(Exercicio01_02.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
