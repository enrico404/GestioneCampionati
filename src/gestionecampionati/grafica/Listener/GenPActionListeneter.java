/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionecampionati.grafica.Listener;

import gestionecampionati.Calendario;
import gestionecampionati.Campionato;
import gestionecampionati.grafica.Errors_Confirm.ErrorPanel;
import gestionecampionati.grafica.gestione_calendario.GestCalPanel;
import gestionecampionati.grafica.MainFrame;
import gestionecampionati.grafica.MenuPanel;
import gestionecampionati.grafica.gestione_calendario.GestCSk;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author enrico
 */
public class GenPActionListeneter implements ActionListener {
    private MainFrame f;
    private GestCalPanel oldPanel;
    private Campionato c;
    private ErrorPanel error;
    private Calendario cal;
    private GestCSk panel;
    private MenuPanel menuP;
    

    public GenPActionListeneter(MainFrame f, GestCalPanel oldPanel, Campionato c, MenuPanel menuP) {
        this.f = f;
        this.oldPanel = oldPanel;
        this.c = c;
        this.menuP = menuP;
        
        
    }
    
    

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(c.get_numSquadre() >= 2){
            
          
            
            cal = new Calendario(c.getSquadre());
            cal.genera_calendario();
            c.setC(cal);
            
            c.getC().stampa_calendario();
            System.out.println("Calendario generato correttamente");
        
            sostituisci(); //cambio panel
        
        }
        else  error = new ErrorPanel(3);
        
        
    }
    
    
    public boolean sostituisci(){
        
        panel = new GestCSk(f,c, menuP);
        f.remove(this.oldPanel);
        f.add(panel);
        f.validate();
        f.repaint();
    
        return true;
    }
            
       
    
}
