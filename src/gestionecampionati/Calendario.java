
package gestionecampionati;

import java.util.ArrayList;

import java.io.*;
import java.util.Collections;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;



/**
 *  Il calendario è suddiviso in due gironi principali, girone di andata e girone di ritorno.
 *  Ogni girone contiene determinate partite, le quali formate da coppie di squadre contendenti
 * @author enrico
 */
public class Calendario implements Serializable {

    /** Array delle squadre partecipanti al campionato, utile per salvare i dati delle squadre */
    private ArrayList<Squadra> squadre = new ArrayList<Squadra>();
    private ArrayList<Pair> coppie = new ArrayList<Pair>();
    
    /** Array delle partite,  */
    private ArrayList<Partita> gironeAndata = new ArrayList<Partita>();
    private ArrayList<Partita> gironeRitorno = new ArrayList<Partita>();;

    
    
  
    
   
    
    
    
    public Calendario(ArrayList<Squadra> squadre){
      
        this.squadre = squadre;

    
    }
   
    /**
     * Metodo per la generazione del calendario. Vengono generati due gironi di partite casualmente.
     * Il girone di ritorno è uguale al girone di andata ma con le squadre contendenti invertite, 
     * la squadra che giocava in casa giocherà in trasferta e viceversa.
     * 
     * @return valore booleano che indica se il calendario è stato generato correttamente
     */
    
    public boolean genera_calendario(){
        
                
        Random rand = new Random();
        if(!genera_coppie()) System.out.println("Errore nella generazione delle coppie");
        
        
        
         Pair coppiaTmp;
         Partita tmp;
         ArrayList<Pair> prese = new ArrayList<Pair>();
        for(int i=0; i<coppie.size(); i++){ 
            do{
           
                coppiaTmp = coppie.get(rand.nextInt(coppie.size()));
                tmp = new Partita(coppiaTmp);
          
            
            }while(prese.contains(coppiaTmp));
            gironeAndata.add(tmp);
            prese.add(coppiaTmp);
        }
        
        
        
        for(int i = 0; i< coppie.size(); i++){
            Pair tmp2 = new Pair(gironeAndata.get(i).getCoppia().getB(), gironeAndata.get(i).getCoppia().getA() );
            tmp = new Partita(tmp2);
            gironeRitorno.add(tmp);
        
        
        }
        
        
        return true;
    }
        
    /** 
     * Metodo per la cancellazione dei risultati del calendario. Tutte le partite vengono azzerate 
     * e settate a non giocate.
     */
    
     public void cancella_ris(){
        for(int i=0; i<gironeAndata.size(); i++){
            gironeAndata.get(i).setP(new Punteggio(0,0));
            gironeAndata.get(i).setGiocata(false);
        
        }
        for(int i=0; i<gironeRitorno.size(); i++){
            gironeRitorno.get(i).setP(new Punteggio(0,0));
            gironeRitorno.get(i).setGiocata(false);
        
        }
    
    }
    
    
    /**
     * Generazione campionato con date. Versione vecchia.
    
    public boolean genera_calendario(){
        Random rand = new Random();
        Calendar cal = Calendar.getInstance();
        Calendar tmp = Calendar.getInstance();
      
        int g,m,an;
        
           Data d;
            //array locale per controllare che le date non vengano prese più volte
            ArrayList<Data> prese = new ArrayList<Data>();
           
        
        
        if(!genera_coppie()) System.out.println("Errore nella generazione delle coppie");
        for(int i=0; i<coppie.size(); i++){
            
         
            
            
            do{
            
            d = new Data(g= rand.nextInt(32)+1,  m = rand.nextInt(12), an= rand.nextInt(cal.get(Calendar.YEAR)+2));
            tmp.set(d.getAnno(), d.getMese(), d.getGiorno());
          
            }while(!d.is_valid() || prese.contains(d) || cal.after(tmp) ); //controllo che la data del calendario di oggi non sia dopo la data della partita
             
             prese.add(d);
             
            partite.add(new Partita(d , coppie.get(i)));
             
        
        }
        
        
        return true;
    
    }
    
    */
    
    
     /**
      * Metodo per la generazione delle varie coppie di squadre contendenti. 
      * La generazione delle coppie è casuale poichè viene effettuato uno shuffle delle 
      * squadre prima di essere create le coppie.
      * @return true se la generzione delle coppie è avvenuta con successo 
      */
    public boolean genera_coppie(){
        Collections.shuffle(squadre);
        for(int i =0 ; i< squadre.size(); i++){
            for(int j=i; j<squadre.size(); j++){
                if(i != j){

                    coppie.add(new Pair(squadre.get(i), squadre.get(j)));
                
                }
            }
       
        }
    
        return true;
    }
    
    
    /**
     * Metodo per la stampa su standard output l'intero calendario. E' utile 
     * sopratutto in fase di debug.
     * 
     */
    
