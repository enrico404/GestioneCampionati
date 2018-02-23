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
    private CenterCalcioP centP;
    
    public ChiudiActionListener(MainFrame f, InsSqPanel old, Campionato c, DefaultListModel<String> listmodel, CenterCalcioP centP) {
        this.old = old;
        this.f = f;
        this.c = c;
        this.listmodel = listmodel;
        this.centP = centP;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        centP.setEnabled(true);
        f.remove(old);
        f.add(centP);
        f.validate();
        f.repaint();
        
    }
    
}
