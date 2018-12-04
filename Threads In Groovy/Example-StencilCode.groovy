import java.util.concurrent.CountDownLatch


class Principal{   
    static void main(String[] args){
        def vetor = [1,2,2,1]
        def iterations = 10000

        StencilCode stenc = new StencilCode(vetor,iterations)
        stenc.init()
        
        println(vetor)

    }
}

class StencilCode{
    def vetor
    def iterations
    CountDownLatch doneSignal

    public StencilCode(vet, iterati){
        this.vetor = vet
        this.iterations = iterati
        this.doneSignal = new CountDownLatch(vetor.size()-2)
    }

    public void init(){
        def iterator = 0

        while(iterator <= this.iterations){
            
            for(int i=0;i<this.vetor.size();i++){
                Thread thr = new Thread(new Latch_Divisor(i,this.vetor,this.doneSignal))
                thr.start()
            }

            this.doneSignal.await()

            iterator++
            this.doneSignal = new CountDownLatch(2)
        }
    }
}


class Latch_Divisor implements Runnable{
    def position
    def vetor
    CountDownLatch doneSignal

    public Latch_Divisor(pos,vet,done){
        this.position = pos
        this.vetor = vet
        this.doneSignal = done
    }

    @Override
    public void run(){
        if((this.position != 0) && (this.position != this.vetor.size())){
            this.vetor[this.position] = (this.vetor[this.position - 1] + this.vetor[this.position + 1]) / 2
        }

        this.doneSignal.countDown()
    }
}
