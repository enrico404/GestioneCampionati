/*
 * 
 */
package gestionecampionati;

import java.util.Collections;
import java.util.Comparator;

/**
 * Classe utile per il calcolo della classifica nello sport del calcio. E' discendente 
 * della classe astratta classifica. 
 * @author enrico
 */
public class Classifica_calcio extends Classifica{

    public Classifica_calcio(Campionato c) {
        super(c);
    }

    /** nel calcio i punteggi vengono assegnati nel modo seguente: 3 punti vittoria, 1 punto pareggio, 0 punti sconfitta */
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
                        getCampionato().getC().getGironeAndata().get(i).getCoppia().getA().inc(3);
                    }
                    else if(pa == pb){
                         getCampionato().getC().getGironeAndata().get(i).getCoppia().getA().inc(1);
                         getCampionato().getC().getGironeAndata().get(i).getCoppia().getB().inc(1);
                    }
                    else if(pa < pb){
                         getCampionato().getC().getGironeAndata().get(i).getCoppia().getB().inc(3);
                    }
            }
            
        }
        
        /** assegnamento dei punt i nel girone di ritorno */
        for(int i=0; i< getCampionato().getC().getGironeRitorno().size(); i++){
            
            if(getCampionato().getC().getGironeRitorno().get(i).isGiocata()){
                    pa = getCampionato().getC().getGironeRitorno().get(i).getP().getPa();
                    pb =  getCampionato().getC().getGironeRitorno().get(i).getP().getPb();
                    if( pa > pb){
                        getCampionato().getC().getGironeRitorno().get(i).getCoppia().getA().inc(3);
                    }
                    else if(pa == pb){
                         getCampionato().getC().getGironeRitorno().get(i).getCoppia().getA().inc(1);
                         getCampionato().getC().getGironeRitorno().get(i).getCoppia().getB().inc(1);
                    }
                    else if(pa < pb){
                         getCampionato().getC().getGironeRitorno().get(i).getCoppia().getB().inc(3);
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
