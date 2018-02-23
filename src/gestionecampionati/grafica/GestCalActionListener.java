/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionecampionati.grafica;

import gestionecampionati.Campionato;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultListModel;

/**
 *
 * @author enrico
 */
class GestCalActionListener implements ActionListener {
    private MainFrame f;
    private MenuPanel oldPanel;
    private Campionato c;
    private DefaultListModel<String> listmodel;

    public GestCalActionListener(MainFrame f, MenuPanel oldPanel, Campionato c, DefaultListModel<String> listmodel) {
        this.f = f;
        this.oldPanel = oldPanel;
        this.c = c;
        this.listmodel = listmodel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(oldPanel.isEnabled()){
            GestCalPanel gestCal = new GestCalPanel(f, c, listmodel, oldPanel);
            f.remove(oldPanel);
            oldPanel.setEnabled(false);
            f.add(gestCal);
            f.validate();
            f.repaint();
        
        
        }
        
        
    }
    
}
