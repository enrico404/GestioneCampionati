
package gestionecampionati.grafica.Home;

import gestionecampionati.Campionato;
import gestionecampionati.grafica.Errors_Confirm.ErrorPanel;
import gestionecampionati.grafica.MainFrame;
import gestionecampionati.grafica.inserimento_risultati.InsRis.InsRisPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;

/**
 * Listener per inserire il pannello di inserimento dei risultati nel caso degli 
 * sporto del calcio e del basket
 * @author Enrico
 */
public class InsRisActionListener implements ActionListener{
    private JPanel old;
    private MainFrame f;
    private Campionato c;
    private ErrorPanel err;
    
    /**
     * Costruttore che inserisce il pannello dei risultati al posto del pannello corrente
     * @param f frame in cui inserire il pannello   
     * @param old    vecchio pannello da sostituire
     * @param c  struttura dati da passare al nuovo pannello
     */
    public InsRisActionListener( MainFrame f, JPanel old, Campionato c) {
        this.old = old;
        this.f = f;
        this.c = c;
    }
    
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        try{
         if(old.isEnabled() && !(c.getC().getCoppie().isEmpty())){
           
            
            InsRisPanel panel = new InsRisPanel(old, c, f);
            f.remove(old);
            old.setEnabled(false);

            f.add(panel);
            f.validate();
         }
        }catch(Exception ex){
        
            err = new ErrorPanel(3);
        

          
        }
    }
    
}
