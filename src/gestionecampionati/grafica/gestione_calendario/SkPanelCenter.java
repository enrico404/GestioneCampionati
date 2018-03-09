/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionecampionati.grafica.gestione_calendario;

import gestionecampionati.Campionato;
import gestionecampionati.grafica.MainFrame;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.text.View;

/**
 *
 * @author enrico
 */
public class SkPanelCenter extends JPanel {
   
    private Campionato c;
    private MainFrame f;
    private SkPanelCenterSqA panelA;
    private SkPanelCenterSqB panelB;
    private Font font;
    private GestCSk p;
    
    
    public SkPanelCenter(Campionato c, MainFrame f, GestCSk p) {
        super();
        this.p = p;
        font =  new Font("sans-serif", Font.PLAIN, 14);
        this.c = c;
        this.f = f;
        panelA = new SkPanelCenterSqA(c,font);
        panelB = new SkPanelCenterSqB(c,font, f, p);
        
        panelA.riempi();
        panelB.riempi();
        
        panelB.getSqb().setSelectedIndex(1);
        
        this.setLayout(new BoxLayout(this, View.X_AXIS));
        
        this.add(panelA, font);
       
        this.add(panelB, font);
       
        
        
        
        
        
        
        
    }
    
       public SkPanelCenterSqA getPanelA() {
        return panelA;
    }

    public void setPanelA(SkPanelCenterSqA panelA) {
        this.panelA = panelA;
    }

    public SkPanelCenterSqB getPanelB() {
        return panelB;
    }

    public void setPanelB(SkPanelCenterSqB panelB) {
        this.panelB = panelB;
    }
       @Override
        public void paint(Graphics g){
        super.paint(g);
       
       

        }
}
