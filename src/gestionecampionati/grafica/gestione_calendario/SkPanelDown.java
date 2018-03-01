/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionecampionati.grafica.gestione_calendario;

import gestionecampionati.Campionato;
import gestionecampionati.grafica.MainFrame;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.text.View;

/**
 *
 * @author enrico
 */
public class SkPanelDown extends JPanel{
    
    private MainFrame f;
    private Campionato c;
    private CalTableModel tab1;
    private Cal2TableModel tab2;
    private JTable tabella;
    private JTable tabella2;
    private JLabel gironeAnd;
    private JLabel gironeRit;
    private JScrollPane panelloScroll;
    private JScrollPane panelloScroll2;
  

    SkPanelDown(MainFrame f, Campionato c) {
        super();
        tab1 = new CalTableModel(c);
        tab2 = new Cal2TableModel(c);
        Font font = new Font("sans-serif", Font.BOLD, 18);
        
        gironeAnd = new JLabel("Girone Andata: ");
        gironeAnd.setFont(font);
       
        
        
        gironeRit = new JLabel("Girone Ritorno: ");
        gironeRit.setFont(font);
        
        
        
        this.setLayout(new BoxLayout(this, View.Y_AXIS));
        
        tabella = new JTable(tab1);
        tabella2 = new JTable(tab2);
        
        panelloScroll = new JScrollPane(tabella);
        panelloScroll2 = new JScrollPane(tabella2);
        
        
        
  
        this.add(Box.createRigidArea(new Dimension(0, 40)));
        this.add(gironeAnd);
        this.add(Box.createRigidArea(new Dimension(0, 40)));
        this.add(panelloScroll);
        this.add(Box.createRigidArea(new Dimension(0, 40)));
        this.add(gironeRit);
        this.add(Box.createRigidArea(new Dimension(0, 40)));
        this.add(panelloScroll2);
        
    }
       @Override
        public void paint(Graphics g){
        super.paint(g);
        repaint();
       

        }
    
}
