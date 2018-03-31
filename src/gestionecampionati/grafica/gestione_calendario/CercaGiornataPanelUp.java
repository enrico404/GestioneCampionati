
package gestionecampionati.grafica.gestione_calendario;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Pannell che mostra i loghi delle due squadre contendenti
 * @author Enrico
 */
public class CercaGiornataPanelUp extends JPanel{

  
   private JLabel icoA;
   private JLabel icoB;
   
   /**
    * Costruttore con parametri del pannello
    * @param icoA logo della prima squadra
    * @param icoB  logo della seconda squadra
    */
   public CercaGiornataPanelUp(JLabel icoA, JLabel icoB) {
   
        this.icoA = icoA;
        this.icoB = icoB;
        Font font = new Font("sans-serif", Font.BOLD, 40);
        
        JLabel vs = new JLabel("-");
        vs.setFont(font);
        
        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        
        this.add(Box.createRigidArea(new Dimension(0, 40)));
        this.add(icoA);
        this.add(Box.createRigidArea(new Dimension(120, 20)));
        this.add(vs);
        this.add(Box.createRigidArea(new Dimension(120, 40)));
        this.add(icoB);
        
    }
    
     @Override
        public void paint(Graphics g){
        super.paint(g);
      
        }
    
}
