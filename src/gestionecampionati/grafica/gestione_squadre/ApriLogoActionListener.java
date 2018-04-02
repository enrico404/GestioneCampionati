
package gestionecampionati.grafica.gestione_squadre;

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
 * Listener che si occupa di caricare in memoria il logo di una squadra, se il logo non è presente nel database 
 * dei loghi allora ne fa una copia e se lo salva.
 * @author enrico
 */
public class ApriLogoActionListener implements ActionListener{
    private JFrame fr;
    private String path;
    
    

    /**
     * Costruttore del listener, prende in input il frame padre.
     * @param f frame principale del programma
     */
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
