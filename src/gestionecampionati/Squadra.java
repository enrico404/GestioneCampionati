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
    
   
    
    public Squadra(){
        this.nome = "";
        this.citta  = "";

    
    }
    
    public Squadra(String nome, String citta){
        this.nome = nome;
        this.citta = citta;
        
                    try{
                        BufferedImage image =  ImageIO.read(new File("../GestioneCampionati/media/loghi/"+this.nome));
                        this.logo = "../GestioneCampionati/media/loghi/"+this.nome;                      
                    }catch(Exception ex){
                       this.logo = "../GestioneCampionati/media/loghi/default.jpg";
                        
                    }
        

    
    }
    
    public Squadra(String nome, String citta, String path){
        this.nome = nome;
        this.citta = citta;
        
        this.logo = path;
        
        
        
        

    
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

 

  
    
}
