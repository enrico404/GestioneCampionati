/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionecampionati.grafica.inserimento_risultati.InsRis2;

import gestionecampionati.Campionato;
import gestionecampionati.grafica.MainFrame;
import gestionecampionati.grafica.inserimento_risultati.InsRis.InsRisPanelUP;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JLabel;

/**
 *
 * @author Enrico
 */
public class VaiActionListener implements ActionListener {
    private InsRisPanelUP panelUp;
    private JComboBox num_set;
    private MainFrame f;
    private InsRisPanel2 old;
    private Campionato c;
   

    public VaiActionListener(Campionato c, InsRisPanelUP panelUp, JComboBox num_set, MainFrame f, InsRisPanel2 old) {
        this.panelUp = panelUp;
        this.num_set = num_set;
        this.f = f;
        this.old = old;
        this.c = c;
        
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        InsSetParzialiPanel panel = new InsSetParzialiPanel(c, panelUp, num_set, old, f);
       
        f.remove(old);
        f.add(panel);
        f.validate();
        f.repaint();
        
    }
    
}
