/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionecampionati.grafica.menuBar;

import gestionecampionati.grafica.AboutFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Enrico
 */
public class AboutFrameListener implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent e) {
        AboutFrame frame = new AboutFrame("About");
        frame.setVisible(true);
        
        
    }
    
    
    
}
