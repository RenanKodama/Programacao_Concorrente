
package ProgConc01;

import java.util.logging.Level;
import java.util.logging.Logger;


public class ClasseThread extends Thread{
    
    
    @Override
    public void run() {
        System.out.println("SleepThread");    
        try {
            System.out.println("WakeUpThread");
            Thread.sleep(6000);
        } catch (InterruptedException ex) {
            Logger.getLogger(ClasseThread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
