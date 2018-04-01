
package gestionecampionati.grafica.inserimento_risultati.InsRis2;

import gestionecampionati.Campionato;
import gestionecampionati.grafica.MainFrame;
import gestionecampionati.grafica.inserimento_risultati.InsRis.InsRisPanelUP;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;

/**
 * Listener del bottone vai nella schermata di inserimento del numero di set
 * giocati dalle due squadre
 * @author Enrico
 */
public class VaiActionListener implements ActionListener {
    private InsRisPanelUP panelUp;
    private JComboBox num_set;
    private MainFrame f;
    private InsRisPanel2 old;
    private Campionato c;
   
    /**
     * Costruttore con parametri del listener, in base al numero di set inseriti 
     * dall'utente si creano x celle di inserimento dei risulati
     * @param c struttura dati
     * @param panelUp pannello da cui recuperare le squadre inserite dall'utente
     * @param num_set numero di set giocati inserito dall'utente
     * @param f frame in cui inserire i vari pannelli 
     * @param old  pannello menu per tornare al menu principale
     */
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
