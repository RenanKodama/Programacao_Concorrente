
package ProgConc01;

public class ClasseMutavel {
    private int valor;
    
    public ClasseMutavel(){
        valor = 0;
    }
    
    public int getValor(){
        this.valor++;
        return this.valor;
    }
}
