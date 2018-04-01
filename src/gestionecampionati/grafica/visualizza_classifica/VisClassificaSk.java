
package gestionecampionati.grafica.visualizza_classifica;

import gestionecampionati.Campionato;
import gestionecampionati.grafica.MainFrame;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.text.View;

/**
 * Pannello scheletro della classifica
 * @author Enrico
 */
public class VisClassificaSk extends JPanel {

    private Campionato c;
    private VisClassificaUp panelUp;
    private VisClassificaCenterL panelCentL;
    private VisClassificaDown panelDown;
    private VisClassificaCenterP panelCentP;
    private JPanel menu;
    private MainFrame f;
    
    /**
     * Costruttore del pannello scheletro, il pannello menu serve per tornare indietro
     * @param c struttura dati principale da passare agli altri pannelli 
     * @param menu pannello menu per tornare indietro
     * @param f  frame in cui inserire i pannelli
     */
    public VisClassificaSk(Campionato c, JPanel menu, MainFrame f) {
        this.c = c;
        this.menu = menu;
        this.f = f;
        
      
        
        this.setLayout(new BoxLayout(this, View.Y_AXIS));
        JLabel cls = new JLabel("Classifica");
        Font font = new Font("sans-serif", Font.BOLD, 32);
        cls.setFont(font);
        cls.setAlignmentX(CENTER_ALIGNMENT);
        
      
        
        
        panelUp = new VisClassificaUp(c);
        panelCentL = new VisClassificaCenterL(c);
        panelCentP = new VisClassificaCenterP(c);
        panelDown = new VisClassificaDown(c, menu, f, this);
   
        
        this.add(Box.createRigidArea(new Dimension(0, 10)));
        this.add(cls);
        this.add(Box.createRigidArea(new Dimension(0, 30)));
        this.add(panelUp);
        this.add(Box.createRigidArea(new Dimension(0, 20)));
        this.add(panelCentL);
        this.add(Box.createRigidArea(new Dimension(0, 20)));
        this.add(panelCentP);
        this.add(Box.createRigidArea(new Dimension(0, 30)));
        this.add(panelDown);
        
        
        
        
        
        

    }

    public Campionato getC() {
        return c;
    }

    public void setC(Campionato c) {
        this.c = c;
    }

    public VisClassificaUp getPanelUp() {
        return panelUp;
    }

    public void setPanelUp(VisClassificaUp panelUp) {
        this.panelUp = panelUp;
    }

    public VisClassificaCenterL getPanelCentL() {
        return panelCentL;
    }

    public void setPanelCentL(VisClassificaCenterL panelCentL) {
        this.panelCentL = panelCentL;
    }

    public VisClassificaCenterP getPanelCentP() {
        return panelCentP;
    }

    public void setPanelCentP(VisClassificaCenterP panelCentP) {
        this.panelCentP = panelCentP;
    }

    
    public VisClassificaDown getPanelDown() {
        return panelDown;
    }

    public void setPanelDown(VisClassificaDown panelDown) {
        this.panelDown = panelDown;
    }

 

  
    
    
    
    
     @Override
        public void paint(Graphics g){
        super.paint(g);

        }
    
}
