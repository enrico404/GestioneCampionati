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
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;

/**
 *
 * @author enrico
 */
class SalvaActionListener implements ActionListener {
    private Campionato c;
    private MainFrame fr;
    
    
    public SalvaActionListener(Campionato c, MainFrame fr) {
       this.c = c;
       this.fr = fr;
        
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JFileChooser chooser = new JFileChooser("../GestioneCampionati/saves/");
        int userSelection =  chooser.showSaveDialog(fr);
        if(userSelection == JFileChooser.APPROVE_OPTION){
        
        File fileToSave = chooser.getSelectedFile();
        FileOutputStream f; 
        ObjectOutputStream os;
        
        try {
            f = new FileOutputStream(fileToSave.getPath() + ".dat");
            os = new ObjectOutputStream(f);
            os.writeObject(c.getC());
            os.flush();
            os.close();
            System.out.println("Calendario salvato");
        } catch (IOException ex) {
            Logger.getLogger(Calendario.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        }
        

    }
    
}
