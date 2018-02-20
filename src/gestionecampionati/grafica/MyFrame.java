/*
* Frame principale per la gestione dell'intero software
 */
package gestionecampionati.grafica;
import javax.swing.*;
/**
 *
 * @author enrico
 */
public class MyFrame extends JFrame{
    private static final int Width = 1280;
    private static final int Heigth =720;

    public int getWidth() {
        return Width;
    }

    public int getHeigth() {
        return Heigth;
    }
    private String title;
    
    public MyFrame(String title){
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
