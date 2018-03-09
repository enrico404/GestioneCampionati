/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionecampionati.grafica.gestione_calendario;

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Enrico
 */
public class CercaGiornataPanelBottom extends JPanel{

    private JLabel puntA;
    private JLabel puntB;
   
    public CercaGiornataPanelBottom(JLabel puntA, JLabel puntB) {
        this.puntA = puntA;
        this.puntB = puntB;
        
        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        
     
        this.add(puntA);
        this.add(Box.createRigidArea(new Dimension(360, 0)));
        this.add(puntB);
        
        
    }
    
     @Override
        public void paint(Graphics g){
        super.paint(g);
      
        }
    
    
    
}
