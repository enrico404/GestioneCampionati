/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionecampionati.grafica.Listener.popMenu;

import gestionecampionati.Campionato;
import gestionecampionati.grafica.inserimento_ris_pop.InsRisPop;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Enrico
 */
public class InsPopActionListener implements ActionListener {

   
    private JTable tabella;
    private Campionato c;
    private JFrame f;
    private AbstractTableModel tab;
    /** variabile che indica in quale girone mi trovo */
    private int tipo;
   

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
