/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionecampionati.grafica.inserimento_risultati.InsRis2;

import gestionecampionati.Campionato;
import gestionecampionati.grafica.MainFrame;
import gestionecampionati.grafica.inserimento_risultati.InsRis.InsRisPanelUP;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.text.View;

/**
 *
 * @author Enrico
 */
public class InsSetParzialiPanel extends JPanel{
  
    private JLabel[] set;
    private JComboBox[] ris;
    private InsRisPanelUP panelUp;
    private JComboBox num_set;
    private JLabel sq1,sq2;
    private JButton inserisci;
    private int n;
    private JPanel menu;
    private Campionato c;
    private InsRisPanel2 old;
    private MainFrame f;
    
    public InsSetParzialiPanel(Campionato c, InsRisPanelUP panelUp, JComboBox num_set,  InsRisPanel2 old, MainFrame f) {
       
        Font font =  new Font("sans-serif", Font.PLAIN, 18);
        this.old =old;
        this.c = c;
        this.f = f;
        this.num_set = num_set;
        this.panelUp = panelUp;
        this.setLayout(new BoxLayout(this, View.Y_AXIS));
        
        n = this.num_set.getSelectedIndex()+1;
        set = new JLabel[n];
        ris = new JComboBox[n*2];
        
        JPanel[] center = new JPanel[n];
        
        inserisci = new JButton("Inserisci");
        
        inserisci.setMaximumSize(new Dimension(100,40));
        inserisci.setMinimumSize(new Dimension(100,40));
        inserisci.setAlignmentX(CENTER_ALIGNMENT);
        
        
       
        
        
        sq1 = new JLabel(panelUp.getSqa().getSelectedItem().toString());
        sq2 = new JLabel(panelUp.getSqb().getSelectedItem().toString());
        
        sq1.setFont(font);
        sq2.setFont(font);
        
        riempi();
        
        JPanel up = new JPanel();
        up.setLayout(new BoxLayout(up, View.X_AXIS));
        up.add(sq1);
        up.add(Box.createRigidArea(new Dimension(120, 0)));     
        up.add(sq2);
        
        inserisci.addActionListener(new Inserisci2ActionListener(c, center, sq1, sq2, ris, old, this, f));
        
        this.add(Box.createRigidArea(new Dimension(0, 100))); 
        this.add(up);
        this.add(Box.createRigidArea(new Dimension(0, 50)));
        
        
      

        int j=0;
        for(int i=0; i<n; i++){
            center[i] = new JPanel();
            center[i].setLayout(new BoxLayout(center[i], View.X_AXIS));
            set[i] = new JLabel("Set "+ (i+1));
            center[i].add(set[i]);
            center[i].add(Box.createRigidArea(new Dimension(50, 20)));
            center[i].add(ris[j++]);
            center[i].add(Box.createRigidArea(new Dimension(50, 0)));
            center[i].add(ris[j++]);
          
             
            this.add(center[i]);
            this.add(Box.createRigidArea(new Dimension(0, 40)));
        }
       
        this.add(Box.createRigidArea(new Dimension(0, 50)));
        this.add(inserisci);
        
        
    }
    
    
    
    
    public void riempi(){
          for(int i=0; i<n*2; i++){
              ris[i] = new JComboBox();
              ris[i].setMaximumSize(new Dimension(50 , 30));
              ris[i].setMinimumSize(new Dimension(50 , 30));
              ris[i].setBackground(Color.white);
                  for(int j=0; j< 40; j++){
                      
                       ris[i].addItem(j);
                  }
          }
   
    }
    
     @Override
        public void paint(Graphics g){
        super.paint(g);

        }
    
}
