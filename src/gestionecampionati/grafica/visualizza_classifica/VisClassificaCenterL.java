/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionecampionati.grafica.visualizza_classifica;

import gestionecampionati.Campionato;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.text.View;

/**
 *
 * @author enrico
 */
public class VisClassificaCenterL extends JPanel {

    private Campionato c;
    private JLabel ico1,ico2,ico3;
    
    
    public VisClassificaCenterL(Campionato c) {
        this.c = c;
        BufferedImage bf1 = null,bf2 = null,bf3 = null;
        
        try {   
            bf1 = ImageIO.read(new File(c.getCls().getClassifica().get(0).getLogo()));
            bf2 = ImageIO.read(new File(c.getCls().getClassifica().get(1).getLogo()));
            bf3 = ImageIO.read(new File(c.getCls().getClassifica().get(2).getLogo()));
            
        } catch (IOException ex) {
            Logger.getLogger(VisClassificaCenterL.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        ico1 = new JLabel(new ImageIcon(bf1));
        ico2 = new JLabel(new ImageIcon(bf2));
        ico3 = new JLabel(new ImageIcon(bf3));
        
        this.setLayout(new BoxLayout(this, View.X_AXIS));
        
       
        this.add(ico1);
        this.add(Box.createRigidArea(new Dimension(170, 0)));
        this.add(ico2);
        this.add(Box.createRigidArea(new Dimension(170, 0)));
        this.add(ico3);
        
        
        
        
        
        
    }
    
    
    @Override
        public void paint(Graphics g){
        super.paint(g);

        }
    
    
    
}
