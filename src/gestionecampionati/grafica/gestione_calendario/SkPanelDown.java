
package gestionecampionati.grafica.gestione_calendario;

import gestionecampionati.grafica.popMenu.InsPopActionListener;
import gestionecampionati.Campionato;
import gestionecampionati.grafica.Errors_Confirm.ErrorPanel;
import gestionecampionati.grafica.Home.InsRis2ActionListener;
import gestionecampionati.grafica.MainFrame;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import javax.swing.text.View;

/**
 * Pannello in basso della gestione del calendario, implementa le due tabelle che 
 * mostrano le varie giornate di incontri tra le squadre.
 * @author enrico.
 */
public class SkPanelDown extends JPanel{
    
   
    private Campionato c;
    private CalTableModel tab1;
    private Cal2TableModel tab2;
    private JTable tabella, tabella2;
    private JLabel gironeAnd;
    private JLabel gironeRit;
    private JScrollPane panelloScroll, panelloScroll2;
    private JButton rigenera, cancellaRis, stampa;
    private JPopupMenu popMenu, popMenu2;
    private GestCSk sk;
    private MainFrame f;
   

    /**
     * Costruttore con parametri del pannello
     * @param c struttura dati per generare le tabelle
     * @param sk pannello scheletro per recuperare la posizione in cui inserire il nuovo pannello
     * @param f  frame in cui inserire i pannelli
     */
    public SkPanelDown(Campionato c, GestCSk sk, MainFrame f) {
        super();
        try{
            if(!(c.getC().getGironeAndata().isEmpty())){
              tab1 = new CalTableModel(c);
              tab2 = new Cal2TableModel(c);
            }
        }catch(Exception ex){ ErrorPanel err = new ErrorPanel(3); }
        this.f = f;
        this.sk = sk;
        Font font = new Font("sans-serif", Font.BOLD, 16);
        
        gironeAnd = new JLabel("Girone Andata: ");
        gironeAnd.setFont(font); 
        gironeRit = new JLabel("Girone Ritorno: ");
        gironeRit.setFont(font);
        

        this.setLayout(new BoxLayout(this, View.Y_AXIS));
        
        tabella = new JTable(tab1);
        tabella2 = new JTable(tab2);
        
        
        popMenu = new JPopupMenu();
        JMenuItem inserisci = new JMenuItem("Inserisci");
        popMenu.add(inserisci);
        
        
        popMenu2 = new JPopupMenu();
        JMenuItem inserisci2 = new JMenuItem("Inserisci");
        popMenu2.add(inserisci2);
        
        
        tabella.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tabella2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        if(c.getSport().equals("pallavolo")){
             inserisci.addActionListener(new InsRis2ActionListener(f, sk, c, tabella, 1));
             inserisci2.addActionListener(new InsRis2ActionListener(f, sk, c, tabella2, 2));
        
        }else{
             inserisci.addActionListener(new InsPopActionListener(tabella, c, 1,tab1));
             inserisci2.addActionListener(new InsPopActionListener(tabella2, c, 2,tab2));
        }
       
 
        tabella.addMouseListener(new MouseAdapter() {
   
           
            @Override
            public void mouseClicked(MouseEvent e) {

                if(SwingUtilities.isRightMouseButton(e) && (tabella.getSelectedColumn() == 2)){ 
                    popMenu.show(tabella, e.getX(), e.getY());
                    
                }
            }

        });
        
          tabella2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(SwingUtilities.isRightMouseButton(e) && (tabella2.getSelectedColumn() == 2)){                  
                    popMenu2.show(tabella2, e.getX(), e.getY());
                }
            }

        });
        
       
        panelloScroll = new JScrollPane(tabella);
        panelloScroll2 = new JScrollPane(tabella2);
        
        
        rigenera = new JButton("Rigenera");
        cancellaRis = new JButton("Elimina risultati");
        stampa = new JButton("Stampa calendario");
        
        JPanel end = new JPanel();
        end.setLayout(new FlowLayout());
        
        
        end.add(rigenera);
        end.add(Box.createRigidArea(new Dimension(20, 0)));
        end.add(cancellaRis);
        end.add(Box.createRigidArea(new Dimension(20, 0)));
        end.add(stampa);
        
        
      
        cancellaRis.addActionListener(new CancellaRisActionListener(c, this));
        rigenera.addActionListener(new RigeneraCalActionListener(c, this));
        stampa.addActionListener(new StampaActionListener(sk));
  
        
        gironeAnd.setAlignmentX(CENTER_ALIGNMENT);
        gironeRit.setAlignmentX(CENTER_ALIGNMENT);
        
        
        
        this.add(Box.createRigidArea(new Dimension(0, 40)));
        this.add(gironeAnd);
        this.add(Box.createRigidArea(new Dimension(0, 40)));
        this.add(panelloScroll);
        this.add(Box.createRigidArea(new Dimension(0, 40)));
        this.add(gironeRit);
        this.add(Box.createRigidArea(new Dimension(0, 40)));
        this.add(panelloScroll2);
        this.add(Box.createRigidArea(new Dimension(0, 10)));
        this.add(end);
        
    }

    public CalTableModel getTab1() {
        return tab1;
    }

    public void setTab1(CalTableModel tab1) {
        this.tab1 = tab1;
    }

    public Cal2TableModel getTab2() {
        return tab2;
    }

    public void setTab2(Cal2TableModel tab2) {
        this.tab2 = tab2;
    }

    public JTable getTabella() {
        return tabella;
    }

    public void setTabella(JTable tabella) {
        this.tabella = tabella;
    }

    public JTable getTabella2() {
        return tabella2;
    }

    public void setTabella2(JTable tabella2) {
        this.tabella2 = tabella2;
    }

    public JLabel getGironeAnd() {
        return gironeAnd;
    }

    public void setGironeAnd(JLabel gironeAnd) {
        this.gironeAnd = gironeAnd;
    }

    public JLabel getGironeRit() {
        return gironeRit;
    }

    public void setGironeRit(JLabel gironeRit) {
        this.gironeRit = gironeRit;
    }

    public JScrollPane getPanelloScroll() {
        return panelloScroll;
    }

    public void setPanelloScroll(JScrollPane panelloScroll) {
        this.panelloScroll = panelloScroll;
    }

    public JScrollPane getPanelloScroll2() {
        return panelloScroll2;
    }

    public void setPanelloScroll2(JScrollPane panelloScroll2) {
        this.panelloScroll2 = panelloScroll2;
    }
    
       @Override
        public void paint(Graphics g){
        super.paint(g);
        

        }
    
}
