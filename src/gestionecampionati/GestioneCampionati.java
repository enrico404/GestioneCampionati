/*
 * Classe main del sotware
 */
package gestionecampionati;

/**
 *
 * @author enrico
 */
public class GestioneCampionati {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MyFrame f = new MyFrame("Gestione Campionati");
        MyPanel p = new MyPanel(f);
  
        
       
        f.add(p);
       
        f.setVisible(true);
        
        
        
        
        
        
        
        
        
    }
    
}
