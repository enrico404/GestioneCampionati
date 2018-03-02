/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionecampionati.grafica.Listener;

import gestionecampionati.Campionato;
import gestionecampionati.grafica.Errors.ErrorPanel;
import gestionecampionati.grafica.MainFrame;
import gestionecampionati.grafica.gestione_calendario.GestCSk;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Enrico
 */
public class CercaGiornataActionListener implements ActionListener {
    
    private Campionato c;
    private MainFrame f;
    private GestCSk p;
    private ErrorPanel err;
    public CercaGiornataActionListener(MainFrame f, Campionato c, GestCSk p) {
       this.c = c;
       this.f = f;
       this.p = p;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(!(p.getPanelCenter().getPanelA().getSqa().getSelectedItem().equals(p.getPanelCenter().getPanelB().getSqb().getSelectedItem()))){
            p.remove(p.getPanelDown());
             f.repaint();
        }else err = new ErrorPanel(4);
    }
    
}
