
package gestionecampionati.grafica.visualizza_classifica;

import gestionecampionati.Campionato;
import gestionecampionati.grafica.Errors_Confirm.ErrorPanel;
import gestionecampionati.grafica.MainFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;


/**
 * Listener del bottone visualizza classifica, se tutte le partite sono state giocate
 * allora viene generata dinamicamente la classifica
 * @author Enrico
 */
public class VisualizzaClassificaActionListener implements ActionListener {
    private Campionato c;
    private JPanel old;
    private MainFrame f;
    private ErrorPanel err;
    private VisClassificaSk panel;
    
    /**
     * Costruttore del listener che recupera i vari dati
     * @param c struttura dati principale
     * @param old pannello men, utile per tornare indietro
     * @param f  frame in cui inserire i vari pannelli
     */
    public VisualizzaClassificaActionListener(Campionato c, JPanel old, MainFrame f) {
        this.c = c;
        this.old = old;
        this.f = f;
    }
    
    
   
    @Override
    public void actionPerformed(ActionEvent e) {
        
        
        try{
         if(old.isEnabled() && !(c.getC().getCoppie().isEmpty())){
           
            for(int i=0; i<c.getC().getGironeAndata().size(); i++){
                if(!(c.getC().getGironeAndata().get(i).isGiocata())){
                    //alcune partite non ancora giocate
                    err = new ErrorPanel(7);
                    return;
                } 
            } 
            for(int i=0; i<c.getC().getGironeRitorno().size(); i++){
                if(!(c.getC().getGironeRitorno().get(i).isGiocata())){
                    //alcune partite non ancora giocate
                    err = new ErrorPanel(7);
                    return;
                } 
            } 
        
            c.calcola_calssifica();
    
            panel = new VisClassificaSk(c, old, f);
             
    
            f.remove(old);
            old.setEnabled(false);
    
            f.add(panel);
            f.validate();
         }
        }catch(Exception ex){
           
            err = new ErrorPanel(3);
             
        }
        
    }

    
    
    
}
