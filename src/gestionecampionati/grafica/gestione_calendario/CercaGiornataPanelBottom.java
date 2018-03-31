
package gestionecampionati.grafica.gestione_calendario;

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Pannello che mostra i punteggi delle due squadre contendenti
 * @author Enrico
 */
public class CercaGiornataPanelBottom extends JPanel{

    private JLabel puntA;
    private JLabel puntB;
    private  JButton stampa;
 
  
    /**
     * Costruttore con parametri del pannello
     * @param puntA punteggio della prima squadra
     * @param puntB  punteggio della seconda squadra
     */
    public CercaGiornataPanelBottom(JLabel puntA, JLabel puntB) {
        this.puntA = puntA;
        this.puntB = puntB;
        
 
        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
               
        this.add(puntA);
        this.add(Box.createRigidArea(new Dimension(360, 0)));
        this.add(puntB);
        
        
    }
    
     @Override
        public void paint(Graphics g){
        super.paint(g);
      
        }
    
    
    
}
