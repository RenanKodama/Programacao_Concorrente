
package Aula10_Slide08;

import java.util.concurrent.Callable;

public class Exercicio02 implements Callable<Integer>{
    int n;

    public Exercicio02(int n) {
        this.n = n;
    }
        
    
    
    @Override
    public Integer call() throws Exception {
        int result=1;
        
        for (int i = 1; i <= this.n; i++) {
            result = result * i;
        }
    
        return result;
    }
    
}
