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
    private Squadra a;
    private Squadra b;
    private Punteggio p;
    /** variabile booleana che indica se la partita è stata giocata o no */
    private boolean giocata;
    private Data d;
    
    
    
    
    public Partita(Squadra a, Squadra b, Punteggio p, Data d){
        this.a = a;
        this.b = b;
        this.p = p;
        this.giocata = true;
        this.d = d;
    
    }
    
    
    public boolean inserisci_part(Data d, Squadra a, Squadra b){
           
        this.d = d;
        this.giocata = false;
        this.a = a;
        this.b = b;
        this.p = new Punteggio();
        return true;
    
    }
    
    
    public void inserisci_punt(Punteggio p){
        this.p = p;
        this.giocata = true;
        
    
    
    }
    
    public void modifica_punt(Punteggio p){
        this.p = p;
        

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
