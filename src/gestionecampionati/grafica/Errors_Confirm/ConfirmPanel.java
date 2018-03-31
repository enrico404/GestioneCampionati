
package gestionecampionati.grafica.Errors_Confirm;

import java.awt.Graphics;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * Pannello di conferma dell'avvenuto inserimento di risultati all'interno del calendario correttamente
 * @author Enrico
 */
public class ConfirmPanel extends JPanel {
    private int code;
  
    /**
     * Costruttore con parametri del pannello , in base al codice riporta un messaggio diverso
     * @param code codice di conferma per gestire il messaggio
     */
    public ConfirmPanel(int code){
        this.code = code;
      
        switch(code){
            case 1: JOptionPane.showMessageDialog(this, "Risultato inserito correttamente!", "Risultato inserito", JOptionPane.INFORMATION_MESSAGE);
                    break;
         
            
        }
    
    }
        @Override
        public void paint(Graphics g){
        super.paint(g);
    
       

        }

    
}
