/**
 * Classe 
 */
package gestionecampionati;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;


/**
 *
 * @author enrico
 */
public class Campionato {
    

    /** variabile in cui è salvato il tipo di sport */
    private String sport;
    /** Array delle squadre partecipanti al campionato, utile solo in fase di creazione del campionato */
    private ArrayList<Squadra> squadre;
    /** calendario associato al campionato */
    private Calendario c;

    public Campionato(String sport, ArrayList<Squadra> squadre, Calendario c) {
        
        
        this.sport = sport;
        this.squadre = squadre;
        this.c = c;
    }

    public Campionato(String sport) {
        this.sport = sport;
        c = null;
        squadre = new ArrayList<Squadra>();
       
        
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
        
       /* 
        for(int i=0; i<squadre.size(); i++){
         this.squadre.get(i).setNome(squadre.get(i).getNome());
         this.squadre.get(i).setCitta(squadre.get(i).getCitta());
        }
       */
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
     * @return
     */
    public boolean carica_calendario(String path){
    
        FileInputStream f;
        ObjectInputStream is;
        System.out.println(path);
        try {
            f = new FileInputStream(path);
            is = new ObjectInputStream(f);
            this.c = (Calendario) is.readObject();
            
            is.close();
            f.close();
            
            
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Calendario.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(Calendario.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    
    
    
    return true;
    }
    
    
 
    
    public boolean importa_squadre(String path){
    
        FileInputStream f;
        ObjectInputStream is;
        try{
        f = new FileInputStream(path);
        is = new ObjectInputStream(f);
        this.squadre = (ArrayList<Squadra>) is.readObject();
        is.close();
        f.close();
        
        
        }catch(IOException ex){
            System.out.println("File da caricare non trovato!! (Squadre) ");
        
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Campionato.class.getName()).log(Level.SEVERE, null, ex);
        }
    
        return true;
    }
    
    
    
    public int get_numSquadre(){
        return squadre.size();
    
    
    }

    public void nuovo(String sport) {
       this.sport = sport;
        c = null;
        squadre = new ArrayList<Squadra>();
    }
    
 
    
    
    
    
}
