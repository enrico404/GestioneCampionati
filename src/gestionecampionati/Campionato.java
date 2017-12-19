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
    /** variabile in cui è salvato il tipo di sport */
    private String sport;
    /** Array delle squadre partecipanti al campionato */
    private Vector<Squadra> squadre;
    /** calendario associato al campionato */
    private Calendario c;

    public Campionato(int id, String sport, Vector<Squadra> squadre, Calendario c) {
        this.id = id;
        this.sport = sport;
        this.squadre = squadre;
        this.c = c;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSport() {
        return sport;
    }

    public void setSport(String sport) {
        this.sport = sport;
    }

    public Vector<Squadra> getSquadre() {
        return squadre;
    }

    public void setSquadre(Vector<Squadra> squadre) {
        this.squadre = squadre;
    }

    public Calendario getC() {
        return c;
    }

    public void setC(Calendario c) {
        this.c = c;
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
