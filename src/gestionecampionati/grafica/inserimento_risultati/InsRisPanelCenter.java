/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionecampionati.grafica.inserimento_risultati;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Enrico
 */
public class InsRisPanelCenter extends JPanel{
    private JComboBox pa,pb;
    

    public InsRisPanelCenter() {
        
        
        Dimension d = new Dimension(50 , 30);
        
        
        pa = new JComboBox();
        pb = new JComboBox();
        
        pa.setMaximumSize(d);
        pa.setMinimumSize(d);
        pa.setBackground(Color.white);
        
        pb.setMaximumSize(d);
        pb.setMinimumSize(d);
        pb.setBackground(Color.white);
        
        pa.setAlignmentX(CENTER_ALIGNMENT);
        pb.setAlignmentX(CENTER_ALIGNMENT);
        riempi();
   
        JLabel vs = new JLabel("-");
        Font f =  new Font("sans-serif", Font.PLAIN, 18);

        vs.setFont(f);
        
        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        
        this.add(pa);
        this.add(Box.createRigidArea(new Dimension(70, 0)));
        this.add(vs);
        this.add(Box.createRigidArea(new Dimension(70, 0)));
        this.add(pb);
        
        
        
        
    }
    
    
    public boolean riempi(){
        for(int i=0; i<50; i++){
            pa.addItem(i);
            pb.addItem(i);
        
        }
    
    
        return true;
    }

    public JComboBox getPa() {
        return pa;
    }

    public void setPa(JComboBox pa) {
        this.pa = pa;
    }

    public JComboBox getPb() {
        return pb;
    }

    public void setPb(JComboBox pb) {
        this.pb = pb;
    }
    
    
    
     @Override
        public void paint(Graphics g){
        super.paint(g);

        }
}
