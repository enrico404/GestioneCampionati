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
 * @author enrico
 */
public class VisClassificaCenterP extends JPanel{

    private Campionato c;
    private JLabel p1,p2,p3;
    
    public VisClassificaCenterP(Campionato c) {
        this.c = c;
        
        Font font = new Font("sans-serif", Font.PLAIN, 18);
        
        p1 = new JLabel(c.getCls().getClassifica().get(0).getNome()+": "+c.getCls().getClassifica().get(0).getPunteggio());
        p2 = new JLabel(c.getCls().getClassifica().get(1).getNome()+": "+c.getCls().getClassifica().get(1).getPunteggio());
        p3 = new JLabel(c.getCls().getClassifica().get(2).getNome()+": "+c.getCls().getClassifica().get(2).getPunteggio());
        
        p1.setFont(font);
        p2.setFont(font);
        p3.setFont(font);
        
        
        
        this.setLayout(new BoxLayout(this, View.X_AXIS));
        
        this.add(p1);
        this.add(Box.createRigidArea(new Dimension(200, 0)));
        this.add(p2);
        this.add(Box.createRigidArea(new Dimension(200, 0)));
        this.add(p3);
        
        
        
        
    }
    
    
    
    @Override
        public void paint(Graphics g){
        super.paint(g);

        }
    
}
