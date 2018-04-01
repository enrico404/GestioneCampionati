
package gestionecampionati.grafica.gestione_calendario;

import gestionecampionati.Campionato;
import gestionecampionati.grafica.MainFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultListModel;
import javax.swing.JPanel;

/**
 * Listener del bottone per la gestione del calendario
 * @author enrico
 */
public class GestCalActionListener implements ActionListener {
    private MainFrame f;
    private JPanel oldPanel;
    private Campionato c;
    private DefaultListModel<String> listmodel;

    /** 
     * Costruttore con parametri del listener, in cui passsare i vari dati necessari
     * @param f frame in cui inserire il nuovo pannello
     * @param oldPanel vecchio pannell da sostituire
     * @param c  struttura dati da cui recuperare il calendario
     */
    public GestCalActionListener(MainFrame f, JPanel oldPanel, Campionato c) {
        this.f = f;
        this.oldPanel = oldPanel;
        this.c = c;

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(oldPanel.isEnabled() && (c.getC() == null)){
     
            GestCalPanel gestCal = new GestCalPanel(f, c, oldPanel);
            f.remove(oldPanel);
            oldPanel.setEnabled(false);

            f.add(gestCal);
            f.validate();
            f.repaint();
        
        
        }else {
            
            GestCSk sk = new GestCSk(f, c, oldPanel); 
            f.remove(oldPanel);
            f.add(sk);
  
            f.validate();
            f.repaint();
        
        
        }
        
        
    }
    
}
