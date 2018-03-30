/*
* Frame principale per la gestione dell'intero software
 */
package gestionecampionati.grafica;
import gestionecampionati.grafica.menuBar.MenuBar;
import java.awt.Dimension;
import javax.swing.*;
/**
 *
 * @author enrico
 */
public class MainFrame extends JFrame{
    private static final int Wd = 1300;
    private static final int Hg =740;
    
    /** riferimento alla menu bar */
    private MenuBar menuB;
  

    private String title;
    
    public MainFrame(String title){
        this.setTitle(title);
        this.setSize(Wd, Hg);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(this);
        this.setMinimumSize(new Dimension(1200,730));
    }
    
    public void clean(){
                    getContentPane().removeAll();
                    repaint();
   
    }

    public MenuBar getMenuB() {
        return menuB;
    }

    public void setMenuB(MenuBar menuB) {
        this.menuB = menuB;
    }

    
    public int getWd() {
        return Wd;
    }

    public int getHg() {
        return Hg;
    }



}
