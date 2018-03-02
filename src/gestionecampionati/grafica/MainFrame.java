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
    private static final int Width = 1200;
    private static final int Heigth =720;

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
        this.setMinimumSize(new Dimension(800,600));
    }
    
    public void clean(){
                                    getContentPane().removeAll();
                                  
                                    repaint();
    
    
    }
    
    
    
    
}
