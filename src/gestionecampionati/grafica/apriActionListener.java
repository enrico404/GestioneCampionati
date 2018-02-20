/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionecampionati.grafica;

import gestionecampionati.Calendario;
import gestionecampionati.Campionato;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JFileChooser;

/**
 *
 * @author enrico
 */
class apriActionListener implements ActionListener {
    private Campionato c;
    private MyFrame fr;

    public apriActionListener(Campionato c, MyFrame fr){
        this.c = c;
        this.fr = fr;
    
    
    }
                    

    @Override
    public void actionPerformed(ActionEvent e) {
        JFileChooser chooser = new JFileChooser("../GestioneCampionati/saves/");
        chooser.showOpenDialog(fr);
        File f = chooser.getSelectedFile();
         try{
            String path = f.getAbsolutePath();
        
            c.carica_calendario(path);
            c.setSquadre(c.getC().getSquadre());
            if(c.getC() != null ) {System.out.println("Calendario caricato correttamente!");
            c.getC().stampa_calendario();
            }
        
        }catch(NullPointerException ex){
            System.out.println("Calendario non caricato ");
        }
       
        
        
        
    }
    
}
