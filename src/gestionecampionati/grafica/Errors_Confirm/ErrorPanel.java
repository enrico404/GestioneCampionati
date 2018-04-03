
package gestionecampionati.grafica.Errors_Confirm;

import java.awt.Graphics;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * Pannello che riporta un errore verificatosi durante l'esecuzione del programma
 * @author Enrico
 */
public class ErrorPanel extends JPanel{
    private int errCode;
    
    
    /**
     * Costruttore con parametri del pannello che riporta un errore
     * @param errCode codice di errore
     */
    public ErrorPanel(int errCode){
        this.errCode = errCode;
        
        switch(errCode){
            case 1: JOptionPane.showMessageDialog(this, "Calendario non ancora creato!", "Errore!" ,JOptionPane.ERROR_MESSAGE);
                    break;
            case 2: JOptionPane.showMessageDialog(this, "Inserire almeno una squadra!", "Errore!" ,JOptionPane.ERROR_MESSAGE);
                    break;  
                    
            case 3: JOptionPane.showMessageDialog(this, "Possibili problemi con il calendario!", "Errore!" ,JOptionPane.ERROR_MESSAGE);
                    break;
            case 4: JOptionPane.showMessageDialog(this, "Le due squadre selezionate sono uguali!", "Errore!" ,JOptionPane.ERROR_MESSAGE);
                    break;
            case 5: JOptionPane.showMessageDialog(this, "Bisogna riempire entrambi i campi!", "Errore!" ,JOptionPane.ERROR_MESSAGE);
                    break;
            case 6: JOptionPane.showMessageDialog(this, "Inserire almeno due squadre!", "Errore!" ,JOptionPane.ERROR_MESSAGE);
                    break;
            case 7: JOptionPane.showMessageDialog(this, "Ci sono alcune partite non ancora giocate!", "Errore!" ,JOptionPane.ERROR_MESSAGE);
                    break;         
            case 8: JOptionPane.showMessageDialog(this, "Alcuni risultati non sono corretti (possibile parità)!", "Attenzione!" ,JOptionPane.ERROR_MESSAGE);
                    break;   
            case 9: JOptionPane.showMessageDialog(this, "La squadra inserita è già presente nel campionato!", "Attenzione!" ,JOptionPane.ERROR_MESSAGE);
                    break;  
            case 10: JOptionPane.showMessageDialog(this, "Provare a ricaricare il calendario per risolvere il problema", "Attenzione!" ,JOptionPane.ERROR_MESSAGE);
                    break;
        }
    
    }
       @Override
        public void paint(Graphics g){
        super.paint(g);
    
       

        }
    
}
