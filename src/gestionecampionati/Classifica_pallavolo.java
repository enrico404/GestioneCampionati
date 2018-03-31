/*
 * 
 */
package gestionecampionati;

import gestionecampionati.grafica.Errors_Confirm.ErrorPanel;
import java.util.Collections;
import java.util.Comparator;

/**
 * Classe utile per il calcolo della classifica nello sport della pallavolo. E' discendente 
 * della classe astratta classifica. 
 * @author enrico
 */
public class Classifica_pallavolo extends Classifica{
    private ErrorPanel err;

    public Classifica_pallavolo(Campionato c) {
        super(c);
          
    }

    /** nella pallavolo i punteggi vengono assegnati nel seguente modo: vittoria 3-2  2 punti alla squadra vincente e 1 alla perdente
     * * vittoria 3-1,3-0  3 punti alla squadra vincente e 0 alla perdente
     */
    @Override
    public void calcola() {
        
        int pa, pb;
       /** resetta punteggio di tutte le squadre */
        for(int i=0; i< getCampionato().get_numSquadre(); i++) getCampionato().getSquadre().get(i).reset_p();
       
        /** assegnamento dei punt i nel girone di andata */
         for(int i=0; i< getCampionato().getC().getGironeAndata().size(); i++){
             pa = getCampionato().getC().getGironeAndata().get(i).getP().getPa();
             pb =  getCampionato().getC().getGironeAndata().get(i).getP().getPb();
             
             if(pa > pb){
                  
                if(pa == 3 && pb == 2){
                           getCampionato().getC().getGironeAndata().get(i).getCoppia().getA().inc(2);
                           getCampionato().getC().getGironeAndata().get(i).getCoppia().getB().inc(1);
                       }
                else getCampionato().getC().getGironeAndata().get(i).getCoppia().getA().inc(3);
             } else {
                 if(pa==pb){err = new ErrorPanel(8); return;}
                 if(pb == 3 && pa == 2){
                     getCampionato().getC().getGironeAndata().get(i).getCoppia().getA().inc(1);
                     getCampionato().getC().getGironeAndata().get(i).getCoppia().getB().inc(2);
                 }else getCampionato().getC().getGironeAndata().get(i).getCoppia().getB().inc(3);
             }
         }
         
             /** assegnamento dei punt i nel girone di ritorno */
         for(int i=0; i< getCampionato().getC().getGironeRitorno().size(); i++){
             pa = getCampionato().getC().getGironeRitorno().get(i).getP().getPa();
             pb =  getCampionato().getC().getGironeRitorno().get(i).getP().getPb();
             
             if(pa > pb){
                  
                if(pa == 3 && pb == 2){
                           getCampionato().getC().getGironeRitorno().get(i).getCoppia().getA().inc(2);
                           getCampionato().getC().getGironeRitorno().get(i).getCoppia().getB().inc(1);
                       }
                else getCampionato().getC().getGironeRitorno().get(i).getCoppia().getA().inc(3);
             } else {
                 if(pb == 3 && pa == 2){
                     getCampionato().getC().getGironeRitorno().get(i).getCoppia().getA().inc(1);
                     getCampionato().getC().getGironeRitorno().get(i).getCoppia().getB().inc(2);
                 }else getCampionato().getC().getGironeRitorno().get(i).getCoppia().getB().inc(3);
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
