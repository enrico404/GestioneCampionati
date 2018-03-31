
package gestionecampionati;

import java.io.Serializable;

/**
 * Classe punteggio, i punteggi sono formati da due interi rispettivamente i due punteggi delle 
 * due squadre contendenti
 * @author enrico
 */
public class Punteggio implements Serializable  {
   
    /** punteggio della squadra a */
    private int pa;
    /** punteggio delal squadra b */
    private int pb;
   
    /** 
     * Costruttore con parametri della classe punteggio.
     * @param  pa punteggio della prima squadra
     * @param pb punteggio della seconda squadra
     */
      public Punteggio(int pa, int pb) {
  
        this.pa = pa;
        this.pb = pb;
   
    }
      
    public int getPa() {
        return pa;
    }

    public void setPa(int pa) {
        this.pa = pa;
    }

    public int getPb() {
        return pb;
    }

    public void setPb(int pb) {
        this.pb = pb;
    }

   /** Costruttore di default della classe punteggio. Azzera i punteggi delle due 
    * squadre contendenti.
    */
    public Punteggio(){
        this.pa = 0;
        this.pb = 0;
    
    }

  
    
    
    
}
