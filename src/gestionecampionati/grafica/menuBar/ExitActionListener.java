
package gestionecampionati.grafica.menuBar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Listener del pulsanti esci della menu bar, se premuto termina il programma
 * @author enrico
 */
public class ExitActionListener implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent e) {
        System.exit(0);
    }
    
}
