
package gestionecampionati.grafica.gestione_calendario;


import gestionecampionati.Campionato;
import java.awt.Dimension;
import java.awt.TextField;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.text.View;
import gestionecampionati.grafica.ChiudiActionListener;
import gestionecampionati.grafica.MainFrame;
import java.awt.Graphics;



/**
 * Pannello in alto della gestione del calendario, impolenta diversi bottoni:
 * ritorno al menu, calendario completo e la ricerca di una squadra con tutte le sue partite.
 * @author enrico
 */
public class SkPanelUp extends JPanel {
   
    private JButton calCompl;
    private JButton buttCerca, indietro;
    private TextField cercaText;
    private Dimension d, d1, d2, d3;
    private JPanel menuP;
    private GestCSk sk;
    private MainFrame f;
    private Campionato c;
    
    
    /**
     * Costruttore con parametri del pannello 
     * @param menuP pannello menu, utile per tornare nella pagina precedente
     * @param sk pannello scheletro da cui recuparare la posizione in cui inserire il nuovo pannello
     * @param f frame principale
     * @param c  struttura dati
     */
    public SkPanelUp(JPanel menuP, GestCSk sk, MainFrame f, Campionato c) {
        super();
        this.menuP = menuP;
        this.sk = sk;
        this.f = f;
        this.c = c;
        d = new Dimension(150, 40);
        d1 = new Dimension(150, 30);
        d2 = new Dimension(150, 40 );
        d3 = new Dimension(60, 40);
        
        
        
        calCompl = new JButton("Calendario completo");
     
        calCompl.setMaximumSize(d2);
        calCompl.setMinimumSize(d2);
        
        indietro = new JButton("Menu");
        
        indietro.setMaximumSize(d3);
        indietro.setMinimumSize(d3);
        
        buttCerca = new JButton("Cerca");
        
        buttCerca.setMaximumSize(d);
        buttCerca.setMinimumSize(d);
        
        cercaText = new TextField("Inserire squadra");
        
        cercaText.setMaximumSize(d1);
        cercaText.setMinimumSize(d1);
        
        buttCerca.addActionListener(new CercaSquadraActionListener(cercaText, sk, c));
        calCompl.addActionListener(new CalComplActionListener(f, sk, c));
        cercaText.addFocusListener(new CercaTextFocusListener(cercaText));
        indietro.addActionListener(new ChiudiActionListener(f, sk, menuP));
        
        
        this.setLayout(new BoxLayout(this, View.X_AXIS));
        
        this.add(Box.createRigidArea(new Dimension(30, 0)));
        this.add(indietro);
        this.add(Box.createRigidArea(new Dimension(30, 0)));
        this.add(calCompl);
        this.add(Box.createHorizontalGlue());
        this.add(cercaText);
        this.add(Box.createRigidArea(new Dimension(30, 40)));
        this.add(buttCerca);
        this.add(Box.createRigidArea(new Dimension(20, 40)));
        
    }
    
       @Override
        public void paint(Graphics g){
        super.paint(g);
       
       

        }
}



