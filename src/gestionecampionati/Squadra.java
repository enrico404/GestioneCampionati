/*
 * Devo evitare di serializzare i loghi
 */
package gestionecampionati;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.Serializable;
import javax.imageio.ImageIO;


/**
 *
 * @author enrico
 */
public class Squadra implements Serializable{
    
    private String nome;
    private String citta;
    /** percorso del logo */
    private String logo; 
    /** punteggio totale assegnato alla squadra, serve per calcolare la classifica */
    private int punteggio;
    
   
    
    public Squadra(){
        this.nome = "";
        this.citta  = "";
        
        this.punteggio = 0;

    
    }
    
    public Squadra(String nome, String citta){
        this.nome = nome;
        this.citta = citta;
        /** vado a cercare l'immagine in vari formati */
                    try{
                        BufferedImage image =  ImageIO.read(new File("../GestioneCampionati/media/loghi/"+this.nome));
                        this.logo = "../GestioneCampionati/media/loghi/"+this.nome;                      
                    }catch(Exception ex1){
                        try{
                            BufferedImage image =  ImageIO.read(new File("../GestioneCampionati/media/loghi/"+this.nome+".jpg"));
                             this.logo = "../GestioneCampionati/media/loghi/"+this.nome+".jpg"; 
                        
                        }catch(Exception ex2){
                            try{
                                BufferedImage image =  ImageIO.read(new File("../GestioneCampionati/media/loghi/"+this.nome+".png"));
                                this.logo = "../GestioneCampionati/media/loghi/"+this.nome+".png"; 
                        
                             }catch(Exception ex3){
                                 try{
                                    BufferedImage image =  ImageIO.read(new File("../GestioneCampionati/media/loghi/"+this.nome.toLowerCase()+".png"));
                                    this.logo = "../GestioneCampionati/media/loghi/"+this.nome.toLowerCase()+".png"; 
                                    
                                 
                                 }catch(Exception ex4){
                                     try{
                                    
                                         BufferedImage image =  ImageIO.read(new File("../GestioneCampionati/media/loghi/"+this.nome.toLowerCase()+".jpg"));
                                          this.logo = "../GestioneCampionati/media/loghi/"+this.nome.toLowerCase()+".jpg"; 
                                    
                                    }catch(Exception ex5){
                                        try{

                                             BufferedImage image =  ImageIO.read(new File("../GestioneCampionati/media/loghi/"+this.nome.toLowerCase()));
                                              this.logo = "../GestioneCampionati/media/loghi/"+this.nome.toLowerCase(); 

                                        }catch(Exception ex6){ this.logo = "../GestioneCampionati/media/loghi/default.jpg";}
                                    }

                                 }

                            }
                        }
                    }
     

                    this.punteggio = 0;
    }
    
    public Squadra(String nome, String citta, String path){
        this.nome = nome;
        this.citta = citta;
        
        this.logo = path;
        
        this.punteggio = 0;
   
        
        

    
    }
    
    
    /** metodo per incrementare punteggio della squadra di x punti
     * @param x */
    public void inc(int x){
        this.punteggio += x;
    
    
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
    
    
    

   

 

  
    
}
