/*
    Universidade Tecnológica Federal do Paraná
    Programação Concorrente
    
    Renan Kodama Rodrigues 1602098
    
4. Faça um programa que periodicamente monitore mudanças em um
    conjunto de arquivos especificados. Se ocorreram mudanças, o programa
    deve registrá-las em um arquivo de log.
*/

package Atividade_ExecutandoTarefas08;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;



public class Exercicio04 {

    private final ScheduledExecutorService executor;
    private final ScheduledFuture scheduledFuture;
    private final Tarefa_CheckInte task;
    private String md5_Check_Old;
    private String md5_Check_New;


    
    public Exercicio04(String local) {
        this.executor = Executors.newScheduledThreadPool(1);
        this.task = new Tarefa_CheckInte(local, this);
        
        this.scheduledFuture = this.executor.scheduleAtFixedRate(this.task, 3, 2, TimeUnit.SECONDS); 
    }
    
    public String getMd5_Check_New() {
        return md5_Check_New;
    }

    public void setMd5_Check_New(String md5_Check) {
        this.md5_Check_New = md5_Check;
    }
    
    
    public String getMd5_Check_Old() {
        return md5_Check_Old;
    }

    public void setMd5_Check_Old(String md5_Check_Old) {
        this.md5_Check_Old = md5_Check_Old;
    }
}
