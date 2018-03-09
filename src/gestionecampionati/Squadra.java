/*
 * Devo evitare di serializzare i loghi
 */
package gestionecampionati;

import java.io.Serializable;


/**
 *
 * @author enrico
 */
public class Squadra implements Serializable{
    
    private String nome;
    private String citta;
   
    
    public Squadra(){
        this.nome = "";
        this.citta  = "";

    
    }
    
    public Squadra(String nome, String citta){
        this.nome = nome;
        this.citta = citta;
        

    
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

 

  
    
}
