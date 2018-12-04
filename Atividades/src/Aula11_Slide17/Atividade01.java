/*    
    Universidade Tecnológica Federal do Paraná
    Programação Concorrente
    
    Renan Kodama Rodrigues 1602098   

    1. Faça um programa usando Threads e ConcurrentMap para calcular a frequência 
    de cada letra em um texto. Obs: (i) dividir o texto para N threads 
    processarem ou (ii) cada thread lê e processa um arquivo diferente. 
*/

package Aula11_Slide17;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Atividade01 {
    static String local = "src/Aula11_Slide17/texto.txt";
    static int linhasToSerach = 3;
    static int numTasks = 10;
    
    
    public static void main(String[] args) {
        try {
            ConcurrentMap<String, Integer> letters = new ConcurrentHashMap<>();
            ExecutorService threadPool = Executors.newFixedThreadPool(numTasks);
            ArrayList<Future> listTarefas =  new ArrayList<>();
            
            Scanner file = new Scanner(new FileReader(local));
            
            
            int countLinha = 0;
            String conteudo = "";
            
            
            while(file.hasNext()){
                if(countLinha >= linhasToSerach){
                    Task_CountLetters task = new Task_CountLetters(conteudo, letters);
                    Future future = threadPool.submit(task);
                    listTarefas.add(future);
                    
                    countLinha = 0;
                    conteudo = "";
                }
                conteudo += file.nextLine();
                countLinha++;
            }
            
            System.out.println("Esperando Conclusão das Tarefas...");
            for(Future ft : listTarefas){
                while(!ft.isDone()){
                    Thread.sleep(1000);
                }
            }
            
            System.out.println("Resultado: ");
            for(String key : letters.keySet()){
                System.out.println(key+" "+letters.get(key));
            }
            
            System.out.println("EndCode!");
            threadPool.shutdown();
            
        } catch (FileNotFoundException | InterruptedException ex) {
            Logger.getLogger(Atividade01.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
