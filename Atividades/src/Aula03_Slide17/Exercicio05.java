/*
Universidade Tecnológica Federal do Paraná
Programação Concorrente

Renan Kodama Rodrigues 1602098

    5. Faça uma thread Java que fica aguardando uma sequência
    numérica de tamanho arbitrário digitado por usuário para
    realizar uma soma. Use o join().
*/

package Aula03_Slide17;

import java.util.Scanner;

public class Exercicio05 extends Thread {

    static int valorSomar;

    public int getValorSomar() {
        return valorSomar;
    }
    
    public Exercicio05(int valorSomar) {
        this.valorSomar = valorSomar;
    }

    public void sleep(int tempo) {
        try {
            Thread.sleep(tempo);
        } catch (InterruptedException ex) {
            //Logger.getLogger(ClasseRun.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void run() {
        try {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Iniciando a Thread... ");
            System.out.println("BufferRead_Int: ");
            this.valorSomar = scanner.nextInt();
            System.out.println("Finalizando... ");
            sleep(3000);
            System.out.println("Iterrompendo Thread... ");
            
            throw new InterruptedException();
            
        } catch (InterruptedException ex) {
            System.out.println("Thread Finalizada!");
        }
    }
}
