
package gestionecampionati.grafica.gestione_calendario;

import gestionecampionati.Calendario;
import gestionecampionati.Campionato;
import gestionecampionati.grafica.Errors_Confirm.ErrorPanel;
import gestionecampionati.grafica.MainFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;

/**
 * Listener del bottone genera partite. Al click vado a generare in modo casuale 
 * l'intero calendario
 * @author enrico
 */
public class GenPActionListener implements ActionListener {
    private MainFrame f;
    private GestCalPanel oldPanel;
    private Campionato c;
    private ErrorPanel error;
    private Calendario cal;
    private GestCSk panel;
    private JPanel menuP;
    
/**
 * Costruttore con parametri del listener, in cui si recuperano i vari dati
 * @param f frame in cui inserire i pannelli
 * @param oldPanel pannello da sostituire 
 * @param c struttura dati da cui prendere le squadre
 * @param menuP  pannello menu centrale
 */
    public GenPActionListener(MainFrame f, GestCalPanel oldPanel, Campionato c, JPanel menuP) {
        this.f = f;
        this.oldPanel = oldPanel;
        this.c = c;
        this.menuP = menuP;
        
        
    }
    
    

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(c.get_numSquadre() >= 2){
            
          
            
            cal = new Calendario(c.getSquadre());
            cal.genera_calendario();
            c.setC(cal);
            
            c.getC().stampa_calendario();
            System.out.println("Calendario generato correttamente");
        
            sostituisci(); //cambio panel
        
        }
        else  error = new ErrorPanel(6);
        
        
    }
    
    /**
     *  Metodo che sostituisce il pannello corrente con quello per la visualizzazione
     * del calendario
     * @return true se la sostituzione è avvenuta con successo 
     */
    public boolean sostituisci(){
        
        panel = new GestCSk(f,c, menuP);
        f.remove(this.oldPanel);

        f.add(panel);
        f.validate();
        f.repaint();
    
        return true;
    }
            
       
    
}
