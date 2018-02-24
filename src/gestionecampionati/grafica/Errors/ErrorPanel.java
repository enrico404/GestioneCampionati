/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionecampionati.grafica.Errors;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author enrico
 */
public class ErrorPanel extends JPanel{
    private int errCode;
    
    
    public ErrorPanel(int errCode){
        this.errCode = errCode;
        
        switch(errCode){
            case 1: JOptionPane.showMessageDialog(this, "Calendario non ancora creato!", "Errore!" ,JOptionPane.ERROR_MESSAGE);
                    break;
            case 2: JOptionPane.showMessageDialog(this, "Inserire almeno una squadra!", "Errore!" ,JOptionPane.ERROR_MESSAGE);
                    break;  
                    
            case 3: JOptionPane.showMessageDialog(this, "Inserire almeno due squadre per generare le partite!", "Errore!" ,JOptionPane.ERROR_MESSAGE);
                    break;
        }
    
    }
    
}
