
package gestionecampionati.grafica.gestione_calendario;

import gestionecampionati.Campionato;
import gestionecampionati.grafica.MainFrame;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.text.View;

/**
 * Pannello scheletro della schermata gestione calendario.
 * @author enrico
 */
public class GestCSk extends JPanel {
    
    private SkPanelUp panelUp;
    private SkPanelCenter panelCenter;
    private SkPanelDown  panelDown; 
    private JPanel menuP;
    private MainFrame f;
    private Campionato c;
  
/**
 * Pannello scheletro per la gestione del calendario, da cui è possibile recuperare 
 * tutti i pannelli che si occupano delle funzionalità della gestione del calendario
 * @param f frame in cui inserire il pannello
 * @param c struttura dati da cui recuperare i dati necessari
 * @param menuP  pannello menu, per tornare indietro alla selezione delle funzioni
 */
    public GestCSk(MainFrame f, Campionato c, JPanel menuP) {
        super();
        
        this.menuP = menuP;
        
        this.setLayout(new BoxLayout(this, View.Y_AXIS));
        this.setAlignmentX(LEFT_ALIGNMENT);
        
        
        this.c = c;
        this.f = f;
        

        panelUp = new SkPanelUp(menuP, this, f, c);
        panelCenter = new SkPanelCenter(c,f,this );
        panelDown = new SkPanelDown(c, this, f);

        
        this.add(Box.createRigidArea(new Dimension(0, 10)));
        this.add(panelUp);
        this.add(Box.createRigidArea(new Dimension(0, 20)));
        this.add(panelCenter);
        this.add(Box.createRigidArea(new Dimension(0, 20)));
        this.add(panelDown);
        
        
        
        
    }

    public SkPanelUp getPanelUp() {
        return panelUp;
    }

    public void setPanelUp(SkPanelUp panelUp) {
        this.panelUp = panelUp;
    }

    public SkPanelCenter getPanelCenter() {
        return panelCenter;
    }

    public void setPanelCenter(SkPanelCenter panelCenter) {
        this.panelCenter = panelCenter;
    }

    public SkPanelDown getPanelDown() {
        return panelDown;
    }

    public void setPanelDown(SkPanelDown panelDown) {
        this.panelDown = panelDown;
    }

 
    
    
       @Override
        public void paint(Graphics g){
        super.paint(g);
    
       

        }
    
}
