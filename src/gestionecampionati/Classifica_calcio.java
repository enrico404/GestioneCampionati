/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionecampionati;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author enrico
 */
public class Classifica_calcio extends Classifica{

    public Classifica_calcio(Campionato c) {
        super(c);
    }

    @Override
    public void calcola() {
        int pa, pb;
        
        
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
            public int compare(Squadra o1, Squadra o2) {
                return o2.getPunteggio() - o1.getPunteggio();
                
            }
        });
         
         
         
         
    }
    
}
