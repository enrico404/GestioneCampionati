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
  

    @Override
    public void actionPerformed(ActionEvent e) {
        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(chooser);
        File f = chooser.getSelectedFile();
        String path = f.getAbsolutePath();
        
        
        
        
        c = new Campionato();
        
        
        
    }
    
}
