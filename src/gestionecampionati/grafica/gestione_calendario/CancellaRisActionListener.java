
package gestionecampionati.grafica.gestione_calendario;

import gestionecampionati.Campionato;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Lister del bottone cancella risultati.
 * Cancella tutti i risultati delle partite dal calendario.
 * @author Enrico
 */
public class CancellaRisActionListener implements ActionListener{
    private Campionato c;
    private SkPanelDown panelDown;

    
    /** 
     * Costruttore con parametri in cui vado a passare i dati da modificare
     * @param c struttura dati da modificare
     * @param panelDown  pannello da cui recupero i riferimenti alle tabelle che mostrano i due gironi
     */
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
