/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionecampionati.grafica.menuBar;


import gestionecampionati.Campionato;
import gestionecampionati.grafica.Errors_Confirm.ConfirmPanel;
import gestionecampionati.grafica.Home.MainPanel;
import gestionecampionati.grafica.MainFrame;
import gestionecampionati.grafica.MainFrame;
import gestionecampionati.grafica.ProgressBarFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JProgressBar;



/**
 *
 * @author enrico
 */
public class ApriActionListener implements ActionListener {
    private Campionato c;
    private MainFrame fr;
    private DefaultListModel<String> listmodel;
    private ConfirmPanel att;
    /** variabile per capire quale tipo di file caricare in memoria */
    private int tipo; 

    public ApriActionListener(Campionato c, MainFrame fr, DefaultListModel<String> lista, int tipo){
        this.c = c;
        this.fr = fr;
        this.listmodel = lista;
        this.tipo = tipo;
       
    }
                    

    @Override
    public void actionPerformed(ActionEvent e) {
        JFileChooser chooser;
        
        
        if(tipo == 0){
            chooser = new JFileChooser("./saves/calendari");
            chooser.setDialogTitle("Apri");
            chooser.showOpenDialog(fr);
        }
        else { chooser = new JFileChooser("./saves/squadre");
            chooser.setDialogTitle("Importa squadre");
            chooser.showOpenDialog(fr);
        }
            
        
        
        
      
      
        File f = chooser.getSelectedFile();
         try{
            String path = f.getAbsolutePath();
            
            if(tipo == 0){
                  
                
                
                 c.carica_calendario(path);
                 c.setSquadre(c.getC().getSquadre());
                 listmodel.removeAllElements();
                 listmodel.addElement("Squadre: ");
                 

                 if(c.getC() != null ) {System.out.println("Calendario caricato correttamente!");
                    c.getC().stampa_calendario();

                    }
            }
            if(tipo == 1){
               
                c.importa_squadre(path);
                listmodel.removeAllElements();
                listmodel.addElement("Squadre: ");
               
            
            
            }
           
         for(int i=1; i<=c.get_numSquadre(); i++){
            listmodel.addElement("- "+ c.getSquadre().get(i-1).getNome());
     
       
        }
        }catch(NullPointerException ex){
            System.out.println("Calendario non caricato ");
        } catch (InterruptedException ex) {
            Logger.getLogger(ApriActionListener.class.getName()).log(Level.SEVERE, null, ex);
        }
       
      
       
        
        
         
      
        
        
    }
    
}