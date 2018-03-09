/*
* Frame principale per la gestione dell'intero software
 */
package gestionecampionati.grafica;
import java.awt.Dimension;
import javax.swing.*;
/**
 *
 * @author enrico
 */
public class MainFrame extends JFrame{
    private static final int Wd = 1300;
    private static final int Hg =720;

    public int getWd() {
        return Wd;
    }

    public int getHg() {
        return Hg;
    }
    private String title;
    
    public MainFrame(String title){
        this.setTitle(title);
        this.setSize(Wd, Hg);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(this);
        this.setMinimumSize(new Dimension(800,600));
    }
    
    public void clean(){
                                    getContentPane().removeAll();
                                  
                                    repaint();
    
    
    }
    
    
    
    
}
