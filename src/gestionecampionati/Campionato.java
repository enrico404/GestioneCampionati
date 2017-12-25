/**
 * Classe 
 */
package gestionecampionati;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


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
    private ArrayList<Squadra> squadre = new ArrayList<Squadra>();
    /** calendario associato al campionato */
    private Calendario c;

    public Campionato(int id, String sport, ArrayList<Squadra> squadre, Calendario c) {
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

    public ArrayList<Squadra> getSquadre() {
        return squadre;
    }

    public void setSquadre(ArrayList<Squadra> squadre) {
        this.squadre = squadre;
    }

    public Calendario getC() {
        return c;
    }

    public void setC(Calendario c) {
        this.c = c;
    }

   
    
    /** Funzione per l'inserimento di una squadra nel campionato */
    public boolean inserisci_squadra(Squadra sq){
        
       if(!squadre.contains(sq)){
            this.squadre.add(sq);
            return true;
       }else
           return false;
    
    }
    
    
    /** Funzione per la rimozione di una squadra nel campionato */
    public boolean remove(Squadra sq){
        
        if(squadre.contains(sq)){
        
            this.squadre.remove(sq);
            return true;
        }else return false;
    
    }
    
    /** Funzione per la modifica di una squadra nel campionato */
    public boolean modifica(int i, Squadra sq){
        if(i < squadre.size()){
            squadre.set(i, sq);
            return true;
        
        
        }
        
        System.out.println("La squadra non esiste!!");
        return false;
    }
    
    /**
     *
     * @param nomeFile
     * @return
     */
    public boolean carica_calendario(String nomeFile){
    
        FileInputStream f;
        ObjectInputStream is;
        
        try {
            f = new FileInputStream("../GestioneCampionati/saves/"+nomeFile+".dat");
            is = new ObjectInputStream(f);
            this.c = (Calendario) is.readObject();
            
            is.close();
            f.close();
            
            
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Calendario.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Calendario.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Calendario.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    
    
    
    return true;
    }
    
    
    
    
    
}
