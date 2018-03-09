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
import gestionecampionati.grafica.Listener.ChiudiActionListener;
import gestionecampionati.grafica.MainFrame;
import gestionecampionati.grafica.MenuPanel;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;


/**
 *
 * @author enrico
 */
public class SkPanelUp extends JPanel {
   
    private JButton button1;
    private JButton button2, indietro;
    private TextField cerca;
    private Dimension d, d1, d2, d3;
    private MenuPanel menuP;
    private GestCSk sk;
    private MainFrame f;
    
    public SkPanelUp(MenuPanel menuP, GestCSk sk, MainFrame f) {
        super();
        this.menuP = menuP;
        this.sk = sk;
        this.f = f;
        d = new Dimension(150, 40);
        d1 = new Dimension(150, 30);
        d2 = new Dimension(150, 40 );
        d3 = new Dimension(40, 40);
        
        
        
        button1 = new JButton("Calendario completo");
     
        button1.setMaximumSize(d2);
        button1.setMinimumSize(d2);
        
        indietro = new JButton("<");
        
        indietro.setMaximumSize(d3);
        indietro.setMinimumSize(d3);
        
        button2 = new JButton("Cerca");
        
        button2.setMaximumSize(d);
        button2.setMinimumSize(d);
        
        cerca = new TextField("Inserire squadra");
        
        cerca.setMaximumSize(d1);
        cerca.setMinimumSize(d1);
        
        cerca.addFocusListener(new CercaTextFocusListener(cerca));
        indietro.addActionListener(new ChiudiActionListener(f, sk, menuP));
        
        
        this.setLayout(new BoxLayout(this, View.X_AXIS));
        
        this.add(Box.createRigidArea(new Dimension(30, 0)));
        this.add(indietro);
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
       
       

        }
}



