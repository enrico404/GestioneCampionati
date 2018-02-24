/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionecampionati.grafica.Listener;


import gestionecampionati.Campionato;
import gestionecampionati.Squadra;
import gestionecampionati.grafica.InsSqPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultListModel;

/**
 *
 * @author enrico
 */
public class InsActionListener implements ActionListener {
    
    private Campionato c;
    private InsSqPanel panel;
    private DefaultListModel<String> listmodel;
    public InsActionListener(Campionato c, InsSqPanel panel, DefaultListModel<String> listmodel) {
        this.c = c;
        this.panel = panel;
        this.listmodel = listmodel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        System.out.println("Nome : "+ panel.getTnome().getText());
        System.out.println("Citta: "+ panel.getTcitta().getText());
        Squadra sq = new Squadra(panel.getTnome().getText(), panel.getTcitta().getText());
        
        if(c == null )System.out.print("campionato non inizializzato");
        if(sq == null ) System.out.print("squadra non inizializzata");
        //System.out.println(c.get_numSquadre());
        
        if(!(panel.getTnome().getText().isEmpty())){
            if(!(panel.getTcitta().getText().isEmpty())){
                
                
               c.inserisci_squadra(sq);
               listmodel.addElement("- " + sq.getNome());
               panel.getTnome().setText("");
               panel.getTcitta().setText("");
            }
        }    
        else {//error frame
            
            
            }
        
        
        
    }
    
}
