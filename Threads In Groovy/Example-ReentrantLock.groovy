import java.util.concurrent.locks.ReentrantLock
import java.util.concurrent.Semaphore



class TestMultiThreadSleep implements Runnable {
    String name
    int timeToSleep
    def lock;


    public TestMultiThreadSleep(String name, int time,lockVar)   {
      this.name = name;
      this.timeToSleep = time
      this.lock = lockVar
    }

    static void main(String[] args) {
      ReentrantLock.metaClass.withLock={ critical ->
        lock()
        try{critical()}
        finally{unlock()}
      }

      def lock = new ReentrantLock();
      Thread thread1 = new Thread(new TestMultiThreadSleep("Thread01",1000,lock));          
      Thread thread2 = new Thread(new TestMultiThreadSleep("Thread02",2000,lock));
      Thread thread3 = new Thread(new TestMultiThreadSleep("Thread03",3000,lock));
      thread1.start();
      thread2.start();
      thread3.start();
    }

    @Override
    public void run() {
      f_Sleep3Times();
    }

    public void f_Sleep3Times(){
      this.lock.withLock{
        println "${name} Step 1"
        sleep(this.timeToSleep)
        println "${name} Step 2"
        sleep(this.timeToSleep)
        println "${name} Step 3" 
        sleep(this.timeToSleep)
      }
 
    }
}