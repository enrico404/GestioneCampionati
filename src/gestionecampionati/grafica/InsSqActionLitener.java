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
import javax.swing.JPanel;

/**
 *
 * @author enrico
 */
class InsSqActionLitener implements ActionListener {

    private MainFrame f;
    private CenterCalcioP panelOld;
    private Campionato c;
    private DefaultListModel<String> listmodel;
    public InsSqActionLitener(MainFrame f, CenterCalcioP panelOld, Campionato c, DefaultListModel<String> listmodel) {
        this.f = f;
        this.panelOld = panelOld;
        this.c  = c;
        this.listmodel = listmodel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(panelOld.isEnabled()){
           
            InsSqPanel panel = new InsSqPanel(f, c, listmodel, panelOld);
            f.remove(panelOld);
            panelOld.setEnabled(false);
            f.add(panel);
            f.validate();
            f.repaint();
        }

       
    }
    
}
