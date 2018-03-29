/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionecampionati.grafica.gestione_squadre;

import gestionecampionati.grafica.MainFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

/**
 *
 * @author enrico
 */
public class ApriLogoActionListener implements ActionListener{
    private JFrame fr;
    private String path;

    public ApriLogoActionListener(JFrame f) {
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
                if(!(f2.exists())){
                        try {
                            source = new FileInputStream(f).getChannel();
                            dest = new FileOutputStream(f2).getChannel();

                            if(source != null && dest != null ){
                                System.out.print("fefefefef");
                                dest.transferFrom(source, 0, source.size());
                                source.close();
                                dest.close();


                            }


                        } catch (FileNotFoundException ex) {
                            Logger.getLogger(ApriLogoActionListener.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (IOException ex) {
                            Logger.getLogger(ApriLogoActionListener.class.getName()).log(Level.SEVERE, null, ex);
                        }
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
