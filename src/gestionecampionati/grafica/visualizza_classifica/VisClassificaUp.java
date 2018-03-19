/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionecampionati.grafica.visualizza_classifica;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.text.View;

/**
 *
 * @author enrico
 */
public class VisClassificaUp extends JPanel{

    private JLabel primo,secondo,terzo;
    
    public VisClassificaUp() {
        primo = new JLabel("1º"); // altgr+shift+m per i gradi 
        secondo = new JLabel("2º");
        terzo = new JLabel("3º");
        
        Font font  = new Font("sans-serif", Font.BOLD, 22);
        
        primo.setFont(font);
        secondo.setFont(font);
        terzo.setFont(font);
        
        this.setLayout(new BoxLayout(this, View.X_AXIS));
        
        this.add(Box.createRigidArea(new Dimension(0, 40)));
        this.add(primo);
        this.add(Box.createRigidArea(new Dimension(260, 0)));
        this.add(secondo);
        this.add(Box.createRigidArea(new Dimension(260, 0)));
        this.add(terzo);
        
        
    }
    
    
    
     @Override
        public void paint(Graphics g){
        super.paint(g);

        }
    
}
