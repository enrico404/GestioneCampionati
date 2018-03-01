/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionecampionati.grafica.gestione_calendario;

import gestionecampionati.Campionato;
import gestionecampionati.grafica.MainFrame;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.text.View;

/**
 *
 * @author enrico
 */
public class GestCSk extends JPanel {
    
    private SkPanelUp panel1;
    private SkPanelCenter panel2;
    private SkPanelDown  panel3; 
    
    
    private MainFrame f;
    private Campionato c;

    public GestCSk(MainFrame f, Campionato c) {
        super();
       
        this.setLayout(new BoxLayout(this, View.Y_AXIS));
        this.setAlignmentX(LEFT_ALIGNMENT);
        
        
        this.c = c;
        this.f = f;
        
        panel1 = new SkPanelUp();
        panel2 = new SkPanelCenter(c);
        panel3 = new SkPanelDown(c);

        
        this.add(Box.createRigidArea(new Dimension(0, 40)));
        this.add(panel1);
        this.add(Box.createRigidArea(new Dimension(0, 40)));
        this.add(panel2);
        this.add(Box.createRigidArea(new Dimension(0, 40)));
        this.add(panel3);
        
        
    }
    
    
       @Override
        public void paint(Graphics g){
        super.paint(g);
        repaint();
       

        }
    
}
