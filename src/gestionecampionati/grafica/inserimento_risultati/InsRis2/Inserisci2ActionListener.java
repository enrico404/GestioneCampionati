
package gestionecampionati.grafica.inserimento_risultati.InsRis2;

import gestionecampionati.Campionato;
import gestionecampionati.Partita;
import gestionecampionati.Punteggio;
import gestionecampionati.Squadra;
import gestionecampionati.grafica.Errors_Confirm.ConfirmPanel;
import gestionecampionati.grafica.Errors_Confirm.ErrorPanel;
import gestionecampionati.grafica.MainFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Listener del bottone inserisci appartente alla seconda visualizzazione di inserimento 
 * dei risultati. Recupera dai pannelli i dati inseriti e li inserisce all'interno della struttura dati
 * @author Enrico
 */
public class Inserisci2ActionListener implements ActionListener{
    
    
    private Campionato c;
    private JPanel[] center;
    private JLabel sq1, sq2;
    private ErrorPanel err;
    private ConfirmPanel confirm;
    private Partita par;
    private Punteggio p;
    private JComboBox[] ris;
    private InsRisPanel2 old;
    private InsSetParzialiPanel nuovo;
    private MainFrame f;

    /**
     * Costruttore con parametri del listener, inserisce il numero di set vinti di ogni squadra nella struttura dati e 
     * va a calcolare il risultato finale della partita e lo inserisce anch'esso nella struttura dati
     * @param c struttura dati pricipale
     * @param center array dei set disputati dalle due squadre
     * @param sq1 prima squadra contendente
     * @param sq2 seconda squadre contendente
     * @param ris array dei risultati inseriti dall'utente
     * @param old pannello vecchio utile per tornare alla schermata di inserimento dei risultati
     * @param nuovo pannello da sostituire con il pannello vecchio una volta inserito il risultato all'interno del campionato
     * @param f  frame in cui inserire e rimuovere i vari pannelli
     */
    public Inserisci2ActionListener(Campionato c, JPanel[] center, JLabel sq1, JLabel sq2, JComboBox[] ris,  InsRisPanel2 old, InsSetParzialiPanel nuovo, MainFrame f) {
        this.c = c;
        this.center = center;
        this.sq1 = sq1;
        this.sq2 = sq2;
        this.ris = ris;
        this.old = old;
        this.nuovo = nuovo;
        this.f = f;
    }

   
    

    @Override
    public void actionPerformed(ActionEvent e) {
        
        String sqa, sqb;
        Squadra a,b;
        
        sqa = sq1.getText();
        sqb = sq2.getText();
        int puntA =0;
        int puntB = 0;
        int tmp1,tmp2;
        
        par = new Partita();
        
        int j=0;
        for(int i=0;i<center.length; i++){
            tmp1 = ris[j++].getSelectedIndex();
            tmp2 = ris[j++].getSelectedIndex();
            if(tmp1>tmp2) puntA++; 
            else puntB++;
        par.getRis_intermedi().add(new Punteggio(tmp1,tmp2));
        
        }
        
         
        p = new Punteggio(puntA, puntB);
        
        /** le due squadre devono essere differenti */
        if(!(sqa.equals(sqb))){
                    for(int i= 0; i< c.getC().getGironeAndata().size(); i++){
                        if(sqa.equals(c.getC().getGironeAndata().get(i).getCoppia().getA().getNome()) && sqb.equals(c.getC().getGironeAndata().get(i).getCoppia().getB().getNome())){
                            par.setCoppia(c.getC().getGironeAndata().get(i).getCoppia());
                            c.getC().getGironeAndata().get(i).setP(p);
                            c.getC().getGironeAndata().get(i).setGiocata(true);
                            

                        }

                    }
                     for(int i= 0; i< c.getC().getGironeRitorno().size(); i++){
                        if(sqa.equals(c.getC().getGironeRitorno().get(i).getCoppia().getA().getNome()) && sqb.equals(c.getC().getGironeRitorno().get(i).getCoppia().getB().getNome())){
                           par.setCoppia(c.getC().getGironeRitorno().get(i).getCoppia());
                            c.getC().getGironeRitorno().get(i).setP(p);
                            c.getC().getGironeRitorno().get(i).setGiocata(true);
                         
                                
                        }

                    }

                    
                    confirm = new ConfirmPanel(1);
                    old.setEnabled(true);
                    nuovo.setEnabled(false);
                    f.remove(nuovo);
                    f.add(old);
                    f.validate();
                    f.repaint();
                    

                }else {
                    err = new ErrorPanel(4);
            
                    }
        
        
        
    }
    
}
