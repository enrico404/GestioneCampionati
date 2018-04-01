
package gestionecampionati.grafica.Home;

import gestionecampionati.Campionato;
import gestionecampionati.grafica.popMenu.EliminaSqActionListener;
import gestionecampionati.grafica.popMenu.ModificaSqActionListener;
import gestionecampionati.grafica.MainFrame;
import gestionecampionati.grafica.menuBar.MenuBar;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import static javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER;
import static javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED;

/**
 * Pannello principale, è lo scheletro di tutto il programma. Contiene barra menu,
 * lista delle squadre partecipanti al campionato e pannello dei menu con tutte le funzioni 
 * che offre il programma.
 * @author enrico
 */
public class MainPanel extends JPanel {

    private MainFrame f;
    private JButton button;
    private MenuBar menu;
    private Campionato c;
    private MenuPanel centP;
    private DefaultListModel<String> listmodel;
    private JPopupMenu popMenu;
   
    
    /**
     * Costruttore del pannello, in base al parametro id capisce che tipo di campionato
     * creare.
     * @param f frame in cui inserire il pannello
     * @param id variabile che mi indica il tipo di sport che ha selezionato l'utente
     */
    public MainPanel(MainFrame f, int id) {
        super();
        JLabel sq = new JLabel("Squadre: ");
        Font font = new Font("sans-serif", Font.PLAIN, 15);
        listmodel = new DefaultListModel<>();
     
        
        
        if(id == 1)
            c = new Campionato("calcio" );
        else if (id == 2) 
            c = new Campionato("pallavolo");
        else 
            c = new Campionato("basket");
        
        
        centP = new MenuPanel(f, c, listmodel);
        centP.setEnabled(true);
    
        listmodel.add(0, sq.getText());
        
        JList<String> lista = new JList<>(listmodel);

        menu = new MenuBar(c, f, listmodel, centP );
        
        /** creazione del pop menu per la gestione delle squadre */
        popMenu = new JPopupMenu();
        JMenuItem elimina = new JMenuItem("Elimina");
        JMenuItem modifica = new JMenuItem("Modifica");
        
        elimina.addActionListener(new EliminaSqActionListener(c,lista, listmodel));
        modifica.addActionListener(new ModificaSqActionListener(c,lista, listmodel));
        popMenu.add(modifica);
        popMenu.add(elimina);
        

        
        this.f = f;
        
        this.setLayout(new BorderLayout());
        this.add(menu, BorderLayout.PAGE_START);
  
        JScrollPane scrollPane = new JScrollPane(lista, VERTICAL_SCROLLBAR_AS_NEEDED, HORIZONTAL_SCROLLBAR_NEVER);
        
        lista.setPreferredSize(new Dimension(200,100));
        lista.setFont(font);
        lista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        
        
        lista.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(SwingUtilities.isRightMouseButton(e) && !(lista.getSelectedIndex() == 0)){
                    if(!lista.isSelectionEmpty())
                        popMenu.show(lista, e.getX(), e.getY());
                }
            }
        });
        
        

   
        JScrollPane sc = new JScrollPane(lista);
        

        this.add(sc, BorderLayout.WEST );

        
        this.add(centP, BorderLayout.CENTER);
  
        
        
    }
    
   
     @Override
        public void paint(Graphics g){
        super.paint(g);

        
        }
    
    
    
    
}
