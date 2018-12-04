package Aula11_Slide09;

import java.util.ArrayList;

public class Baralho {

    String[] naipes;
    String[] valores;
    ArrayList<Cartas> decl;

    public Baralho(String[] naipes, String[] valores, ArrayList<Cartas> decl) {
        this.naipes = naipes;
        this.valores = valores;
        this.decl = decl;
    }
    
    
    public void create_Deck(){
        for(String naipe : this.naipes){
            for(String valor : this.valores){
                Cartas carta = new Cartas(naipe,valor);
                this.decl.add(carta);
            }
        }
        
        System.out.println("End Create Deck!");
    }
    
}
