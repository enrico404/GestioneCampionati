
package gestionecampionati.grafica.gestione_calendario;

import gestionecampionati.Calendario;
import gestionecampionati.Campionato;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Listener del pulsante rigenera calendario. Si occupa di ricreare le varie giornate, sempre
 * in maniera randomica. 
 * @author Enrico
 */
public class RigeneraCalActionListener implements ActionListener{
    private Campionato c; 
    private SkPanelDown panelDown;
    
    
    /**
     * Costruttore con parametri del listener
     * @param c Struttura dati da modificare 
     * @param panelDown   pannello da cui recupero le tabelle da aggiornare
     */
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
