package Aula03_Slide17;

import ProgConc01.ClasseRun;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Exercicio03 extends Thread {

    public void sleep(int tempo) {
        try {
            System.out.println("Sleep");
            Thread.sleep(tempo);
            System.out.println("WakeUp");

        } catch (InterruptedException ex) {
            Logger.getLogger(ClasseRun.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void run() {
        
        Thread teste = new Thread(new Exercicio02("arquivoLeitura.txt"));
        teste.start();

        sleep(1500);
        System.out.println("Interrompendo...");
        teste.interrupt();
        sleep(2500);
        System.out.println("Interrompendo...");
        teste.interrupt();

    }
}
