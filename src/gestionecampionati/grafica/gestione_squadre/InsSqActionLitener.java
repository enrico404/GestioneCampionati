
package gestionecampionati.grafica.gestione_squadre;

import gestionecampionati.Campionato;
import gestionecampionati.grafica.MainFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultListModel;
import javax.swing.JPanel;

/**
 * Listener del bottone "inserisci squadre", si occupa di sostituire i pannelli
 * @author enrico
 */
public class InsSqActionLitener implements ActionListener {

    private MainFrame f;
    private JPanel panelOld;
    private Campionato c;
    private DefaultListModel<String> listmodel;
    
    /**
     * Costruttore del listener, prende in input il vecchio pannello e quello nuovo. Prende anche
     * in input la lista di squadre partecipanti al campionato, in modo che se l'inserimento è 
     * avvenuto con successo, la aggiorna.
     * @param f frame in cui inserire il nuovo pannello 
     * @param panelOld vecchio pannello da sostituire
     * @param c struttura dati da aggiornare 
     * @param listmodel  list model da aggiornare 
     */
    public InsSqActionLitener(MainFrame f, JPanel panelOld, Campionato c, DefaultListModel<String> listmodel) {
        
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
          
        }

       
    }
    
}
