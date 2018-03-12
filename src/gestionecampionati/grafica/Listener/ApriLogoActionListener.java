/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionecampionati.grafica.Listener;

import gestionecampionati.grafica.MainFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JFileChooser;

/**
 *
 * @author enrico
 */
public class ApriLogoActionListener implements ActionListener{
    private MainFrame fr;
    private String path;

    public ApriLogoActionListener(MainFrame f, String path) {
        this.fr = fr;
        this.path = path;
    }
    
    
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        JFileChooser chooser;
        chooser = new JFileChooser("../GestioneCampionati/media/loghi");
            chooser.setDialogTitle("Apri");
            chooser.showOpenDialog(fr);
            
        File f = chooser.getSelectedFile();
        path = f.getAbsolutePath();
        
        
        
        
    }
    
}
