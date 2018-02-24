/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionecampionati.grafica;

import gestionecampionati.Calendario;
import gestionecampionati.Campionato;
import gestionecampionati.grafica.Errors.ErrorPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author enrico
 */
class GenPActionListeneter implements ActionListener {
    private MainFrame f;
    private GestCalPanel oldPanel;
    private Campionato c;
    private ErrorPanel error;
    private Calendario cal;
    

    public GenPActionListeneter(MainFrame f, GestCalPanel oldPanel, Campionato c) {
        this.f = f;
        this.oldPanel = oldPanel;
        this.c = c;
        
        
    }
    
    

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(c.get_numSquadre() >= 2){
            
            System.out.println(c.get_numSquadre());
            
            cal = new Calendario(c.getSquadre());
            cal.genera_calendario();
            c.setC(cal);
            
            c.getC().stampa_calendario();
            System.out.println("Calendario generato correttamente");
        
        
        }
        else  error = new ErrorPanel(3);
        
        
    }
    
    
    public boolean sostituisci(){
    
    
        return true;
    }
            
       
    
}
