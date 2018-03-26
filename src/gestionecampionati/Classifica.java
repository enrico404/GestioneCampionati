/*
 * La classifica utilizza il calendario, il quale contiene i risultati delle partite
* e da lì si possono calcolare i punteggi dinamicamente. In caso di parità vince casualmente una delle due squadre (come da regolamento)
 */
package gestionecampionati;

import java.util.ArrayList;

/** 
 * 
 * @author enrico
 */
public abstract class Classifica {
    private Campionato c;
    private ArrayList<Squadra> classifica;

    public Classifica(Campionato c) {
        this.c = c;
        classifica = new ArrayList<>();
        
    }
    
    

    /** funzione per calcolare il punteggio di ogni squadra, a seconda dello sport, e gli inserisce nell'array classifica */
    public abstract void calcola();

    public ArrayList<Squadra> getClassifica() {
        return classifica;
    }

    public void setClassifica(ArrayList<Squadra> classifica) {
        this.classifica = classifica;
    }

    public Campionato getCampionato() {
        return c;
    }

    public void setCampionato(Campionato c) {
        this.c = c;
    }

    public void stampa(){
        for(int i=0; i<classifica.size(); i++){
            System.out.println("Nome: " + classifica.get(i).getNome() + " Punteggio:" + classifica.get(i).getPunteggio());
        
        
        
        }
    
    
    }

    
    
}
