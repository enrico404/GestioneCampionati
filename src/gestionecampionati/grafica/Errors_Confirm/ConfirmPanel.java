/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionecampionati.grafica.Errors_Confirm;

import gestionecampionati.grafica.MainFrame;
import java.awt.Graphics;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Enrico
 */
public class ConfirmPanel extends JPanel {
    private int code;
  
    
    public ConfirmPanel(int code){
        this.code = code;
      
        switch(code){
            case 1: JOptionPane.showMessageDialog(this, "Risultato inserito correttamente!", "Risultato inserito", JOptionPane.INFORMATION_MESSAGE);
                    break;
            
        }
    
    }
        @Override
        public void paint(Graphics g){
        super.paint(g);
    
       

        }
    
    
    
}
