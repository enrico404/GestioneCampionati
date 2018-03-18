/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionecampionati.grafica.Listener;

import gestionecampionati.Campionato;
import gestionecampionati.grafica.Errors_Confirm.ErrorPanel;
import gestionecampionati.grafica.MainFrame;
import gestionecampionati.grafica.MenuPanel;
import gestionecampionati.grafica.visualizza_classifica.VisClassificaSk;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Enrico
 */
public class VisualizzaClassificaActionListener implements ActionListener {
    private Campionato c;
    private MenuPanel old;
    private MainFrame f;
    private ErrorPanel err;

    public VisualizzaClassificaActionListener(Campionato c, MenuPanel old, MainFrame f) {
        this.c = c;
        this.old = old;
        this.f = f;
    }
    
    
   
    @Override
    public void actionPerformed(ActionEvent e) {
        
        
        try{
         if(old.isEnabled() && !(c.getC().getCoppie().isEmpty())){
           
            c.calcola_calssifica();
            VisClassificaSk panel = new VisClassificaSk(c);
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