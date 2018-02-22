/*
* Frame principale per la gestione dell'intero software
 */
package gestionecampionati.grafica;
import javax.swing.*;
/**
 *
 * @author enrico
 */
public class MainFrame extends JFrame{
    private static final int Width = 1000;
    private static final int Heigth =700;

    public int getWidth() {
        return Width;
    }

    public int getHeigth() {
        return Heigth;
    }
    private String title;
    
    public MainFrame(String title){
        this.setTitle(title);
        this.setSize(Width, Heigth);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(this);
      
    }
    
    public void clean(){
                                    getContentPane().removeAll();
                                  
                                    repaint();
    
    
    }
    
    
    
    
}
