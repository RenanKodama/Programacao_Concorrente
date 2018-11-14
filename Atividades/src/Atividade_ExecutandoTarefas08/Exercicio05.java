/*
    Universidade Tecnológica Federal do Paraná
    Programação Concorrente
    
    Renan Kodama Rodrigues 1602098
    
    5. Faça um programa que possibilite agendar uma tarefa para ser executada
    em um horário especı́fico.
*/

package Atividade_ExecutandoTarefas08;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Exercicio05 {
    ScheduledExecutorService executor;
    ScheduledFuture scheduleFuture;
    int timeSeconds;
    Tarefa_Dummy task;
    
    public Exercicio05(int timeSeconds) {
        this.timeSeconds = timeSeconds;
        this.executor = Executors.newScheduledThreadPool(1);
        this.task = new Tarefa_Dummy();
        
        System.out.println("Tarefa Agendada para daqui "+timeSeconds+"s");
        this.scheduleFuture = this.executor.schedule(this.task, timeSeconds, TimeUnit.SECONDS);
        
        while (!this.scheduleFuture.isDone()){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Exercicio05.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        System.out.println("Fim Principal");
        this.executor.shutdown();
    }
    
    
    
    
    
    
}
