
package gestionecampionati.grafica.popMenu;

import gestionecampionati.Campionato;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

/**
 * Listener di "inserisci" del pop menu visualizzato all'interno del pannello
 * gestione calendario
 * @author Enrico
 */
public class InsPopActionListener implements ActionListener {

   
    private JTable tabella;
    private Campionato c;
    private JFrame f;
    private AbstractTableModel tab;
    /** variabile che indica in quale girone mi trovo */
    private int tipo;
   
    /**
     * Costruttore, prende in input la tabella da cui recuperare la riga selezionata
     * il campionato da modificare e la table model da aggiornare
     * @param tabella  jtable da cui recupare le due squadre contendenti
     * @param c struttura dati in cui inserire i risultati 
     * @param tipo variabile che indica il tipo di girone in cui mi trovo
     * @param tab tablemodel da modificare
     */
    public InsPopActionListener(JTable tabella, Campionato c, int tipo, AbstractTableModel tab) {
        this.tipo = tipo;
        this.tabella = tabella;
        this.c = c;
        this.tab = tab;
        
        
         
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        f= new JFrame("Inserisci risultato");
        f.setLocationRelativeTo(null);
        f.setSize(new Dimension(280, 180));
        f.setVisible(true);
        InsRisPop ris = new InsRisPop(f, tipo, c, tabella,tab);
        f.add(ris);
      
    }
    
}
