
package gestionecampionati.grafica.gestione_calendario;

import gestionecampionati.Campionato;
import gestionecampionati.grafica.MainFrame;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.text.View;


/**
 * Pannello "a" centrale della gestione calendario
 * @author Enrico
 */
public class SkPanelCenterSqB extends JPanel {

    private MainFrame f;
    private Campionato c ; 
    private JLabel lsqb;
    private JComboBox sqb;
    private JButton cerca;
    private Dimension d;
    private Font font;
    private GestCSk p;
 
    /**
     * Costruttore con parametri del pannello centrale b.
     * @param c struttura dati in cui ricercare l'incontro
     * @param font font scelto
     * @param f frame in cui inserire il pannello
     * @param p  pannello scheletro da cui recuperare il pannello da sostituire
     */
    public SkPanelCenterSqB(Campionato c, Font font, MainFrame f, GestCSk p) {
        super();
        this.c = c;
        this.font = font;
        this.f = f;
        d = new Dimension(200 , 30);
        this.p = p;
        lsqb = new JLabel("Squadra Trasferta: ");
        sqb = new JComboBox();
        cerca = new JButton("Cerca");
        
        lsqb.setFont(font);
        
        sqb.setMaximumSize(d);
        sqb.setMinimumSize(d);
        sqb.setBackground(Color.white);
       
        
        this.setLayout(new BoxLayout(this, View.X_AXIS));
        
        this.add(lsqb);
        this.add(Box.createRigidArea(new Dimension(20, 0)));
        this.add(sqb);
        this.add(Box.createRigidArea(new Dimension(40, 0)));
        this.add(cerca);
        
        cerca.addActionListener(new CercaGiornataActionListener(f,c, p, font));
        
        
        
        
    }
    
    
    public boolean riempi(){
     
                for(int i=0; i<c.getSquadre().size(); i++){
                 
                       sqb.addItem(c.getSquadre().get(i).getNome());
                  }
         
        
        return true;
    }

    public JComboBox getSqb() {
        return sqb;
    }
    
    
    
     @Override
        public void paint(Graphics g){
        super.paint(g);
      
       

        }
    
}
