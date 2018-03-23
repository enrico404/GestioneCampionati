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
    private JLabel[] p;
    
    
    public VisClassificaCenterP(Campionato c) {
        this.c = c;
        
        Font font = new Font("sans-serif", Font.PLAIN, 18);
        p = new JLabel[c.get_numSquadre()];
        int i=0;
        
        this.setLayout(new BoxLayout(this, View.X_AXIS));
        this.add(Box.createRigidArea(new Dimension(170, 0)));
        while(i<c.get_numSquadre() && i<3){
            p[i] = new JLabel(c.getCls().getClassifica().get(i).getNome()+": "+c.getCls().getClassifica().get(i).getPunteggio());
            p[i].setFont(font);
            this.add(p[i]);
            this.add(Box.createRigidArea(new Dimension(200, 0)));
            i++;
        
        }
        
        
    }
    
    
    
    @Override
        public void paint(Graphics g){
        super.paint(g);

        }
    
}
