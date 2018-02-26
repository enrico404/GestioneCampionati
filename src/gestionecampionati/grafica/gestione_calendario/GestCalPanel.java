/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionecampionati.grafica.gestione_calendario;

import gestionecampionati.grafica.Listener.GenPActionListeneter;
import gestionecampionati.grafica.Listener.ChiudiActionListener;
import gestionecampionati.Campionato;
import gestionecampionati.grafica.MainFrame;
import gestionecampionati.grafica.MenuPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.Box;
import javax.swing.BoxLayout;
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
    private JButton genP;
    private Dimension dimB;
    public GestCalPanel(MainFrame f, Campionato c, DefaultListModel<String> listmodel, MenuPanel oldPanel){
        
        
        this.f = f;
        this.c = c;
        this. listmodel = listmodel;
        this.oldPanel = oldPanel;
        dimB = new Dimension(200, 50);
       this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    
       chiudi = new JButton("Chiudi");
       chiudi.setMinimumSize(dimB);
       chiudi.setMaximumSize(dimB);
       
       if(c.getC() == null){
           genP = new JButton("Genera partite");
           genP.setMinimumSize(dimB);
           genP.setMaximumSize(dimB);
           
           genP.setAlignmentX(CENTER_ALIGNMENT);
         
           chiudi.setAlignmentX(CENTER_ALIGNMENT);
           
           this.add(Box.createRigidArea(new Dimension(0, 140)));
           this.add(genP);
           this.add(Box.createRigidArea(new Dimension(0, 30)));
           this.add(chiudi);
    
    
           chiudi.addActionListener(new ChiudiActionListener(f, this, c, listmodel, oldPanel));
           genP.addActionListener(new GenPActionListeneter(f, this, c));
           
           
           
       }
       
       
       
    
    }

    
}
