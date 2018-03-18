
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionecampionati.grafica;

import gestionecampionati.grafica.Listener.VisualizzaClassificaActionListener;
import gestionecampionati.grafica.Listener.InsRisActionListener;
import gestionecampionati.grafica.Listener.GestCalActionListener;
import gestionecampionati.grafica.Listener.InsSqActionLitener;
import gestionecampionati.Campionato;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author enrico
 */
public class MenuPanel extends JPanel {
   private JButton gestCal; 
   private JButton insRis;
   private JButton visClass;
   private JButton insSq;
   private MainFrame f;
   private Campionato c;
   private DefaultListModel<String> listmodel;
   private Dimension button;
   
   
   public MenuPanel(MainFrame f, Campionato c, DefaultListModel<String> listmodel){
       super();
       this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
       
       this.listmodel = listmodel;
       this.c = c;
       this.f = f;
       
       button = new Dimension(200, 50);
            gestCal = new JButton("Gestione calendario");
            insRis = new JButton("Inserisci risultati");
            insSq = new JButton("Inserisci squadre");
            visClass = new JButton("Visualizza classifica");
       
            gestCal.setAlignmentX(CENTER_ALIGNMENT);
            gestCal.setPreferredSize(button);
            gestCal.setMaximumSize(button);
            gestCal.setMinimumSize(button);
            insRis.setAlignmentX(CENTER_ALIGNMENT);
            insRis.setPreferredSize(button);
            insRis.setMaximumSize(button);
            insRis.setMinimumSize(button);
            visClass.setAlignmentX(CENTER_ALIGNMENT);
            visClass.setPreferredSize(button);
            visClass.setMinimumSize(button);
            visClass.setMaximumSize(button);
            insSq.setAlignmentX(CENTER_ALIGNMENT);
            insSq.setPreferredSize(button);
            insSq.setMaximumSize(button);
            
            
            add(Box.createRigidArea(new Dimension(0, 100)));
            add(insSq);
            add(Box.createRigidArea(new Dimension(0, 20)));
            add(gestCal);
            add(Box.createRigidArea(new Dimension(0, 20)));
            add(insRis);
            add(Box.createRigidArea(new Dimension(0, 20)));
            add(visClass);
            
            
            insSq.addActionListener(new InsSqActionLitener(f, this, c, listmodel));
            gestCal.addActionListener(new GestCalActionListener(f, this, c));
            insRis.addActionListener(new InsRisActionListener(f,this,c));
            visClass.addActionListener(new VisualizzaClassificaActionListener(c,this,f));
   
   
   }
      @Override
        public void paint(Graphics g){
        super.paint(g);
   
       

        }
    
    
    
}
