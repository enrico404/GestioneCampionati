/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionecampionati.grafica.Home;

import gestionecampionati.Campionato;
import gestionecampionati.grafica.Errors_Confirm.ErrorPanel;
import gestionecampionati.grafica.MainFrame;
import gestionecampionati.grafica.inserimento_risultati.InsRis.InsRisPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;

/**
 *
 * @author Enrico
 */
public class InsRisActionListener implements ActionListener{
    private JPanel old;
    private MainFrame f;
    private Campionato c;
    private ErrorPanel err;
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
