
package gestionecampionati.grafica;
import java.awt.Dimension;
import javax.swing.*;


/**
 * Frame principale per la gestione dell'intero software
 * @author enrico
 */
public class MainFrame extends JFrame{
    /** Larghezza della finestra */
    private static final int Wd = 1300;
    /** Altezza della finestra */
    private static final int Hg =740;
    
   
  
    
    
    /** 
     * Costruttore di default della finestra 
     * @param title titolo della finestra
     */
    public MainFrame(String title){
        this.setTitle(title);
        this.setSize(Wd, Hg);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(this);
        this.setMinimumSize(new Dimension(1200,730));
    }
    
    /** 
     * Metodo per pulire il contenuto dell'intero frame
     */
    public void clean(){
                    getContentPane().removeAll();
                    repaint();
   
    }

 
    public int getWd() {
        return Wd;
    }

    public int getHg() {
        return Hg;
    }



}
