/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionecampionati.grafica.Listener;

import gestionecampionati.Campionato;
import gestionecampionati.grafica.inserimento_risultati.InsRisPanel;
import gestionecampionati.grafica.MainFrame;
import gestionecampionati.grafica.MenuPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;

/**
 *
 * @author Enrico
 */
public class InsRisActionListener implements ActionListener{
    private MenuPanel old;
    private MainFrame f;
    private Campionato c;

    public InsRisActionListener( MainFrame f, MenuPanel old, Campionato c) {
        this.old = old;
        this.f = f;
        this.c = c;
    }
    
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
         if(old.isEnabled()){
           
            InsRisPanel panel = new InsRisPanel(old, c, f);
            f.remove(old);
            old.setEnabled(false);
            f.add(panel);
            f.validate();
          
        }
    }
    
}
