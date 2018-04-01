
package gestionecampionati.grafica.visualizza_classifica;

import gestionecampionati.Campionato;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.text.View;

/**
 * Pannello upper della classifica, inserisce le label delle posizione 
 * dei primi calssificati
 * @author enrico
 */
public class VisClassificaUp extends JPanel{

    private JLabel primo,secondo,terzo;
    private Campionato c;
    
    /**
     * Costruttore con parametri, in base al numero di squadre decide quante label
     * inserire nel pannello
     * @param c struttura dati da cui recuperare il numero delle squadre nel campionato
     */
    public VisClassificaUp(Campionato c) {
        this.c=c;
        primo = new JLabel("1º"); // altgr+shift+m per i gradi 
        secondo = new JLabel("2º");
        terzo = new JLabel("3º");
        
        Font font  = new Font("sans-serif", Font.BOLD, 22);
        
        primo.setFont(font);
        secondo.setFont(font);
        terzo.setFont(font);
        
        this.setLayout(new BoxLayout(this, View.X_AXIS));
        
        
        
        if(c.get_numSquadre()==2){
            this.add(Box.createRigidArea(new Dimension(0, 40)));
            this.add(primo);
            this.add(Box.createRigidArea(new Dimension(260, 0)));
            this.add(secondo);

        
        }else{
            this.add(Box.createRigidArea(new Dimension(0, 40)));
            this.add(primo);
            this.add(Box.createRigidArea(new Dimension(260, 0)));
            this.add(secondo);
            this.add(Box.createRigidArea(new Dimension(260, 0)));
            this.add(terzo);
        
        
        }
        
       
        
        
    }
    
    
    
     @Override
        public void paint(Graphics g){
        super.paint(g);

        }
    
}
