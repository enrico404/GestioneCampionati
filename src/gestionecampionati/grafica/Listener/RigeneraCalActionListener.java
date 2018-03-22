/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionecampionati.grafica.Listener;

import gestionecampionati.Calendario;
import gestionecampionati.Campionato;
import gestionecampionati.grafica.gestione_calendario.SkPanelDown;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Enrico
 */
public class RigeneraCalActionListener implements ActionListener{
    private Campionato c; 
    private SkPanelDown panelDown;

    public RigeneraCalActionListener(Campionato c, SkPanelDown panelDown) {
        this.c = c;
        this.panelDown = panelDown;
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {
        Calendario cal = new Calendario(c.getSquadre());
        cal.genera_calendario();
        c.setC(cal);
        panelDown.getTab1().fireTableDataChanged();
        panelDown.getTab2().fireTableDataChanged();
        
        
    }
    
}
