/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
 *
 * @author Enrico
 */
public class ModificaSqActionListener implements ActionListener{

    private Campionato c;
    private JList lista;
    private DefaultListModel listModel;
    private JFrame modifica;
    private JPanel modSqPanel;

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
