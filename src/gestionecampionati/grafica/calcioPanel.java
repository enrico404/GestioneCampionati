/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionecampionati.grafica;
import java.awt.BorderLayout;
import java.awt.Graphics;
import javax.swing.*;
/**
 *
 * @author enrico
 */
public class calcioPanel extends JPanel {

    private MyFrame f;
    private JButton button;
    private MenuBar menu;
    
    public calcioPanel(MyFrame f) {
        super();

        menu = new MenuBar();
        this.f = f;
        
        this.setLayout(new BorderLayout());
        
        this.add(menu, BorderLayout.PAGE_START);
        
        
 

        
        
        
    }
   
     @Override
        public void paint(Graphics g){
        super.paint(g);
       
        
        }
    
    
    
    
}
