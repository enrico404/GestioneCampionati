/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionecampionati.grafica.gestione_calendario;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Enrico
 */
public class CercaGiornataPanelUp extends JPanel{

  
   private JLabel icoA;
   private JLabel icoB;
   
   public CercaGiornataPanelUp(JLabel icoA, JLabel icoB) {
   
        this.icoA = icoA;
        this.icoB = icoB;
        Font font = new Font("sans-serif", Font.BOLD, 40);
        
        JLabel vs = new JLabel("-");
        vs.setFont(font);
        
        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        
        this.add(Box.createRigidArea(new Dimension(0, 40)));
        this.add(icoA);
        this.add(Box.createRigidArea(new Dimension(120, 20)));
        this.add(vs);
        this.add(Box.createRigidArea(new Dimension(120, 40)));
        this.add(icoB);
        
    }
    
     @Override
        public void paint(Graphics g){
        super.paint(g);
      
        }
    
}
