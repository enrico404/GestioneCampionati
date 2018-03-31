
package gestionecampionati.grafica.gestione_calendario;

import java.awt.TextField;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

/**
 * Listener del campo di testo, serve per cancellare il campo di testo al focus
 * @author enrico
 */
public class CercaTextFocusListener implements FocusListener{
    
    private TextField cerca; 
    
    /**
     * Costruttore in cui assegno l'evento al campo di testo
     * @param cerca campo di testo
     */
    public CercaTextFocusListener(TextField cerca){
        this.cerca = cerca;
    
    }

    @Override
    public void focusGained(FocusEvent e) {
        cerca.setText("");
    }

    @Override
    public void focusLost(FocusEvent e) {
        
    }
   


}
