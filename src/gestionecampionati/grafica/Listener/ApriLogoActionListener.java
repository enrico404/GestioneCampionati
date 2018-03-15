/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionecampionati.grafica.Listener;

import gestionecampionati.Squadra;
import gestionecampionati.grafica.MainFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import static java.lang.System.out;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;

/**
 *
 * @author enrico
 */
public class ApriLogoActionListener implements ActionListener{
    private MainFrame fr;
    private String path;

    public ApriLogoActionListener(MainFrame f) {
        this.fr = fr;
        this.path = new String("");
        
    }
    
    
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        JFileChooser chooser;
        chooser = new JFileChooser("../");
            chooser.setDialogTitle("Apri");
            chooser.showOpenDialog(fr);
            
        File f = chooser.getSelectedFile();
                try{
                this.path = f.getAbsolutePath();

                FileChannel source = null;
                FileChannel dest = null;

                File f2 = new File("../GestioneCampionati/media/loghi/"+ f.getName());

                try {
                    source = new FileInputStream(f).getChannel();
                    dest = new FileOutputStream(f2).getChannel();

                    if(source != null && dest != null){
                        dest.transferFrom(source, 0, source.size());
                        source.close();
                        dest.close();



                    }


                } catch (FileNotFoundException ex) {
                    Logger.getLogger(ApriLogoActionListener.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(ApriLogoActionListener.class.getName()).log(Level.SEVERE, null, ex);
                }
        
        }catch(NullPointerException exc){
            
            System.out.println("Logo non inserito");
            
        }
  
        
    }       

    public String getPath() {
        return this.path;
    }

    public void setPath(String path) {
        this.path = path;
    }
    
    
    
}
