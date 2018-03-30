/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionecampionati.grafica.inserimento_risultati.InsRis;

import gestionecampionati.Campionato;
import gestionecampionati.grafica.MainFrame;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

/**
 *
 * @author Enrico
 */
public class InsRisPanel extends JPanel {
    private JPanel menu;
    private Campionato c;
    private MainFrame f;
    private InsRisPanelUP panelUp;
    private InsRisPanelCenter panelCenter;
    private InsRisPanelDown panelDown;
 
    

    public InsRisPanel(JPanel menu, Campionato c, MainFrame f) {
        super();
        this.menu = menu;
        this.c = c;
        this.f = f;
        
       
        panelUp = new InsRisPanelUP(c);
        panelCenter = new InsRisPanelCenter();
        panelDown = new InsRisPanelDown(c, this, menu, f);
       
       
       
        
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        
        this.add(Box.createRigidArea(new Dimension(0, 100)));
        this.add(panelUp);
        this.add(Box.createRigidArea(new Dimension(0, 40)));
        this.add(panelCenter);
        this.add(Box.createRigidArea(new Dimension(0, 60)));
        this.add(panelDown);
    }

    public InsRisPanelUP getPanelUp() {
        return panelUp;
    }

    public void setPanelUp(InsRisPanelUP panelUp) {
        this.panelUp = panelUp;
    }

    public InsRisPanelCenter getPanelCenter() {
        return panelCenter;
    }

    public void setPanelCenter(InsRisPanelCenter panelCenter) {
        this.panelCenter = panelCenter;
    }

    public InsRisPanelDown getPanelDown() {
        return panelDown;
    }

    public void setPanelDown(InsRisPanelDown panelDown) {
        this.panelDown = panelDown;
    }
    
    
    
    
    
    @Override
        public void paint(Graphics g){
        super.paint(g);

        }
}
