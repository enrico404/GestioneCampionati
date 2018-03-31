
package gestionecampionati.grafica;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;

/**
 *  Listener dei bottoni che permettono di tornare al menu principale
 * @author enrico
 */
public class ChiudiActionListener implements ActionListener {

    private MainFrame f;
    private JPanel old;
    private JPanel nuovo;
    
    /**
     * Costruttore con parametri 
     * @param f frame principale
     * @param old pannello da sostituire
     * @param nuovo  nuovo pannello 
     */
    public ChiudiActionListener(MainFrame f, JPanel old, JPanel nuovo) {
        this.old = old;
        this.f = f;
      
        this.nuovo = nuovo;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        nuovo.setEnabled(true);
        f.remove(old);
        f.add(nuovo);
        f.validate();
        f.repaint();
        
    }
    
}
