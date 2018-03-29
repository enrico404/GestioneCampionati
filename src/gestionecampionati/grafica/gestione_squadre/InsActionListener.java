/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionecampionati.grafica.gestione_squadre;


import gestionecampionati.grafica.gestione_squadre.ApriLogoActionListener;
import gestionecampionati.Campionato;
import gestionecampionati.Squadra;
import gestionecampionati.grafica.Errors_Confirm.ErrorPanel;
import gestionecampionati.grafica.gestione_squadre.InsSqPanel;
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
    private ApriLogoActionListener apri;
    public InsActionListener(Campionato c, InsSqPanel panel, DefaultListModel<String> listmodel, ApriLogoActionListener apri) {
        this.c = c;
        this.panel = panel;
        this.listmodel = listmodel;
        this.apri = apri;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        
        
        Squadra sq;
        
    
        
               if(!(apri.getPath().isEmpty())){ 
               
                    sq= new Squadra(panel.getTnome().getText(), panel.getTcitta().getText(), apri.getPath());  
                    apri.setPath("");
               }
               else sq= new Squadra(panel.getTnome().getText(), panel.getTcitta().getText());
        
        if(c == null )System.out.print("campionato non inizializzato");
        if(sq == null ) System.out.print("squadra non inizializzata");
        //System.out.println(c.get_numSquadre());
        
        if(!(panel.getTnome().getText().isEmpty())){
            if(!(panel.getTcitta().getText().isEmpty())){
           
               c.inserisci_squadra(sq);
               listmodel.addElement("- " + sq.getNome());
               
               System.out.println("Nome : "+ sq.getNome());
                 System.out.println("Citta: "+ sq.getCitta());
                 System.out.println("logo: "+ sq.getLogo());
               
               panel.getTnome().setText("");
               panel.getTcitta().setText("");
               
               
               
               
            }
        }    
        else {
            ErrorPanel err = new ErrorPanel(5);
            
            
            }
        
        
        
    }
    
}
