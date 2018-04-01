
package gestionecampionati.grafica.gestione_calendario;

import gestionecampionati.Campionato;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.text.View;

/**
 * Pannello "a" centrale della gestione calendario
 * @author Enrico
 */
public class SkPanelCenterSqA extends JPanel {
    private Campionato c;
    private JComboBox sqa; 
    private JLabel lsqa, vs;
    private Dimension d;
    private Font font;
    
    
   /**
    * Costruttore con parametri, prende in input il font con cui scrivere e la struttura dati
    * @param c struttura dati 
    * @param font font scelto 
    */ 
    public SkPanelCenterSqA(Campionato c, Font font) {
        super();
        this.c = c;
        this.font = font;
      
        
        
        d = new Dimension(200 , 30);
        lsqa = new JLabel("Squadra Casa: ");
        vs = new JLabel("VS");
        
        lsqa.setFont(font);
        vs.setFont(font);
        
        sqa = new JComboBox();
        
        sqa.setMaximumSize(d);
        sqa.setMinimumSize(d);
        sqa.setBackground(Color.white);
      
          
            
        
        
        
        
        
        
        
        
        
        
        this.setLayout(new BoxLayout(this, View.X_AXIS));
        
        this.add(lsqa);
        this.add(Box.createRigidArea(new Dimension(20, 0)));
        this.add(sqa);
        this.add(Box.createRigidArea(new Dimension(120, 0)));
        this.add(vs);
        this.add(Box.createRigidArea(new Dimension(120, 0)));
        
        
    }
    
    /**
     * funzione per riempire le combo box dalle squadre partecipanti al campionato
     * @return true in caso di riempimento con successo
     */
    public boolean riempi(){
         
                  for(int i=0; i<c.getSquadre().size(); i++){
                  
                       sqa.addItem(c.getSquadre().get(i).getNome());
                  }
            
            
            return true;
    
    
    }

    public JComboBox getSqa() {
        return sqa;
    }
    
    
    
     @Override
        public void paint(Graphics g){
        super.paint(g);
       
       

        }
    
    
}
