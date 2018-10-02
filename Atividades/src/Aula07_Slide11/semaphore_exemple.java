
package Aula07_Slide11;

import java.util.concurrent.Semaphore;


public class semaphore_exemple {
    private static final int MAX_PERMITS = 5;
    private final Semaphore semaphore =  new Semaphore(MAX_PERMITS,true);

    public semaphore_exemple(int numberThreads) {
        for (int i=0;i<numberThreads;i++){
            new test_semaphore_thread(semaphore).start();
        }
    
    }
    
    
    public static void main (String[] args){
        new semaphore_exemple(10);
    }
    
    
}

