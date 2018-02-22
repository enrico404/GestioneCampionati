/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionecampionati.grafica;

import gestionecampionati.Calendario;
import gestionecampionati.Campionato;
import gestionecampionati.Squadra;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileFilter;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JList;
import javax.swing.ListModel;
import javax.swing.filechooser.FileNameExtensionFilter;
import sun.security.x509.Extension;

/**
 *
 * @author enrico
 */
class ApriActionListener implements ActionListener {
    private Campionato c;
    private MainFrame fr;
    private CalcioPanel panel;
    private DefaultListModel<String> listmodel;
    
    /** variabile per capire quale tipo di file caricare in memoria */
    private int tipo; 

    public ApriActionListener(Campionato c, MainFrame fr, CalcioPanel panel, DefaultListModel<String> lista, int tipo){
        this.c = c;
        this.fr = fr;
        this.panel = panel;
        this.listmodel = lista;
        this.tipo = tipo;
    }
                    

    @Override
    public void actionPerformed(ActionEvent e) {
        JFileChooser chooser;
        
        
        if(tipo == 0)
         chooser = new JFileChooser("../GestioneCampionati/saves/calendari");
        else chooser = new JFileChooser("../GestioneCampionati/saves/squadre");
        chooser.showOpenDialog(fr);
      
      
        File f = chooser.getSelectedFile();
         try{
            String path = f.getAbsolutePath();
        
            if(tipo == 0){
                /*
                FileNameExtensionFilter datFilter = new FileNameExtensionFilter("dat file filter", "dat");
                chooser.setFileFilter(datFilter);

                */
                 c.carica_calendario(path);
                 c.setSquadre(c.getC().getSquadre());
                 if(c.getC() != null ) {System.out.println("Calendario caricato correttamente!");
                    c.getC().stampa_calendario();
            
                    }
            }
            if(tipo == 1){
               
                c.importa_squadre(path);
                
            
            
            }
        
        }catch(NullPointerException ex){
            System.out.println("Calendario non caricato ");
        }
       
      
        for(int i=1; i<=c.get_numSquadre(); i++){
            listmodel.addElement("- "+ c.getSquadre().get(i-1).getNome());
     
       
        }
        
        
         
      
        
        
    }
    
}
