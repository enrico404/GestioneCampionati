/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionecampionati.grafica.inserimento_risultati.InsRis;

import gestionecampionati.Campionato;
import gestionecampionati.grafica.ChiudiActionListener;
import gestionecampionati.grafica.MainFrame;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.text.View;

/**
 *
 * @author Enrico
 */
public class InsRisPanelDown extends JPanel{
    private Campionato c;
    private InsRisPanel parent;
    private JButton inserisci, chiudi;
    private JPanel menu;
    MainFrame f;

    
    

    public InsRisPanelDown(Campionato c, InsRisPanel parent, JPanel menu, MainFrame f) {
        super();
        this.c = c;
        this.parent = parent;
        this.menu = menu;
        this.f = f;
        
        JLabel vs = new JLabel("-");
        
        
        this.setLayout(new BoxLayout(this, View.X_AXIS));
        
        Dimension d = new Dimension(160 , 35);
        
        
        inserisci = new JButton("Inserisci");
        chiudi = new JButton("Chiudi");
        
        inserisci.setMaximumSize(d);
        inserisci.setMinimumSize(d);
        chiudi.setMaximumSize(d);
        chiudi.setMinimumSize(d);
        
        
        
       
        
        this.add(chiudi);
        this.add(Box.createRigidArea(new Dimension(10, 0)));
        this.add(inserisci);
        
        
        chiudi.addActionListener(new ChiudiActionListener(f, parent, menu));
        inserisci.addActionListener(new InserisciActionListener(c, parent));
        
        
    }
    
    
    
    
    @Override
        public void paint(Graphics g){
        super.paint(g);

        }
}
