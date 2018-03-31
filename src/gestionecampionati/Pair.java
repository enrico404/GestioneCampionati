
package gestionecampionati;

import java.io.Serializable;

/**
 * Pair identifica la singola coppia di squadre in competizione, si competiranno tra di loro due volte
 * @author enrico
 */
public class Pair implements Serializable{
    private Squadra a;
    private Squadra b;
    
    
    
    
    public Pair(Squadra a, Squadra b){
    
        this.a = a; 
        this.b = b;
    
    
    
    }
   

    /** Metodo che istanzia la classe, è un alternativa al costruttore con parametri 
     * @param a prima squadra
     * @param b seconda squadra
     */
    public void add(Squadra a, Squadra b){
        this.a = a;
        this.b = b;
    
    
    }
    
    
    
    public Squadra getA() {
        return a;
    }

    public void setA(Squadra a) {
        this.a = a;
    }

    public Squadra getB() {
        return b;
    }

    public void setB(Squadra b) {
        this.b = b;
    }
}
