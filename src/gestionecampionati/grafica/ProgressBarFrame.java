/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionecampionati.grafica;

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.text.View;

/**
 *
 * @author Enrico
 */
public class ProgressBarFrame extends JFrame {
    private ProgressPanel ppanel;

    public ProgressBarFrame(String title) {
      
        ppanel = new ProgressPanel();
        
        this.setTitle(title);
       
        
        this.setSize(new Dimension(400,200));
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        
        this.add(ppanel);
        
    }

    public ProgressPanel getPpanel() {
        return ppanel;
    }

    public void setPpanel(ProgressPanel ppanel) {
        this.ppanel = ppanel;
    }

  

   
     

}
