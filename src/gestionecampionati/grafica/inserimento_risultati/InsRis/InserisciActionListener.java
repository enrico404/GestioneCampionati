/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionecampionati.grafica.inserimento_risultati.InsRis;

import gestionecampionati.Campionato;
import gestionecampionati.Partita;
import gestionecampionati.Punteggio;
import gestionecampionati.Squadra;
import gestionecampionati.grafica.Errors_Confirm.ConfirmPanel;
import gestionecampionati.grafica.Errors_Confirm.ErrorPanel;
import gestionecampionati.grafica.MainFrame;
import gestionecampionati.grafica.inserimento_risultati.InsRis.InsRisPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Listener del bottone inserisci della funzionalità di inserimento dei risultati
 * @author Enrico
 */
public class InserisciActionListener implements ActionListener {
    
    private Campionato c;
    private InsRisPanel parent;
    private Partita par;
    private Punteggio p;
    private ErrorPanel err;
    private ConfirmPanel confirm;
    private MainFrame f;
    

    /**
     * Costruttore con parametri del listener, prende in input il riferimento
     * al campionato e il pannello scheletro "inserimento risulati
     * @param c struttura dati in cui inserire il nuuovo risultato
     * @param parent pannello scheletro da cui recuperare le due square contendenti 
     * selezionate dall'utente
     */
    public InserisciActionListener(Campionato c, InsRisPanel parent) {
        this.c = c;
        this.parent = parent;
      

    }
    

    @Override
    public void actionPerformed(ActionEvent e) {
        String sqa, sqb;
        Squadra a,b;
        
        sqa = parent.getPanelUp().getSqa().getSelectedItem().toString();
        sqb = parent.getPanelUp().getSqb().getSelectedItem().toString();
        int puntA = parent.getPanelCenter().getPa().getSelectedIndex();
        int puntB =  parent.getPanelCenter().getPb().getSelectedIndex();
         
        p = new Punteggio(puntA, puntB);
        
        /** le due squadre devono essere differenti */
        if(!(sqa.equals(sqb))){
                    for(int i= 0; i< c.getC().getGironeAndata().size(); i++){
                        if(sqa.equals(c.getC().getGironeAndata().get(i).getCoppia().getA().getNome()) && sqb.equals(c.getC().getGironeAndata().get(i).getCoppia().getB().getNome())){
                            par = new Partita(c.getC().getGironeAndata().get(i).getCoppia());
                            c.getC().getGironeAndata().get(i).setP(p);
                            c.getC().getGironeAndata().get(i).setGiocata(true);
                            
                        }

                    }
                     for(int i= 0; i< c.getC().getGironeRitorno().size(); i++){
                        if(sqa.equals(c.getC().getGironeRitorno().get(i).getCoppia().getA().getNome()) && sqb.equals(c.getC().getGironeRitorno().get(i).getCoppia().getB().getNome())){
                            par = new Partita(c.getC().getGironeRitorno().get(i).getCoppia());
                            c.getC().getGironeRitorno().get(i).setP(p);
                            c.getC().getGironeRitorno().get(i).setGiocata(true);
                        }

                    }

                    
                    confirm = new ConfirmPanel(1);

                }else {
                    err = new ErrorPanel(4);
            
                    }
    }
}
