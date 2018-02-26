/**
 * Il calendario è un insieme di partite
 */
package gestionecampionati;

import java.util.ArrayList;

import java.io.*;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;



/**
 * 
 * @author enrico
 */
public class Calendario implements Serializable {

    /** Array delle squadre partecipanti al campionato, utile per salvare i dati delle squadre */
    private ArrayList<Squadra> squadre = new ArrayList<Squadra>();
    private ArrayList<Pair> coppie = new ArrayList<Pair>();
    
    /** Array delle partite,  */
    private ArrayList<Partita> gironeAndata = new ArrayList<Partita>();
    private ArrayList<Partita> gironeRitorno = new ArrayList<Partita>();

  
    
   
    
    
    
    public Calendario(ArrayList<Squadra> squadre){
      
        this.squadre = squadre;
        
        
        
    
    
    }
    
    
    
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
    
    
    public boolean genera_coppie(){
        for(int i =0 ; i< squadre.size(); i++){
            for(int j=i; j<squadre.size(); j++){
                if(i != j){
                   
                    
                    coppie.add(new Pair(squadre.get(i), squadre.get(j)));
                
                }
            }
       
        }
    
        return true;
    }
    
    
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
    
    
   
    public void stampa_coppie(){
        for(int i=0; i<coppie.size(); i++){
            System.out.println(coppie.get(i).getA().getNome()+" "+coppie.get(i).getB().getNome());        
        
        }
    
    
    
    }
    
  
    
    /** Funzione per l'inserimento del risultato di una partita giocata */
    public boolean inserisci_ris(Partita par, Punteggio p){
        for(int i=0; i< gironeAndata.size(); i++){
            
            //trovo la partita e se esiste e non è ancora stata giocata vado a chiamare il metodo inserisci punteggio
            // che setta la partita giocata e inserisce il risultato
            if(gironeAndata.get(i).equals(par) && !gironeAndata.get(i).isGiocata() ){
                gironeAndata.get(i).inserisci_punt(p);
                return true;
            
            }
        
        
        }
        

        return false;
    
    }
    
 
    
    /** Funzione per la modifica del risultato di una partita giocata */
    
    public boolean modifica_ris(Partita par, Punteggio p){
         for(int i=0; i< gironeAndata.size(); i++){
             // modifico la partita solo se esiste la partita ed è stata già giocata
            if(gironeAndata.get(i).equals(par) && gironeAndata.get(i).isGiocata()){
                gironeAndata.get(i).inserisci_punt(p);
                return true;
            
            }
        
        
        }
        
        
        return false;
    
    }
    
    //metodo deprecato
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

    public ArrayList<Partita> getPartite() {
        return gironeAndata;
    }

    public void setPartite(ArrayList<Partita> partite) {
        this.gironeAndata = partite;
    }
    
    
    
    
    
    
    
    
}
