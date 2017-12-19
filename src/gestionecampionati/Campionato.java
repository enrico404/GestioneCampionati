/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionecampionati;

import java.util.Vector;

/**
 *
 * @author enrico
 */
public class Campionato {
    
    /** identificatore univoco del campionato */
    private int id;
    /** Array delle squadre partecipanti al campionato */
    private Vector<Squadra> squadre;
    /** Array dei punteggi del campionato */
    private Vector<Punteggio> punteggi;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

   

    public Campionato(int id, Vector<Squadra> squadre, Vector<Punteggio> punteggi) {
        this.id = id;
        this.squadre = squadre;
        this.punteggi = punteggi;
    }
    
    
    public boolean inserisci(Squadra sq){
        
       if(!squadre.contains(sq)){
            this.squadre.add(sq);
            return true;
       }else
           return false;
    
    }
    
    
    public boolean remove(Squadra sq){
        
        if(squadre.contains(sq)){
        
            this.squadre.removeElement(sq);
            return true;
        }else return false;
    
    }
    
    
    public boolean modifica(int i, Squadra sq){
        if(i < squadre.size()){
            squadre.setElementAt(sq, i);
            return true;
        
        
        }
        
        System.out.println("La squadra non esiste!!");
        return false;
    }
    
    
    
}
