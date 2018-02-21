/*
 * Devo evitare di serializzare i loghi
 */
package gestionecampionati;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author enrico
 */
public class Squadra implements Serializable{
    
    private String nome;
    private String citta;
    transient private BufferedImage logo; //se non esiste carica logo di default, non va serializzato
    
    public Squadra(){
        this.nome = "";
        this.citta  = "";
      
        try {
            this.logo = ImageIO.read(new File("../GestioneCampionati/media/loghi/default.jpg"));
        } catch (IOException ex) {
            Logger.getLogger(Squadra.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    
    }
    
    public Squadra(String nome, String citta){
        this.nome = nome;
        this.citta = citta;
        
        
        //carico logo squadra, se non esiste carico logo di default
      
        try {
            this.logo = ImageIO.read(new File("../GestioneCampionati/media/loghi/"+ nome + ".jpg"));
        } catch (IOException ex) {
            try {
                
                this.logo = ImageIO.read(new File("../GestioneCampionati/media/loghi/default.jpg"));
            } catch (IOException ex1) {
                Logger.getLogger(Squadra.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
        
    
    
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
    /* se tolgo i commenti non riesco più a caricare le squadre perchè quando ho serializzato i metodi non esistevano
    public BufferedImage getLogo() {
        return logo;
    }

    public void setLogo(BufferedImage logo) {
        this.logo = logo;
    }
    */
    
}
