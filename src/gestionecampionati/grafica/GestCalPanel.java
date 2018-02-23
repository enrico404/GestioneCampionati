/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionecampionati.grafica;

import gestionecampionati.Campionato;
import java.awt.BorderLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author enrico
 */
public class GestCalPanel extends JPanel{
    
    private JButton chiudi;
    private MainFrame f;
    private Campionato c;
    private DefaultListModel<String> listmodel;
    private MenuPanel oldPanel;
    
    
    public GestCalPanel(MainFrame f, Campionato c, DefaultListModel<String> listmodel, MenuPanel oldPanel){
        
        
        this.f = f;
        this.c = c;
        this. listmodel = listmodel;
        this.oldPanel = oldPanel;
        
        this.setLayout(new BorderLayout());
    
         chiudi = new JButton("Chiudi");
         chiudi.setSize(100, 100);
    
        this.add(chiudi, BorderLayout.SOUTH);
    
    
        chiudi.addActionListener(new ChiudiActionListener(f, this, c, listmodel, oldPanel));
    
    
    }

    
}
