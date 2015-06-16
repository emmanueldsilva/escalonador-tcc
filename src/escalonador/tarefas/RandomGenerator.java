/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package escalonador.tarefas;

/**
 *
 * @author Bill
 */
import java.util.*;

public class RandomGenerator {
    
    private Random r = new Random(System.currentTimeMillis());
    
    public synchronized int randint(){
        return r.nextInt();
    }
    
    public synchronized int randint(int n){
        return r.nextInt(n);
    }
    
}
