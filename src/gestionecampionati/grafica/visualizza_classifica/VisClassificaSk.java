/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionecampionati.grafica.visualizza_classifica;

import gestionecampionati.Campionato;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.text.View;

/**
 *
 * @author Enrico
 */
public class VisClassificaSk extends JPanel {

    private Campionato c;
    private VisClassificaUp panelUp;
    private VisClassificaCenterL panelCent;
    private VisClassificaDown panelDown;
    
    public VisClassificaSk(Campionato c) {
        this.c = c;
        
        this.setLayout(new BoxLayout(this, View.Y_AXIS));
        JLabel cls = new JLabel("Classifica");
        Font font = new Font("sans-serif", Font.BOLD, 32);
        cls.setFont(font);
        cls.setAlignmentX(CENTER_ALIGNMENT);
        
        panelUp = new VisClassificaUp();
        panelCent = new VisClassificaCenterL(c);
        panelDown = new VisClassificaDown();
        
        this.add(Box.createRigidArea(new Dimension(0, 40)));
        this.add(cls);
        this.add(Box.createRigidArea(new Dimension(0, 40)));
        this.add(panelUp);
        this.add(Box.createRigidArea(new Dimension(0, 20)));
        this.add(panelCent);
        this.add(Box.createRigidArea(new Dimension(0, 20)));
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

    public VisClassificaCenterL getPanelCent() {
        return panelCent;
    }

    public void setPanelCent(VisClassificaCenterL panelCent) {
        this.panelCent = panelCent;
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
