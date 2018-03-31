
package gestionecampionati;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Classe partita, una partita è formata da due squadre contendenti 
 * un punteggio, una variabile che indica se è stata giocata o no e da dei possibili 
 * risultati intermedi.
 * @author enrico
 */
public class Partita implements Serializable{
    
    /** squadre contendenti */
    private Pair coppia;
    /** Punteggio della partita */
    private Punteggio p;
    /** variabile booleana che indica se la partita è stata giocata o no */
    private boolean giocata;
   
    /** array che mantiene in memoria i risultati intermedi delle partite(coppia di valori), 
     * è utilizzato per memorizzare i set parziali nel caso della pallavolo,
     * nel rugby potrebbe tenere in memoria ad esempio numero di mete delle due squadre 
     */
    private ArrayList<Punteggio> ris_intermedi;

    /** 
     * Costrtuttore con parametri della classe partita.
     * @param coppia squadre contentendenti della parita
     */
    public Partita(Pair coppia){
           
  
        this.giocata = false;
        this.coppia = coppia;
        this.p = new Punteggio();
        ris_intermedi = new ArrayList<>();
    
    
    }
    
    /**
     * Costruttore di default della classe partita.
     */
    
    public Partita(){
           
  
        this.giocata = false;
        this.coppia = null;
        this.p = new Punteggio();
        ris_intermedi = new ArrayList<>();
    
    
    }
    
    
    
    /** 
     * Metodo per l'inserimento del punteggio della partita, oltre a settare il 
     * punteggio, setta la partita a giocata.
     * @param  p punteggio della partita
     */
    public void inserisci_punt(Punteggio p){
        this.p = p;
        this.giocata = true;
        
    
    
    }
    
    /** 
     * Metodo per la modifica del punteggio di una determinata partita.
     * @param  p punteggio che modifica il vecchio punteggio della partita
     * 
     */
    public void modifica_punt(Punteggio p){
        this.p = p;
        

    }

    public Pair getCoppia() {
        return coppia;
    }

    public void setCoppia(Pair coppia) {
        this.coppia = coppia;
    }
    
    

    public Punteggio getP() {
        return p;
    }

    public void setP(Punteggio p) {
        this.p = p;
    }

    public boolean isGiocata() {
        return giocata;
    }

    public void setGiocata(boolean giocata) {
        this.giocata = giocata;
    }

    public ArrayList<Punteggio> getRis_intermedi() {
        return ris_intermedi;
    }

    public void setRis_intermedi(ArrayList<Punteggio> ris_intermedi) {
        this.ris_intermedi = ris_intermedi;
    }

    
  
    
    
    
}
