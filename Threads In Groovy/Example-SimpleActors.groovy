import groovyx.gpars.actor.Actor
import groovyx.gpars.actor.DefaultActor

class RepeteMensageInterval extends DefaultActor {
    def mesage = "Aguardando MSM..."

    void afterStart() {
        println(mesage)
    }

    void act() {
        loop {
            react(3000){ msg ->
                if (msg == Actor.TIMEOUT) {
                    println('Nada recebido \nConversa Finalizada!')
                    stop()
                } else {
                    println(msg)
                }
            }
        }
    }
}


def repetMSG = new RepeteMensageInterval().start()

//repetMSG.send("oi")
repetMSG.join()

