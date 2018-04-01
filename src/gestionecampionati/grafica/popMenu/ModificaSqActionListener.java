
package gestionecampionati.grafica.popMenu;

import gestionecampionati.Campionato;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;

/**
 * Listener che si occupa di aprire la finestra fluattuante di modifica del risultato
 * di una giornata specifica 
 * @author Enrico
 */
public class ModificaSqActionListener implements ActionListener{

    private Campionato c;
    private JList lista;
    private DefaultListModel listModel;
    private JFrame modifica;
    private JPanel modSqPanel;

    /**
     * Costruttore del listner di modifca dei risultati
     * @param c struttura dati 
     * @param lista jlist da cui recuperare la giornata 
     * @param listModel  table model da aggiornare
     */
    public ModificaSqActionListener(Campionato c, JList lista, DefaultListModel listModel) {
        this.c = c;
        this.lista = lista;
        this.listModel = listModel;
  
        
    }
  
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        modifica = new JFrame("Modifica squadra");
        modifica.setLocationRelativeTo(null);
        modifica.setSize(new Dimension(300, 250));
        modifica.setVisible(true);
        
        
        modSqPanel = new ModSqPanel(c, lista, listModel, modifica);
        
        
        modifica.add(modSqPanel);
    }
    
}
