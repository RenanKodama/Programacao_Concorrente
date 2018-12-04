
import java.util.concurrent.BlockingQueue
import java.util.concurrent.LinkedBlockingQueue
import java.util.Random


class Principal{
    static void main(String[] args) {
        BlockingQueue queue = new LinkedBlockingQueue(20);


        Thread thread_Produ = new Thread(new Produtor(queue))
        Thread thread_Consu = new Thread(new Consumidor(queue))

        thread_Produ.start()
        thread_Consu.start()
    }
}

class Produtor implements Runnable{
    BlockingQueue queue


    public Produtor(q){
        queue = q
    }

    @Override
    public void run(){

        while(true){
            queue << Math.abs(new Random().nextInt() % 666) + 1
            println "Add: ${queue}"
            sleep(1000)
        
        }
    }  
}

class Consumidor implements Runnable{
    BlockingQueue queue

    public Consumidor(q){
        queue = q
    }

    @Override
    public void run(){
        while(true){
            def number = queue.take()
            println "Consu: ${number}"
            sleep(2000)
        }
    }  
}