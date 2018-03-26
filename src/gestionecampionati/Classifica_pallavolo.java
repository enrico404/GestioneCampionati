/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionecampionati;

import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author enrico
 */
public class Classifica_pallavolo extends Classifica{

    public Classifica_pallavolo(Campionato c) {
        super(c);
          
    }

    /** nella pallavolo i punteggi vengono assegnati nel seguente modo: vittoria 3-2 -> 2 punti alla squadra vincente e 1 alla perdente
     * * vittoria 3-1,3-0  3 punti alla squadra vincente e 0 alla perdente
     */
    @Override
    public void calcola() {
        
        int pa, pb;
       /** resetta punteggio di tutte le squadre */
        for(int i=0; i< getCampionato().get_numSquadre(); i++) getCampionato().getSquadre().get(i).reset_p();
       
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
                 if(pb == 3 && pa == 2){
                     getCampionato().getC().getGironeAndata().get(i).getCoppia().getA().inc(1);
                     getCampionato().getC().getGironeAndata().get(i).getCoppia().getB().inc(2);
                 }else getCampionato().getC().getGironeAndata().get(i).getCoppia().getB().inc(3);
             }
         }
         
         
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
            
            /** ordinamento della classifica con algoritmo bubble sort */
            public int compare(Squadra o1, Squadra o2) {
                return o2.getPunteggio() - o1.getPunteggio();
                
            }
        });
    }
    
}
