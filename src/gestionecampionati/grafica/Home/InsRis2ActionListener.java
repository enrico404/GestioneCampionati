/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionecampionati.grafica.Home;

import gestionecampionati.Campionato;
import gestionecampionati.grafica.Errors_Confirm.ErrorPanel;
import gestionecampionati.grafica.inserimento_risultati.InsRis.InsRisPanel;
import gestionecampionati.grafica.MainFrame;
import gestionecampionati.grafica.Home.MenuPanel;
import gestionecampionati.grafica.inserimento_risultati.InsRis.InsRisPanel;
import gestionecampionati.grafica.inserimento_risultati.InsRis2.InsRisPanel2;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.JTable;

/**
 *
 * @author Enrico
 */
public class InsRis2ActionListener implements ActionListener{
    private JPanel old;
    private MainFrame f;
    private Campionato c;
    private ErrorPanel err;
    /** riferimento a tabella di gestione calendario, serve per rendere più smart l'inserimento dei risultati */
    private JTable tabella;
    /** variabile che mi indica in quale girone mi trovo */
    private int tipo;
    
    public InsRis2ActionListener( MainFrame f, JPanel old, Campionato c,JTable tabella, int tipo) {
        this.old = old;
        this.f = f;
        this.c = c;
        this.tabella = tabella;
        this.tipo = tipo;
    }

    public InsRis2ActionListener(MainFrame f, JPanel old, Campionato c) {
         this.old = old;
         this.f = f;
         this.c = c;
         this.tipo = 0;
    }
    
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        try{
         if(old.isEnabled() && !(c.getC().getCoppie().isEmpty())){
           
            
            InsRisPanel2 panel = new InsRisPanel2(old, c, f);
          if(tipo != 0){
                if(tipo==1){
                    panel.getPanelUp().getSqa().setSelectedItem(c.getC().getGironeAndata().get(tabella.getSelectedRow()).getCoppia().getA().getNome());
                    panel.getPanelUp().getSqb().setSelectedItem(c.getC().getGironeAndata().get(tabella.getSelectedRow()).getCoppia().getB().getNome());
                }else {
                    panel.getPanelUp().getSqa().setSelectedItem(c.getC().getGironeRitorno().get(tabella.getSelectedRow()).getCoppia().getA().getNome());
                    panel.getPanelUp().getSqb().setSelectedItem(c.getC().getGironeRitorno().get(tabella.getSelectedRow()).getCoppia().getB().getNome());

                }
          }
            
            
            
            f.remove(old);
            old.setEnabled(false);

            f.add(panel);
            f.validate();
         }
        }catch(Exception ex){
        
            err = new ErrorPanel(3);
            System.out.println(ex);

          
        }
    }
    
}
