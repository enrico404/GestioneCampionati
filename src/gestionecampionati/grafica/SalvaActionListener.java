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
import java.io.FileFilter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author enrico
 */
class SalvaActionListener implements ActionListener {
    private Campionato c;
    private MainFrame fr;
    
    /** 
     * tipo di oggetto da salvare 
     * 0 -> calendario, 1 -> squadre
     */
    private int tipo; 
    
    
    public SalvaActionListener(Campionato c, MainFrame fr, int tipo) {
       this.c = c;
       this.fr = fr;
       this.tipo  = tipo; 
        
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JFileChooser chooser;
         int userSelection;
        if(tipo == 0)
         chooser = new JFileChooser("../GestioneCampionati/saves/calendari");
        else chooser = new JFileChooser("../GestioneCampionati/saves/squadre");
            userSelection =  chooser.showSaveDialog(fr);
        
        if(userSelection == JFileChooser.APPROVE_OPTION){
        
        File fileToSave = chooser.getSelectedFile();
     
        FileOutputStream f; 
        ObjectOutputStream os;
        
        try {
           
            
            if(tipo == 0){
              
                f = new FileOutputStream(fileToSave.getPath() + ".dat");
                os = new ObjectOutputStream(f);
                os.writeObject(c.getC());
                System.out.println("Calendario salvato");
                os.flush();
                os.close();
            
            }
            if(tipo == 1){
               
                f = new FileOutputStream(fileToSave.getPath() + ".sq");
                os = new ObjectOutputStream(f);
                os.writeObject(c.getSquadre());
                System.out.println("Squadre salvate");
                os.flush();
                os.close();
            
            }
            
        } catch (IOException ex) {
            Logger.getLogger(Calendario.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        }
        

    }
    
}
