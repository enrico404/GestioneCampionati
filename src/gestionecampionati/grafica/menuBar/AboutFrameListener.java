
package gestionecampionati.grafica.menuBar;

import gestionecampionati.grafica.AboutFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Listener della menu bar, che crea il frame about indicante informazioni 
 * riguardo lo sviluppatore del software
 * @author Enrico
 */
public class AboutFrameListener implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent e) {
        AboutFrame frame = new AboutFrame("About");
        frame.setVisible(true);
        
        
    }
    
    
    
}
