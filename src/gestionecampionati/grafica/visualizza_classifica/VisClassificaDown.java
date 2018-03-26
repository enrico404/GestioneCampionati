
package gestionecampionati.grafica.visualizza_classifica;

import gestionecampionati.Campionato;
import gestionecampionati.grafica.Listener.ChiudiActionListener;
import gestionecampionati.grafica.MainFrame;
import gestionecampionati.grafica.MenuPanel;
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
 *
 * @author enrico
 */
public class VisClassificaDown extends JPanel{

    private Campionato c;
    private ClassificaTableModel cls;
    private JButton indietro;
    private MenuPanel menu;
    private MainFrame f;
    private VisClassificaSk sk;
    
    

    public VisClassificaDown(Campionato c, MenuPanel menu, MainFrame f, VisClassificaSk sk) {
        this.sk = sk;
        this.c = c;
        this.f= f;
        this.menu = menu;
        
        this.setLayout(new BoxLayout(this, View.Y_AXIS));
        cls = new ClassificaTableModel(c);
        indietro = new JButton("Indietro");
        
        JTable tabella = new JTable(cls);
        JScrollPane sc = new JScrollPane(tabella);
        sc.setMaximumSize(new Dimension(800, 200));
        sc.setMinimumSize(new Dimension(800, 200));
        indietro.setMaximumSize(new Dimension(200, 40));
        indietro.setMinimumSize(new Dimension(200, 40));
        
        indietro.addActionListener(new ChiudiActionListener(f, sk, menu));
        indietro.setAlignmentX(CENTER_ALIGNMENT);
        
        this.add(sc);
        this.add(Box.createRigidArea(new Dimension(100, 20)));
        
        this.add(indietro);
        
        
    }
    
    
    @Override
        public void paint(Graphics g){
        super.paint(g);

        }
    
}
