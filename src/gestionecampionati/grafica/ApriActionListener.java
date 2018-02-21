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
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JList;
import javax.swing.ListModel;

/**
 *
 * @author enrico
 */
class ApriActionListener implements ActionListener {
    private Campionato c;
    private MainFrame fr;
    private CalcioPanel panel;
    private DefaultListModel<String> lista;

    public ApriActionListener(Campionato c, MainFrame fr, CalcioPanel panel, DefaultListModel<String> lista){
        this.c = c;
        this.fr = fr;
        this.panel = panel;
        this.lista = lista;
    }
                    

    @Override
    public void actionPerformed(ActionEvent e) {
        
        
        
        JFileChooser chooser = new JFileChooser("../GestioneCampionati/saves/");
        chooser.showOpenDialog(fr);
        File f = chooser.getSelectedFile();
         try{
            String path = f.getAbsolutePath();
        
            c.carica_calendario(path);
            c.setSquadre(c.getC().getSquadre());
            if(c.getC() != null ) {System.out.println("Calendario caricato correttamente!");
            c.getC().stampa_calendario();
            }
        
        }catch(NullPointerException ex){
            System.out.println("Calendario non caricato ");
        }
       
      
        for(int i=1; i<=c.get_numSquadre(); i++){
            lista.addElement("- "+ c.getSquadre().get(i-1).getNome());
     
       
        }
        
        
         
      
        
        
    }
    
}
