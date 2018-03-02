/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionecampionati.grafica.gestione_calendario;

import gestionecampionati.Campionato;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.text.View;

/**
 *
 * @author Enrico
 */
public class SkPanelCenterSqA extends JPanel {
    private Campionato c;
    private JComboBox sqa; 
    private JLabel lsqa, vs;
    private Dimension d;
    private Font font;
    
    
    
    public SkPanelCenterSqA(Campionato c, Font font) {
        super();
        this.c = c;
        this.font = font;
      
        
        
        d = new Dimension(200 , 30);
        lsqa = new JLabel("Squadra Casa: ");
        vs = new JLabel("VS");
        
        lsqa.setFont(font);
        vs.setFont(font);
        
        sqa = new JComboBox();
        
        sqa.setMaximumSize(d);
        sqa.setMinimumSize(d);
        sqa.setBackground(Color.white);
      
          
            
        
        
        
        
        
        
        
        
        
        
        this.setLayout(new BoxLayout(this, View.X_AXIS));
        
        this.add(lsqa);
        this.add(Box.createRigidArea(new Dimension(20, 0)));
        this.add(sqa);
        this.add(Box.createRigidArea(new Dimension(60, 0)));
        this.add(vs);
        this.add(Box.createRigidArea(new Dimension(60, 0)));
        
        
    }
    
    
    public boolean riempi(){
         
                  for(int i=0; i<c.getSquadre().size(); i++){
                  
                       sqa.addItem(c.getSquadre().get(i).getNome());
                  }
            
            
            return true;
    
    
    }

    public JComboBox getSqa() {
        return sqa;
    }
    
    
    
     @Override
        public void paint(Graphics g){
        super.paint(g);
        repaint();
       

        }
    
    
}
