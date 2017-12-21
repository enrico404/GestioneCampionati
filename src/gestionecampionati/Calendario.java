/*
 * Il calendario è un insieme di partite
 */
package gestionecampionati;

import java.util.ArrayList;

import java.io.*;



/**
 * 
 * @author enrico
 */
public class Calendario {

    /** Array delle squadre partecipanti al campionato  */
    private ArrayList<Squadra> squadre = new ArrayList<Squadra>();
    private ArrayList<Pair> coppie = new ArrayList<Pair>();
    
    /** Array delle partite,  */
    private ArrayList<Partita> partite = new ArrayList<Partita>();
    
   
    
    
    public Calendario(ArrayList<Squadra> squadre){
      
        this.squadre = squadre;
        
        
        
    
    
    }
    
    
    public boolean genera_calendario(){
        if(!genera_coppie()) System.out.println("Errore nella generazione delle coppie");
        for(int i=0; i<coppie.size(); i++){
        
            partite.add(new Partita(new Data(8, 2, 1990), coppie.get(i)));
        
        
        }
        
        
        return true;
    
    }
    
    
    
    
    public boolean genera_coppie(){
        for(int i =0 ; i< squadre.size(); i++){
            for(int j=0; j<squadre.size(); j++){
                if(i != j){
                   
                    
                    coppie.add(new Pair(squadre.get(i), squadre.get(j)));
                
                }
            }
       
        }
    
        return true;
    }
    
    
    public void stampa_calendario(){
        for(int i=0; i< partite.size(); i++){
            System.out.println(partite.get(i).getCoppia().getA().getNome()+ " vs "+ partite.get(i).getCoppia().getB().getNome()+ " "
                    + "Data: "+ partite.get(i).getD().getAnno());
        
        }
    
    
    }
    
    
   
    public void stampa_coppie(){
        for(int i=0; i<coppie.size(); i++){
            System.out.println(coppie.get(i).getA().getNome()+" "+coppie.get(i).getB().getNome());        
        
        }
    
    
    
    }
    
    
    
    
    
    
    
}
