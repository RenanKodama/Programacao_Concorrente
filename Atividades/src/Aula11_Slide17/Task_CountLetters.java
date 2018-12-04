/*    
    Universidade Tecnológica Federal do Paraná
    Programação Concorrente
    
    Renan Kodama Rodrigues 1602098  
*/

package Aula11_Slide17;

import java.util.concurrent.ConcurrentMap;


public class Task_CountLetters implements Runnable {

    ConcurrentMap<String, Integer> letters;
    String conteudo;

    public Task_CountLetters(String conteudo, ConcurrentMap<String, Integer> letters) {
        this.letters = letters;
        this.conteudo = conteudo;
    }

    @Override
    public void run() {
        for (char letra : this.conteudo.toCharArray()) {
            if (this.letters.containsKey(Character.toString(letra))) {
                this.letters.put(Character.toString(letra), this.letters.get(Character.toString(letra))+1);
            } else {
                this.letters.put(Character.toString(letra), 1);
            }
        }

        //System.out.println("Sub Task is Done!");
    }

}
