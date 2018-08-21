package Aula03_Slide17;

import ProgConc01.ClasseRun;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Exercicio02 extends Thread {

    BufferedReader buffer;

    public Exercicio02(String local) {
        try {
            this.buffer = new BufferedReader(new FileReader("src/Aula03_Slide17/" + local));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Exercicio02.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void run() {
        try {
            while (buffer.ready()) {
                String linha = buffer.readLine();
                System.out.println(linha);
                sleep(5000);

                if (Thread.interrupted()) {
                    throw new InterruptedException();
                }
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(Exercicio02.class.getName()).log(Level.SEVERE, null, ex);
            for (int i = 0; i < 5; i++) {
                System.out.println("Fazendo algo...");
            }

        } catch (IOException ex) {
            Logger.getLogger(Exercicio02.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void sleep(int tempo) {
        try {
            System.out.println("Sleep");
            Thread.sleep(tempo);
            System.out.println("WakeUp");

        } catch (InterruptedException ex) {
            Logger.getLogger(ClasseRun.class.getName()).log(Level.SEVERE, null, ex);
            for (int i = 0; i < 5; i++) {
                System.out.println("Fazendo algo...");
            }
        }
    }

}
