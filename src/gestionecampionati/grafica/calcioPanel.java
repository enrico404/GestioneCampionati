/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionecampionati.grafica;
import gestionecampionati.Calendario;
import gestionecampionati.Campionato;
import gestionecampionati.Squadra;
import java.awt.BorderLayout;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.*;
/**
 *
 * @author enrico
 */
public class calcioPanel extends JPanel {

    private MyFrame f;
    private JButton button;
    private MenuBar menu;
    private Campionato c;
    
    public calcioPanel(MyFrame f) {
        super();
        
 
        
        c = new Campionato("calcio");
        menu = new MenuBar(c, f);
        this.f = f;
        
        this.setLayout(new BorderLayout());
        
        this.add(menu, BorderLayout.PAGE_START);
        
          
 

        
        
        
    }
   
     @Override
        public void paint(Graphics g){
        super.paint(g);
       
        
        }
    
    
    
    
}
