
package gestionecampionati;

import gestionecampionati.grafica.MyThread;
import gestionecampionati.grafica.ProgressBarFrame;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;



/**
 * Classe Campionato, è la classe principale. Un campionato appartiene ad un determinato sport, ha determinate squadre partecipanti,
 * contiene un calendario delle giornate e una volta giocate tutte le giorante, è possibile stilare una classifica
 * @author enrico
 */
public class Campionato {
    

    /** variabile in cui è salvato il tipo di sport */
    private String sport;
    /** Array delle squadre partecipanti al campionato, utile solo in fase di creazione del campionato */
    private ArrayList<Squadra> squadre;
    /** Calendario associato al campionato */
    private Calendario c;
    /** Classifica inerente al campionato */
    private Classifica cls; 
    
    
    /**
     * Primo costruttore con parametri del campionato.
     * @param sport sport a cui appartiene il campionato
     * @param squadre squadre partecipanti al campionato 
     * @param c  calendario appartenente al campionato
     */
    public Campionato(String sport, ArrayList<Squadra> squadre, Calendario c) {
               
        this.sport = sport;
        this.squadre = squadre;
        this.c = c;
    }

    /**
     * Primo costruttore con parametri del campionato.
     * @param sport sport a cui appartiene il campionato.
     */
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

   
    
    /** Funzione per l'inserimento di una squadra nel campionato 
     * @param sq squadra in input
     * @return true se l'inserimento della squadra è avvenuto con successo, false altrimenti
     * 
     */
    public boolean inserisci_squadra(Squadra sq){
        
       if(!squadre.contains(sq)){
            this.squadre.add(sq);
            return true;
       }else
           return false;
    
    }
    
    
    /** Funzione per la rimozione di una squadra nel campionato
     * @param sq squadra da rimuave all'interno dell'array squadre
     * @return true se la rimozione della squadra è avvenuto con successo, false altrimenti
     */
    
    public boolean remove(Squadra sq){
        
        if(squadre.contains(sq)){
        
            this.squadre.remove(sq);
            return true;
        }else return false;
    
    }
    
    /** Funzione per la modifica di una squadra nel campionato
     *  @param i indice della squadra all'interno dell'array delle squadre
     * @param sq squadra di sostituzione a quella vecchia
     * @return true se la modifica della squadra è avvenuta con successo, false altrimenti
     */
    public boolean modifica(int i, Squadra sq){
        if(i < squadre.size()){
            squadre.set(i, sq);
            return true;
        
        
        }
        
        System.out.println("La squadra non esiste!!");
        return false;
    }
    
    /**
     * Funzione per il caricamento del calendario in memoria
     * @param path percorso del file che sto caricando
     * @return true se il calendario è stato caricato correttamente, false altrimenti
     * @throws InterruptedException problemi con il thread che gestisce la progress bar
     */
    public boolean carica_calendario(String path) throws InterruptedException{
    
        FileInputStream f;
        ObjectInputStream is;
        
        ProgressBarFrame pFrame = new ProgressBarFrame("Caricando..");
        
        MyThread t = new MyThread(pFrame);
        
        new Thread(t).start();
        t.setValue(10);
        
      
        
         
        try {
            f = new FileInputStream(path);
            is = new ObjectInputStream(f);
            t.setValue(30);
            this.c = (Calendario) is.readObject();
            t.setValue(50);
          
            is.close();
            t.setValue(80);
            
            f.close();
            t.setValue(100);
     

           

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Calendario.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(Calendario.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    
    
    
    return true;
    }
    
    
 
    /** Funzione per importare le squadre da file 
     *  @param path percorso del file di input
     * @return true se l'importazione delle squadre è avvenuta con successo, false altrimenti
     */
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
    
 
    /**
     * Metodo per il calcolo della classifica, sfrutta il polimorfismo. Si usa una variabile di tipo classifica 
     * che può essere quindi assegnata a istanze appartenenti al suo tipo o ai suoi discendenti (Classifica_calcio, Classifica_pallavolo,
     * Classifica_rugby). Quando vado a richiamare il metodo calcola di cls viene effettuato un binding dinamico e in base al tipo di istanza che referenzia,
     * viene chiamata una modalità di calcolo della classifica differente.
     *
     */
    public void calcola_calssifica(){
        if(this.getSport().equals("calcio")){
            cls = new Classifica_calcio(this);
            cls.calcola();
            
        }
         if(this.getSport().equals("pallavolo")){
            cls = new Classifica_pallavolo(this);
            cls.calcola();
            
        }
          if(this.getSport().equals("basket")){
            cls = new Classifica_basket(this);
            cls.calcola();
            
        }
    
    
    }

    public Classifica getCls() {
        return cls;
    }

    public void setCls(Classifica cls) {
        this.cls = cls;
    }
    
    
    
}



