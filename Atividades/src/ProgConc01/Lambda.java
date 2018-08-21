
package ProgConc01;
public class Lambda {
    public static void main(String[] args) {
        new Thread( () -> {
                System.out.println("Teste01");
                }).start();    
    }
}
