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
class ChiudiActionListener implements ActionListener {

    private MainFrame f;
    private InsSqPanel old;
    private Campionato c;
    private DefaultListModel<String> listmodel;
    
    public ChiudiActionListener(MainFrame f, InsSqPanel old, Campionato c, DefaultListModel<String> listmodel) {
        this.old = old;
        this.f = f;
        this.c = c;
        this.listmodel = listmodel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        CenterCalcioP panel = new CenterCalcioP(f, c, listmodel);
        f.remove(old);
        f.add(panel);
        f.validate();
        f.repaint();
        
    }
    
}
