/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionecampionati.grafica.gestione_calendario;

import gestionecampionati.Campionato;
import gestionecampionati.grafica.gestione_calendario.GestCalPanel;
import gestionecampionati.grafica.MainFrame;
import gestionecampionati.grafica.Home.MenuPanel;
import gestionecampionati.grafica.gestione_calendario.GestCSk;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultListModel;

/**
 *
 * @author enrico
 */
public class GestCalActionListener implements ActionListener {
    private MainFrame f;
    private MenuPanel oldPanel;
    private Campionato c;
    private DefaultListModel<String> listmodel;

    public GestCalActionListener(MainFrame f, MenuPanel oldPanel, Campionato c) {
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
            f.validate();
            f.repaint();
        
        
        }
        
        
    }
    
}
