
package gestionecampionati;

import java.io.Serializable;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *  Classe data, gestisce le date delle varie giornate.
  * @deprecated  ***CLASSE DEPRECATA**** 
 * 
 * @author enrico
 */
public class Data implements Serializable{
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
    
    public Data(){
        this.giorno = 0;
        this.mese = 0;
        this.anno = 0;
    
    
    }
    
    public Data(int giorno, int mese, int anno){
   
            this.giorno = giorno;
            this.mese = mese;
            this.anno = anno;
        
        
        
        
    
    }
    
    
    public boolean is_valid(){
        
        
        try{
            Calendar tmp = new GregorianCalendar();
            tmp.setLenient(false); //se è true accetta qualsiasi giorno, ad es. 391 feb e il 391esimo giorno dopo il primo febbraio
            tmp.set(Calendar.YEAR, anno);
            tmp.set(Calendar.MONTH, mese-1); //gennaio parte da 0 e non da 1
            tmp.set(Calendar.DAY_OF_MONTH, giorno);
           
            
            tmp.getTime(); //check if date is correct
               return true;
        }catch(Exception e ){
       
            return false;
        
        
        }
      
     
    
    
    }
}

