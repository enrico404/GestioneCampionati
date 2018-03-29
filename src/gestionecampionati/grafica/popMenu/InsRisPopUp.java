/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionecampionati.grafica.popMenu;

import gestionecampionati.Campionato;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.text.View;

/**
 *
 * @author Enrico
 */
public class InsRisPopUp extends JPanel{
    
    private Campionato c;
    private JTable tabella;
    private JLabel sq1,sq2;
    private int tipo;
    private JComboBox p1,p2;
    
    
    public InsRisPopUp(int tipo,Campionato c, JTable tabella) {
        this.c = c;
        this.tabella = tabella;
        this.tipo=tipo;
        
        /** girono andata */
        if(tipo == 1){
            sq1 = new JLabel(c.getC().getGironeAndata().get(tabella.getSelectedRow()).getCoppia().getA().getNome());
            sq2 = new JLabel(c.getC().getGironeAndata().get(tabella.getSelectedRow()).getCoppia().getB().getNome());
        }
        else {    /** girone ritorno */
            sq1 = new JLabel(c.getC().getGironeRitorno().get(tabella.getSelectedRow()).getCoppia().getA().getNome());
            sq2 = new JLabel(c.getC().getGironeRitorno().get(tabella.getSelectedRow()).getCoppia().getB().getNome());
        
        }
        
        
        
        p1 = new JComboBox();
        p2 = new JComboBox();
        
        p1.setBackground(Color.white);
        p2.setBackground(Color.white);
        
        p1.setMaximumSize(new Dimension(50,20));
        p1.setMinimumSize(new Dimension(50,20));
        
        
        p2.setMaximumSize(new Dimension(50,20));
        p2.setMinimumSize(new Dimension(50,20));
        
        riempi(30);
        
        
        
        this.setLayout(new BoxLayout(this, View.X_AXIS));
        
        this.add(sq1);
        this.add(Box.createRigidArea(new Dimension(10, 0)));
        this.add(p1);
        this.add(Box.createRigidArea(new Dimension(30, 0)));
        this.add(sq2);
        this.add(Box.createRigidArea(new Dimension(10, 0)));
        this.add(p2);
        
    }

   
    
    
    
    
    public void riempi(int n){
            for(int i=0; i<n;  i++) {
                p1.addItem(i);
                p2.addItem(i);
            
            }
    
    
    }

    public JComboBox getP1() {
        return p1;
    }

    public void setP1(JComboBox p1) {
        this.p1 = p1;
    }

    public JComboBox getP2() {
        return p2;
    }

    public void setP2(JComboBox p2) {
        this.p2 = p2;
    }
    
    
    
    @Override
        public void paint(Graphics g){
        super.paint(g);

        }
    
}
