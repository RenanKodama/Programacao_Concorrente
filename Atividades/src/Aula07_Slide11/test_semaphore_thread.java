package Aula07_Slide11;

import java.util.concurrent.Semaphore;


public class test_semaphore_thread extends Thread {

    private final Semaphore semaphore;

    public test_semaphore_thread(Semaphore semaphore) {
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        int cont = 0;
        while (cont < 3) {
            try {
                System.out.println("Thread tentando Adquirir "+Thread.currentThread().getId());
                semaphore.acquire();
                System.out.println("Thread Adquiriu "+Thread.currentThread().getId());
                Thread.sleep(Math.round(Math.random()*100000));
                
            } catch (InterruptedException ex) {
                System.err.println("IE: " + ex.getMessage());
            } finally{
                System.out.println("Thread Liberou "+Thread.currentThread().getId());
                semaphore.release();
            }
            cont++;
        }

    }

}
