/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionecampionati.grafica.Listener;

import gestionecampionati.Campionato;
import gestionecampionati.grafica.MainFrame;
import gestionecampionati.grafica.MenuPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultListModel;
import javax.swing.JPanel;

/**
 *
 * @author enrico
 */
public class ChiudiActionListener implements ActionListener {

    private MainFrame f;
    private JPanel old;
    private Campionato c;
    private DefaultListModel<String> listmodel;
    private MenuPanel centP;
    
    public ChiudiActionListener(MainFrame f, JPanel old, Campionato c, DefaultListModel<String> listmodel, MenuPanel centP) {
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
