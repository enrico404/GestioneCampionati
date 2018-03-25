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
    private static final int Hg =740;
    /** panello centrale */
    private JScrollPane sc;

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
        this.setMinimumSize(new Dimension(1200,730));
    }
    
    public void clean(){
                    getContentPane().removeAll();
                    repaint();
   
    }



}
