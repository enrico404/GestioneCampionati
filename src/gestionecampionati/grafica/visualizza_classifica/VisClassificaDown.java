
package gestionecampionati.grafica.visualizza_classifica;

import gestionecampionati.Campionato;
import gestionecampionati.grafica.ChiudiActionListener;
import gestionecampionati.grafica.MainFrame;
import gestionecampionati.grafica.gestione_calendario.StampaActionListener;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.text.View;

/**
 * Pannello in basso della visualizzazione della classifica, contiene la tabella 
 * degli utimi classificati, il bottone per tornare indietro e il bottone per stampare la classifica
 * con la stampante oppure pdf.
 * @author enrico
 */
public class VisClassificaDown extends JPanel{

    private Campionato c;
    private ClassificaTableModel cls;
    private JButton indietro, stampa;
    private JPanel menu;
    private MainFrame f;
    private VisClassificaSk sk;
    
    
    /**
     * Costruttore con parametri del pannello
     * @param c struttura dati per 
     * @param menu menu che offre le funzionalità principali del programma
     * @param f frame in cui inserire i vari pannelli
     * @param sk  pannello da stampare  
     */
    public VisClassificaDown(Campionato c, JPanel menu, MainFrame f, VisClassificaSk sk) {
        this.sk = sk;
        this.c = c;
        this.f= f;
        this.menu = menu;
        
        this.setLayout(new BoxLayout(this, View.Y_AXIS));
        cls = new ClassificaTableModel(c);
        indietro = new JButton("Indietro");
        stampa = new JButton("Stampa");
        
        JTable tabella = new JTable(cls);
        JScrollPane sc = new JScrollPane(tabella);
        sc.setMaximumSize(new Dimension(800, 200));
        sc.setMinimumSize(new Dimension(800, 200));
        indietro.setMaximumSize(new Dimension(200, 40));
        indietro.setMinimumSize(new Dimension(200, 40));
        stampa.setMaximumSize(new Dimension(200, 40));
        stampa.setMinimumSize(new Dimension(200, 40));
        
        indietro.addActionListener(new ChiudiActionListener(f, sk, menu));
        indietro.setAlignmentX(CENTER_ALIGNMENT);
        
        stampa.addActionListener(new StampaActionListener(sk));
        stampa.setAlignmentX(CENTER_ALIGNMENT);
        
        JPanel down = new JPanel();
        down.setLayout(new BoxLayout(down, View.X_AXIS));
        down.add(indietro);
        down.add(Box.createRigidArea(new Dimension(20, 0)));
        down.add(stampa);
        
        
        this.add(sc);
        this.add(Box.createRigidArea(new Dimension(100, 20)));  
        this.add(down);
        
        
    }
    
    
    @Override
        public void paint(Graphics g){
        super.paint(g);

        }
    
}
