
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
 * Pannello centrale della visualizzazione della calsssifica contenente 
 * il punteggio delle prime squadre classificate
 * @author enrico
 */
public class VisClassificaCenterP extends JPanel{

    private Campionato c;
    private JLabel[] p;
    
    /**
     * Costruttore con parametri del pannello
     * @param c  struttura dati da cui recuperare il punteggio
     */
    public VisClassificaCenterP(Campionato c) {
        this.c = c;
        
        Font font = new Font("sans-serif", Font.PLAIN, 18);
        p = new JLabel[c.get_numSquadre()];
        int i=0;
        
        this.setLayout(new BoxLayout(this, View.X_AXIS));
        this.add(Box.createRigidArea(new Dimension(170, 0)));
        while(i<c.get_numSquadre() && i<3){
            p[i] = new JLabel(c.getCls().getClassifica().get(i).getNome()+": "+c.getCls().getClassifica().get(i).getPunteggio());
            p[i].setFont(font);
            this.add(p[i]);
            this.add(Box.createRigidArea(new Dimension(200, 0)));
            i++;
        
        }
        
        
    }

    @Override
        public void paint(Graphics g){
        super.paint(g);

        }
    
}
