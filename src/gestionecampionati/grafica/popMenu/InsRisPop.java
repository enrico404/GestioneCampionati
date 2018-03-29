/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionecampionati.grafica.popMenu;

import gestionecampionati.Campionato;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Enrico
 */
public class InsRisPop extends JPanel {
    private Campionato c;
    private JTable tabella;
    private InsRisPopUp panelUp;
    private InsRisPopDown panelDown;
    private int tipo; 
    private AbstractTableModel tab;
    private JFrame f;
    

    public InsRisPop( JFrame f,int tipo, Campionato c, JTable tabella, AbstractTableModel tab) {
        super();
        
        this.c = c;
        this.tabella = tabella;
        this.tipo = tipo;
        this.tab = tab;
       
        this.f= f;
        
        
        panelUp = new InsRisPopUp(tipo, c, tabella);
        panelDown = new InsRisPopDown(f,tipo, c, tabella, panelUp,tab);
       
       
       
        
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        
        this.add(Box.createRigidArea(new Dimension(0, 20)));
        this.add(panelUp);
        this.add(Box.createRigidArea(new Dimension(0, 40)));
        this.add(panelDown);
    }
     
    
    
       @Override
        public void paint(Graphics g){
        super.paint(g);

        }
    
}
