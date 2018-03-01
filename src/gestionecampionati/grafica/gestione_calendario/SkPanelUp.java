/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionecampionati.grafica.gestione_calendario;


import java.awt.Dimension;
import java.awt.TextField;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.text.View;
import gestionecampionati.grafica.Listener.CercaTextFocusListener;
import java.awt.Graphics;


/**
 *
 * @author enrico
 */
public class SkPanelUp extends JPanel {
   
    private JButton button1;
    private JButton button2;
    private TextField cerca;
    private Dimension d, d1, d2;
    
    
    public SkPanelUp() {
        super();
        
        d = new Dimension(300, 40);
        d1 = new Dimension(300, 30);
        d2 = new Dimension(300, 40 );
        
        button1 = new JButton("Calendario completo");
        
        button1.setMaximumSize(d2);
        button1.setMinimumSize(d2);
        
        
        button2 = new JButton("Cerca");
        
        button2.setMaximumSize(d);
        button2.setMinimumSize(d);
        
        cerca = new TextField("Inserire squadra");
        
        cerca.setMaximumSize(d1);
        cerca.setMinimumSize(d1);
        
        cerca.addFocusListener(new CercaTextFocusListener(cerca));
        
        
        
        this.setLayout(new BoxLayout(this, View.X_AXIS));
        
       
        
        this.add(Box.createRigidArea(new Dimension(30, 0)));
        this.add(button1);
        this.add(Box.createHorizontalGlue());
        this.add(cerca);
        this.add(Box.createRigidArea(new Dimension(30, 40)));
        this.add(button2);
        this.add(Box.createRigidArea(new Dimension(20, 40)));
        
    }
    
       @Override
        public void paint(Graphics g){
        super.paint(g);
        repaint();
       

        }
}



