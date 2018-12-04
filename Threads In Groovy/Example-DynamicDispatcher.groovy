import static groovyx.gpars.actor.Actors.actor


def decryptor = actor {
    loop {
        react { message ->
            if (message instanceof String){
                reply "Tipo: A String|Recebido: "+message
                return false
            }

            if (message instanceof Double){
                reply 'Tipo: A Double|Recebido: '+message;
                return false
            }

            if (message instanceof Boolean){
                reply 'Tipo: Boolean|Recebido: '+message
                reply "Ultima MSG"
                return false
            }

            else{
                reply 'What ?|Recebido: '+message
                return true
            }
        }
    }
}



def principal = actor{
    decryptor.send("teste")
    decryptor.send(1.022d)
    decryptor.send(2)
    decryptor.send(false)

    loop{
        react{menssage ->
            println("${menssage}")

        }
    }
    
    
}

[decryptor, principal]*.join()
println("EndCode!")
