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
import javafx.scene.layout.Border;
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
 
    private SkPanelCenterSqA panelA;
    private SkPanelCenterSqB panelB;
    private Font font;
    
    
    SkPanelCenter(Campionato c) {
        super();
        
        font =  new Font("sans-serif", Font.PLAIN, 14);
        this.c = c;
        
        panelA = new SkPanelCenterSqA(c,font);
        panelB = new SkPanelCenterSqB(c,font);
        
        
        
        
        this.setLayout(new BoxLayout(this, View.X_AXIS));
        
        this.add(panelA, font);
       
        this.add(panelB, font);
       
        
        
        
        
        
        
        
    }
    
       @Override
        public void paint(Graphics g){
        super.paint(g);
        repaint();
       

        }
}
