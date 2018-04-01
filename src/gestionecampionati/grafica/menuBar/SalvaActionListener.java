
package gestionecampionati.grafica.menuBar;

import gestionecampionati.Calendario;
import gestionecampionati.Campionato;
import gestionecampionati.grafica.Errors_Confirm.ErrorPanel;
import gestionecampionati.grafica.MainFrame;
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
 * Listener della menu bar che permette di salvare in un file l'intero calendario
 * o solo le squadre, e ricaricare in memoria il tutto in un secondo momento.
 * @author enrico
 */
public class SalvaActionListener implements ActionListener {
    private Campionato c;
    private MainFrame fr;
    
    /** 
     * tipo di oggetto da salvare 
     * 0 -> calendario, 1 -> squadre
     */
    private int tipo; 
    
    /**
     * Costruttore con parametri del listener, prende in input il codice per capire
     * se deve salvare il calendario completo o solo le squadre 
     * @param c struttura dati
     * @param fr frame di riferimento per il jfile chooser
     * @param tipo  codice per capire che tipo di savatagggio si tratta
     */
    public SalvaActionListener(Campionato c, MainFrame fr, int tipo) {
       this.c = c;
       this.fr = fr;
       this.tipo  = tipo; 
        
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JFileChooser chooser;
         int userSelection;
        if(tipo == 0){
              chooser = new JFileChooser("../GestioneCampionati/saves/calendari");
              chooser.setDialogTitle("Salva");
        }
        else{ chooser = new JFileChooser("../GestioneCampionati/saves/squadre");
                chooser.setDialogTitle("Esporta squadre");
        
        
        }
            userSelection =  chooser.showSaveDialog(fr);
        
        if(userSelection == JFileChooser.APPROVE_OPTION){
        
        File fileToSave = chooser.getSelectedFile();
     
        FileOutputStream f; 
        ObjectOutputStream os;
        
        try {
           
            
            if(tipo == 0){
                if(c.getC() != null){
                    f = new FileOutputStream(fileToSave.getPath() + ".dat");
                    os = new ObjectOutputStream(f);
                    os.writeObject(c.getC());
                    System.out.println("Calendario salvato");
                    os.flush();
                    os.close();
                }else {
                    ErrorPanel panel = new ErrorPanel(1);
                    
                
                }
            
            }
            if(tipo == 1){
               if(!(c.getSquadre().isEmpty())){
                    f = new FileOutputStream(fileToSave.getPath() + ".sq");
                    os = new ObjectOutputStream(f);
                    os.writeObject(c.getSquadre());
                    System.out.println("Squadre salvate");
                    os.flush();
                    os.close();
               }else {
                   ErrorPanel panel = new ErrorPanel(2);
               
               }
            
            }
            
        } catch (IOException ex) {
            Logger.getLogger(Calendario.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        }
        

    }
    
}
