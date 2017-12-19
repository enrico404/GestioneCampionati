/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionecampionati;

/**
 *
 * @author enrico
 */
public class Punteggio  {
   
    
    private int pa;
    private int pb;
   

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

   
    public Punteggio(){
        this.pa = 0;
        this.pb = 0;
    
    }

    public Punteggio(int pa, int pb) {
  
        this.pa = pa;
        this.pb = pb;
   
    }
    
    
    
}
