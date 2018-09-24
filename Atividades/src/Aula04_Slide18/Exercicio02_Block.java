/*
Universidade Tecnológica Federal do Paraná
Programação Concorrente

Renan Kodama Rodrigues 1602098

    2.  Modifique o c ́odigo para garantir que ser ́a thread-safe.
        Implemente tres versoes: Usando Atomic, sincronizando o
        m ́etodo e sincronizando o bloco
 */

package Aula04_Slide18;

import Aula03_Slide28.Exercicio01_02;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Exercicio02_Block extends Thread {

    ListaCompartilhada_Block lista;

    public Exercicio02_Block(ListaCompartilhada_Block l, ThreadGroup tg, String t1) {
        super(tg, t1);
        this.lista = l;
    }

    @Override
    public void run() {
        int numero;
        int count = 0;

        while (this.lista.getIndice().get() < this.lista.getSize()) {
            numero = this.lista.getNumber();
            count = 0;
            
                for (int i = 1; i <= numero; i++) {
                    if (numero % i == 0) {
                        count++;
                    }
                }
                if (count == 2) {
//                    System.out.println("Numero Primo: " + numero);
                }
//            sleep(1000);
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
