/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionecampionati.grafica.gestione_calendario;

import gestionecampionati.Campionato;
import gestionecampionati.grafica.MainFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultListModel;
import javax.swing.JPanel;

/**
 *
 * @author enrico
 */
public class GestCalActionListener implements ActionListener {
    private MainFrame f;
    private JPanel oldPanel;
    private Campionato c;
    private DefaultListModel<String> listmodel;

    public GestCalActionListener(MainFrame f, JPanel oldPanel, Campionato c) {
        this.f = f;
        this.oldPanel = oldPanel;
        this.c = c;

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(oldPanel.isEnabled() && (c.getC() == null)){
     
            GestCalPanel gestCal = new GestCalPanel(f, c, oldPanel);
            f.remove(oldPanel);
            oldPanel.setEnabled(false);

            f.add(gestCal);
            f.validate();
            f.repaint();
        
        
        }else {
            
            GestCSk sk = new GestCSk(f, c, oldPanel); 
            f.remove(oldPanel);
            f.add(sk);
  ;
            f.validate();
            f.repaint();
        
        
        }
        
        
    }
    
}