    public void stampa_calendario(){
        System.out.println("Girone di andata: ");
        for(int i=0; i< gironeAndata.size(); i++){
            System.out.println(gironeAndata.get(i).getCoppia().getA().getNome()+ " vs "+ gironeAndata.get(i).getCoppia().getB().getNome());
        
        }
        
        System.out.println("Girone di ritorno: ");
    
        for(int i=0; i< gironeRitorno.size(); i++){
            System.out.println(gironeRitorno.get(i).getCoppia().getA().getNome()+ " vs "+ gironeRitorno.get(i).getCoppia().getB().getNome());
        
        }
    
    }
    
    
   /**
     * Metodo per la stampa su standard output le coppie di squadre contendenti generate.
     * E' utile sopratutto in fase di debug.
     * 
     */
    public void stampa_coppie(){
        for(int i=0; i<coppie.size(); i++){
            System.out.println(coppie.get(i).getA().getNome()+" "+coppie.get(i).getB().getNome());        
        
        }

    }
    
  
    
    /** Metodo per il salvataggio del calendario su file.
     * @deprecated  ****METODO DEPRECATO****
     * @param nomeFile nome del file
     * @return true in caso di salvataggio avvenuto con successo
     */
    public boolean salva(String nomeFile){
        FileOutputStream f; 
        ObjectOutputStream os;
        
        try {
            f = new FileOutputStream("../GestioneCampionati/saves/"+nomeFile+".dat");
            os = new ObjectOutputStream(f);
            os.writeObject(this);
            os.flush();
            os.close();
            
        } catch (IOException ex) {
            Logger.getLogger(Calendario.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        return true;
    
    
    }
    
    /**
     * Metodo necessario per rendere il software portabile tra i vari sistemi operativi
     * differenti. Windows è case insensitive nella gestione dei formati dei file,
     * mentre linux no, se inserisce una squadra su windows e il suo logo viene salvato
     * come .png quando in realtà è .PNG allora, quando linux andrà ad aprire il 
     * calendario con quel path salvato avrà problemi a leggere il file, perchè per linux
     * .png e .PNG sono due formati differenti
     */
   public void ricalcolaPathLoghi(){
       for(int i=0; i<squadre.size(); i++){
           this.getSquadre().get(i).ricalcolaLogo();
       
       
       }
   
   }

    public ArrayList<Squadra> getSquadre() {
        return squadre;
    }

    public void setSquadre(ArrayList<Squadra> squadre) {
        this.squadre = squadre;
    }

    public ArrayList<Pair> getCoppie() {
        return coppie;
    }

    public void setCoppie(ArrayList<Pair> coppie) {
        this.coppie = coppie;
    }

    public ArrayList<Partita> getGironeAndata() {
        return gironeAndata;
    }
    
    public ArrayList<Partita> getGironeRitorno() {
        return gironeRitorno;
    }
    

    public void setGironeAndata(ArrayList<Partita> partite) {
        this.gironeAndata = partite;
    }
    
     public void setGironeRitorno(ArrayList<Partita> partite) {
        this.gironeRitorno = partite;
    }
    
    
    
    
    
    
}
