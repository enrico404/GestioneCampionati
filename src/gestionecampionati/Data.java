/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionecampionati;

/**
 *
 * @author enrico
 */
public class Data {
    private int giorno;
    private int mese;
    private int anno;

    public int getGiorno() {
        return giorno;
    }

    public void setGiorno(int giorno) {
        this.giorno = giorno;
    }

    public int getMese() {
        return mese;
    }

    public void setMese(int mese) {
        this.mese = mese;
    }

    public int getAnno() {
        return anno;
    }

    public void setAnno(int anno) {
        this.anno = anno;
    }
    
    
    public Data(int giorno, int mese, int anno){
        if(is_valid(giorno,mese,anno)){
            this.giorno = giorno;
            this.mese = mese;
            this.anno = anno;
        
        
        
        }
    
    }
    
    
    public boolean is_valid(int giorno, int mese, int anno){
        return true;
    
    
    }
}

