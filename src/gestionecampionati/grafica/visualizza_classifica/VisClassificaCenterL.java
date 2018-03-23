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
    
    
    
    public VisClassificaCenterL(Campionato c) {
        this.c = c;
        BufferedImage[] bf = new BufferedImage[3];
        JLabel[] ico = new JLabel[3];
        int i =0;
        try {   
           while(i<c.get_numSquadre() && i<3){
                bf[i] = ImageIO.read(new File(c.getCls().getClassifica().get(i).getLogo()));
                ico[i]  = new JLabel(new ImageIcon(bf[i]));
                i++;
              
                }
            
            
        } catch (IOException ex) {
            Logger.getLogger(VisClassificaCenterL.class.getName()).log(Level.SEVERE, null, ex);
        }
        
      
        this.setLayout(new BoxLayout(this, View.X_AXIS));
        
        this.add(Box.createRigidArea(new Dimension(170, 0)));
        for(int j=0; j<i; j++){
            this.add(ico[j]);
            this.add(Box.createRigidArea(new Dimension(170, 0)));
             
        
        }
        
       
       
        
        
        
        
        
        
    }
    
    
    
    
    
    @Override
        public void paint(Graphics g){
        super.paint(g);

        }
    
    
    
}
