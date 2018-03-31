
package gestionecampionati.grafica.Home;

import gestionecampionati.Campionato;
import gestionecampionati.grafica.Errors_Confirm.ErrorPanel;
import gestionecampionati.grafica.MainFrame;
import gestionecampionati.grafica.inserimento_risultati.InsRis2.InsRisPanel2;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.JTable;

/**
 * Listener utile per l'inserimento dei risultati nello sport della pallavolo
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
    
    /** 
     * Primo costruttore con parametri, oltre ad inserire il pannello all'interno del frame, setta le due squadre 
     * contenenti in base alla riga selezionata nella tabella di gestione calendario
     * @param f frame in cui inserire il pannello
     * @param old vecchio pannello da rimuovere
     * @param c Struttura dati da passare al nuovo pannello 
     * @param tabella tabella appartenente al pannello di gestione del calendario, serve per recuparare la riga e quindi le due squadre contendenti
     * @param tipo in base al valore so in quale girone mi trovo
     */
    public InsRis2ActionListener( MainFrame f, JPanel old, Campionato c,JTable tabella, int tipo) {
        this.old = old;
        this.f = f;
        this.c = c;
        this.tabella = tabella;
        this.tipo = tipo;
    }
    
/**
 *  Secondo costruttore con parametri, che si occupa di inserire il pannello di inserimento dei risultati all'interno del frame
 * @param f frame in cui inserire il pannello
 * @param old vecchio pannello da rimuovere
 * @param c struttura dati da passare al nuovo pannello
 */
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
