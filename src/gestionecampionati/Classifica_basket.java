/*
 
 */
package gestionecampionati;

import gestionecampionati.grafica.Errors_Confirm.ErrorPanel;
import java.util.Collections;
import java.util.Comparator;

/**
 * Classe utile per il calcolo della classifica nello sport del basket. E' discendente 
 * della classe astratta classifica.
 * @author enrico
 */
public class Classifica_basket extends Classifica {

    private ErrorPanel err;
    public Classifica_basket(Campionato c) {
        super(c);
        
    }

    /** nel basket i punteggi vengono calcolati nel seguente modo: 2 punti alla squadra vincente e 0 alla perdente
     * il pareggio nel basket non esiste
     */
    @Override
    public void calcola() {
          int pa, pb;
        
        /** resetta punteggio di tutte le squadre */
        for(int i=0; i< getCampionato().get_numSquadre(); i++) getCampionato().getSquadre().get(i).reset_p();
        
        /** assegnamento dei punt i nel girone di andata */
        for(int i=0; i< getCampionato().getC().getGironeAndata().size(); i++){
            
            if(getCampionato().getC().getGironeAndata().get(i).isGiocata()){
                    pa = getCampionato().getC().getGironeAndata().get(i).getP().getPa();
                    pb =  getCampionato().getC().getGironeAndata().get(i).getP().getPb();
                    if( pa > pb){
                        getCampionato().getC().getGironeAndata().get(i).getCoppia().getA().inc(2);
                    }
                    else if(pa == pb){ 
                        err = new ErrorPanel(8); return;
                    }else{
                         getCampionato().getC().getGironeAndata().get(i).getCoppia().getB().inc(2);
                    }
            }
            
        }
        
         /** assegnamento dei punti nel girone di ritorno */
        for(int i=0; i< getCampionato().getC().getGironeRitorno().size(); i++){
            
            if(getCampionato().getC().getGironeRitorno().get(i).isGiocata()){
                    pa = getCampionato().getC().getGironeRitorno().get(i).getP().getPa();
                    pb =  getCampionato().getC().getGironeRitorno().get(i).getP().getPb();
                    if( pa > pb){
                        getCampionato().getC().getGironeRitorno().get(i).getCoppia().getA().inc(2);
                    }
                    else if(pa == pb){ 
                        err = new ErrorPanel(8);
                    }else{
                         getCampionato().getC().getGironeRitorno().get(i).getCoppia().getB().inc(2);
                    }
            }
            
        }
        for(int i=0; i<this.getCampionato().get_numSquadre(); i++){
               this.getClassifica().add(this.getCampionato().getSquadre().get(i));
               /** serve per introdurre randomicità nel caso due squadre abbiano lo stesso punteggio */
               Collections.shuffle(this.getClassifica());
           
           }
          
         this.getClassifica().sort(new Comparator<Squadra>(){
            @Override
            
            /** ordinamento della classifica con algoritmo bubble sort, implementato di default nella libreria swing */
            public int compare(Squadra o1, Squadra o2) {
                return o2.getPunteggio() - o1.getPunteggio();
                
            }
        });
        
        
        
    }
    
}
