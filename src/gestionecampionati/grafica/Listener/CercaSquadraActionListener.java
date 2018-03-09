/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionecampionati.grafica.Listener;

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

/**
 *
 * @author Enrico
 */
public class CercaSquadraActionListener implements ActionListener {
    private GestCSk sk;
    private TextField cerca;

    public CercaSquadraActionListener(TextField cerca, GestCSk sk) {
        this.sk = sk;
        this.cerca = cerca;
    }

    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        sk.getPanelDown().setLayout(new FlowLayout(FlowLayout.LEFT));
        if(!(cerca.getText().equals("Inserire squadra"))){
        
        
        
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
