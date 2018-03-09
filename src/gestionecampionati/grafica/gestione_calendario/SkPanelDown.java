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
 * @author enrico.
 */
public class SkPanelDown extends JPanel{
    
   
    private Campionato c;
    private CalTableModel tab1;
    private Cal2TableModel tab2;
    private JTable tabella;
    private JTable tabella2;
    private JLabel gironeAnd;
    private JLabel gironeRit;
    private JScrollPane panelloScroll;
    private JScrollPane panelloScroll2;
  

    public SkPanelDown(Campionato c) {
        super();
        tab1 = new CalTableModel(c);
        tab2 = new Cal2TableModel(c);
        Font font = new Font("sans-serif", Font.BOLD, 16);
        
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

    public CalTableModel getTab1() {
        return tab1;
    }

    public void setTab1(CalTableModel tab1) {
        this.tab1 = tab1;
    }

    public Cal2TableModel getTab2() {
        return tab2;
    }

    public void setTab2(Cal2TableModel tab2) {
        this.tab2 = tab2;
    }

    public JTable getTabella() {
        return tabella;
    }

    public void setTabella(JTable tabella) {
        this.tabella = tabella;
    }

    public JTable getTabella2() {
        return tabella2;
    }

    public void setTabella2(JTable tabella2) {
        this.tabella2 = tabella2;
    }

    public JLabel getGironeAnd() {
        return gironeAnd;
    }

    public void setGironeAnd(JLabel gironeAnd) {
        this.gironeAnd = gironeAnd;
    }

    public JLabel getGironeRit() {
        return gironeRit;
    }

    public void setGironeRit(JLabel gironeRit) {
        this.gironeRit = gironeRit;
    }

    public JScrollPane getPanelloScroll() {
        return panelloScroll;
    }

    public void setPanelloScroll(JScrollPane panelloScroll) {
        this.panelloScroll = panelloScroll;
    }

    public JScrollPane getPanelloScroll2() {
        return panelloScroll2;
    }

    public void setPanelloScroll2(JScrollPane panelloScroll2) {
        this.panelloScroll2 = panelloScroll2;
    }
    
       @Override
        public void paint(Graphics g){
        super.paint(g);
        

        }
    
}
