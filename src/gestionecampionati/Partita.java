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
class Partita {
    
    /** squadre contendenti */
    private Pair coppia;
    private Punteggio p;
    /** variabile booleana che indica se la partita è stata giocata o no */
    private boolean giocata;
    private Data d;
    
    
    
    /**
    public Partita(Pair coppia, Punteggio p, Data d){
        this.coppia = coppia;
        this.p = p;
        this.giocata = true;
        this.d = d;
    
    }
    * */
    
    
    public Partita(Data d, Pair coppia){
           
        this.d = d;
        this.giocata = false;
        this.coppia = coppia;
        this.p = new Punteggio();
    
    
    }
    
    
    public void inserisci_punt(Punteggio p){
        this.p = p;
        this.giocata = true;
        
    
    
    }
    
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

    public Data getD() {
        return d;
    }

    public void setD(Data d) {
        this.d = d;
    }
    
  
    
    
    
}
