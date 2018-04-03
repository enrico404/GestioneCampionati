
package gestionecampionati;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.Serializable;
import javax.imageio.ImageIO;


/**
 * Classe squadra, una squadra è formata da nome, città e un logo.
 * Alla squadra alla fine del campionato verrà assegnato un determinato punteggio in 
 * base alle partite vinte e un punteggio parziale se lo sport lo prevede.
 * Gli attributi punteggio e punteggioParziale sono utili in fase di creazione della classifica.
 * @author enrico
 */
public class Squadra implements Serializable{
    /** Nome della squadra */
    private String nome;
    /** Città della squadra  */
    private String citta;
    /** percorso del logo */
    private String logo; 
    /** punteggio totale assegnato alla squadra, serve per calcolare la classifica */
    private int punteggio;
    /** punteggio parziale assegnato alla squadra, nel caso di pallavolo indica il numero di set vinti,
     * nel caso del rugby potrebbe indicare le mete totali conquistate */
    private int punteggioParziale;
    
    /**
     * Costruttore di default della squadra
     */
    public Squadra(){
        this.nome = "";
        this.citta  = "";
        
        this.punteggio = 0;
        this.punteggioParziale = 0;

    
    }
    
    /**
     * Costruttore con parametri della squadra 
     * @param  nome nome della squadra
     * @param citta citta della squadra
     */
    public Squadra(String nome, String citta){
        this.nome = nome;
        this.citta = citta;
        this.punteggioParziale = 0;
        /** vado a cercare l'immagine in vari formati */
                   
                        try{
                            BufferedImage image =  ImageIO.read(new File("../GestioneCampionati/media/loghi/"+this.nome+".jpg"));
                             this.logo = "../GestioneCampionati/media/loghi/"+this.nome; 
 
                        }catch(Exception ex3){
                                       this.logo = "../GestioneCampionati/media/loghi/default.jpg";
                        }
                         

                                 

                            

                    this.punteggio = 0;
    }
    
    /**
     * Secondo costruttore con parametri della squadra
     * @param nome nome  della squadra
     * @param citta citta della squadra
     * @param path  percorso del logo della squadra
     */
    
    public Squadra(String nome, String citta, String path){
        this.nome = nome;
        this.citta = citta;
        
        this.logo = path;
        
        this.punteggio = 0;
   
        
        

    
    }
    
    
    /** metodo per incrementare il punteggio della squadra di x punti
     * @param x punti da incrementare */
    public void inc(int x){
        this.punteggio += x;
    
    
    }
    public void reset_p(){
        this.punteggio=0;
    
    }
    
    /** metodo per incrementare il punteggio parziale della squadra di x punti
     * @param x punti da incrementare
     *
     */
    public void incParz(int x){
    
        this.punteggioParziale += x;
    
    }
    
     public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCitta() {
        return citta;
    }

    public void setCitta(String citta) {
        this.citta = citta;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public int getPunteggio() {
        return punteggio;
    }

    public void setPunteggio(int punteggio) {
        this.punteggio = punteggio;
    }

    public int getPunteggioParziale() {
        return punteggioParziale;
    }

    public void setPunteggioParziale(int punteggioParziale) {
        this.punteggioParziale = punteggioParziale;
    }


    
    
    

   

 

  
    
}
