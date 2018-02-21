/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionecampionati.grafica;

import java.awt.Dimension;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author enrico
 */
public class CenterCalcioP extends JPanel {
   private JButton GestCal; 
   private JButton InsRis;
   private JButton VisClass;
    
   public CenterCalcioP(){
       super();
       this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
       
       
       Dimension button = new Dimension(200, 50);
            GestCal = new JButton("Gestione calendario");
            InsRis = new JButton("Inserisci risultati");
            VisClass = new JButton("Visualizza classifica");
       
                GestCal.setAlignmentX(CENTER_ALIGNMENT);
            GestCal.setPreferredSize(button);
            GestCal.setMaximumSize(button);
             GestCal.setMinimumSize(button);
            InsRis.setAlignmentX(CENTER_ALIGNMENT);
            InsRis.setPreferredSize(button);
            InsRis.setMaximumSize(button);
            InsRis.setMinimumSize(button);
            VisClass.setAlignmentX(CENTER_ALIGNMENT);
            VisClass.setPreferredSize(button);
            VisClass.setMinimumSize(button);
            VisClass.setMaximumSize(button);
            
            
            
            add(Box.createRigidArea(new Dimension(0, 80)));
            add(Box.createRigidArea(new Dimension(0, 40)));
            add(GestCal);
            add(Box.createRigidArea(new Dimension(0, 20)));
            add(VisClass);
            add(Box.createRigidArea(new Dimension(0, 20)));
            add(InsRis);
      
   
   
   }
    
    
    
}
