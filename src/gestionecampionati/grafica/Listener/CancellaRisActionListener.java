/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionecampionati.grafica.Listener;

import gestionecampionati.Campionato;
import gestionecampionati.grafica.gestione_calendario.SkPanelDown;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Enrico
 */
public class CancellaRisActionListener implements ActionListener{
    private Campionato c;
    private SkPanelDown panelDown;

    public CancellaRisActionListener(Campionato c, SkPanelDown panelDown) {
        this.c = c;
        this.panelDown = panelDown;
    }
    
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        c.getC().cancella_ris();
        panelDown.getTab1().fireTableDataChanged();
        panelDown.getTab2().fireTableDataChanged();
        
    }
    
}
