/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionecampionati.grafica;

import gestionecampionati.grafica.MainFrame;
import gestionecampionati.grafica.Home.MenuPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;

/**
 *
 * @author enrico
 */
public class ChiudiActionListener implements ActionListener {

    private MainFrame f;
    private JPanel old;
    private JPanel nuovo;
    
    public ChiudiActionListener(MainFrame f, JPanel old, JPanel nuovo) {
        this.old = old;
        this.f = f;
      
        this.nuovo = nuovo;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        nuovo.setEnabled(true);
        f.remove(old);
        f.add(nuovo);
        f.validate();
        f.repaint();
        
    }
    
}
