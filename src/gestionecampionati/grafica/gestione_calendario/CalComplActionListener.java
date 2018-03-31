
package gestionecampionati.grafica.gestione_calendario;

import gestionecampionati.Campionato;
import gestionecampionati.grafica.MainFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.text.View;

/**
 * Listener del bottone per mostrare il calendario, è utile per ricaricare la visualizzazione
 * del calendario completo di tutti i gironi
 * @author Enrico
 */
public class CalComplActionListener implements ActionListener {
    private MainFrame f;
    private GestCSk sk;
    private Campionato c;
    private SkPanelDown pdown;
    
    
    
    /**
     *  Costruttore con parametri del listener
     * @param f Frame in cui inserire il pannello 
     * @param sk pannello scheletro da cui recuperare la posizione all'interno del frame in cui inserire il pannello nuovo 
     * @param c struttura dati da cui recuperare i dati
     */
    public CalComplActionListener(MainFrame f,GestCSk sk, Campionato c ){
        this.f = f;
        this.sk = sk;
        this.c = c;
        
    
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        sk.getPanelDown().removeAll();
        pdown = new SkPanelDown(c,sk,f);
        sk.getPanelDown().setLayout(new BoxLayout(sk.getPanelDown(), View.Y_AXIS));
        sk.getPanelDown().add(pdown);
        f.revalidate();
        
        
    }
    
}
