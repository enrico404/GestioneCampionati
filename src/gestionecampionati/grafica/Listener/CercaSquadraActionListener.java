/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionecampionati.grafica.Listener;

import gestionecampionati.Campionato;
import gestionecampionati.grafica.MainFrame;
import gestionecampionati.grafica.gestione_calendario.CercaSqTableModel;
import gestionecampionati.grafica.gestione_calendario.GestCSk;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.text.View;

/**
 *
 * @author Enrico
 */
public class CercaSquadraActionListener implements ActionListener {
    private GestCSk sk;
    private TextField cerca;
    private Campionato c;
    private CercaSqTableModel model;
    private JTable tabella;
    private MainFrame f;

    public CercaSquadraActionListener(TextField cerca, GestCSk sk, Campionato c, MainFrame f) {
        this.sk = sk;
        this.cerca = cerca;
        this.c = c;
        this.f = f;
    }

    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        boolean esiste= false;
        sk.getPanelDown().setLayout(new BoxLayout(sk.getPanelDown(), View.Y_AXIS));
        
        for(int i=0; i<c.get_numSquadre(); i++)
            if(c.getC().getSquadre().get(i).getNome().equals(cerca.getText())) esiste=true;
       
        if( esiste==true){
         
           
            
            model = new CercaSqTableModel(cerca.getText(), c);
            tabella = new JTable(model);
            JScrollPane sc = new JScrollPane(tabella);
            
          
            
            
            sk.getPanelDown().removeAll();
           
            sk.getPanelDown().add(sc);
            
            sk.getPanelDown().revalidate();
            sk.getPanelDown().repaint();
            esiste=false;
        
        
        }else {
            JLabel err = new JLabel("Squadra non trovata!");
            err.setFont(new Font("sans-serif", Font.PLAIN, 16));
            
            
            sk.getPanelDown().removeAll();
            sk.getPanelDown().add(Box.createRigidArea(new Dimension(30, 40)));
            sk.getPanelDown().add(err);
            sk.validate();
            sk.repaint();
        }
        
    }
    
}
