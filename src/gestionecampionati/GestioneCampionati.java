
package gestionecampionati;

import gestionecampionati.grafica.Home.HomePanel;
import gestionecampionati.grafica.MainFrame;
import gestionecampionati.grafica.Home.MainPanel;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;


/**
 * Classe main del sotware. Nel progetto sono state usate strutture dati del tipo
* ArrayList poichè non vengono utilizzati thread aggiuntivi che accedono alle stesse aree di memoria
* e che i metodi siano quindi synchronized. Si è preferita quindi utilizzare una struttura dati 
* non thread-safe, ma con maggiori performance.
 * @author enrico
 */
public class GestioneCampionati {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MainFrame f = new MainFrame("Gestione Campionati");
      
        HomePanel p = new HomePanel(f);
  
        f.add(p); 
        f.setVisible(true);      

    }


    
}
