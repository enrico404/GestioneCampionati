/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionecampionati.grafica.inserimento_risultati;

import gestionecampionati.Campionato;
import gestionecampionati.grafica.Errors_Confirm.ErrorPanel;
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
public class InsRisPanelUP extends JPanel{
        private Campionato c;
        private JPanel parent;
        private JComboBox sqa, sqb;
        private JLabel vs,casa,trasferta;
        
    public InsRisPanelUP(Campionato c, JPanel parent) {
        this.c = c;
        this.parent = parent;
        
        
        
        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        
        Dimension d = new Dimension(180 , 30);
        Font font =  new Font("sans-serif", Font.PLAIN, 14);
        vs = new JLabel("VS");
        casa = new JLabel("Casa: ");
        trasferta = new JLabel("Trasferta: ");
        vs.setFont(font);
        casa.setFont(font);
        trasferta.setFont(font);
        
        
        
        
        sqa = new JComboBox();
        sqb = new JComboBox();
        
        sqa.setMaximumSize(d);
        sqa.setMinimumSize(d);
        sqa.setBackground(Color.white);
        
        sqb.setMaximumSize(d);
        sqb.setMinimumSize(d);
        sqb.setBackground(Color.white);
    
        riempi();
       
       
        sqb.setSelectedIndex(1);

        this.add(casa);
        this.add(Box.createRigidArea(new Dimension(20, 0)));
        this.add(sqa);
        this.add(Box.createRigidArea(new Dimension(40, 0)));
        this.add(vs);
        this.add(Box.createRigidArea(new Dimension(40, 0)));
        this.add(trasferta);
        this.add(Box.createRigidArea(new Dimension(20, 0)));
        this.add(sqb);
        
     
        
        
    }
    
    public boolean riempi(){
        
        for(int i=0; i<c.getSquadre().size(); i++){
                  
                       sqa.addItem(c.getSquadre().get(i).getNome());
                       sqb.addItem(c.getSquadre().get(i).getNome());
                  }
            
        
        
    
        return true;
    }

    public JComboBox getSqa() {
        return sqa;
    }

    public void setSqa(JComboBox sqa) {
        this.sqa = sqa;
    }

    public JComboBox getSqb() {
        return sqb;
    }

    public void setSqb(JComboBox sqb) {
        this.sqb = sqb;
    }
    
    
    
    
      @Override
        public void paint(Graphics g){
        super.paint(g);

        }
    
}
