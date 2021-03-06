
package gestionecampionati.grafica.popMenu;

import gestionecampionati.Campionato;
import gestionecampionati.Punteggio;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.text.View;

/**
 * Pannello in basso della finestra di modifica dei risultati del calendario
 * 
 * @author Enrico
 */
public class InsRisPopDown extends JPanel{
    private Campionato c;
    private JTable tabella;
    private int tipo;
    private JButton ins;
    private InsRisPopUp panelUp;
    private AbstractTableModel tab;
    private JFrame f;
    
    /**
     * Costruttore del pannello, prende in input il codice per capire in quale girone mi trovo
     * @param f frame fluttuante da chiudere a ltermine
     * @param tipo codice del girone
     * @param c struttura dati da modificare
     * @param tabella jtable in cui recuperare la giornata 
     * @param panelUp riferimento al pannello in alto in cui recuperare i risultati 
     * @param tab  table model da aggiornare
     */
    public InsRisPopDown(JFrame f,int tipo, Campionato c, JTable tabella, InsRisPopUp panelUp, AbstractTableModel tab) {
        this.tipo  = tipo;
        this.tabella = tabella;
        this.c = c;
        this.tab=tab;
        this.panelUp = panelUp;
        this.f = f;
        
        ins = new JButton("Inserisci");
        
        ins.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int p1 = panelUp.getP1().getSelectedIndex();
                int p2 = panelUp.getP2().getSelectedIndex();
                if(tipo== 1){
                    c.getC().getGironeAndata().get(tabella.getSelectedRow()).setP(new Punteggio(p1,p2));
                    /** setto esplicitamente la partita a giocata, altrimenti se non lo fosse, non si visualizzerebbe il risultato nel calendario */
                    c.getC().getGironeAndata().get(tabella.getSelectedRow()).setGiocata(true);
                    tab.fireTableDataChanged();
                }else{
                    c.getC().getGironeRitorno().get(tabella.getSelectedRow()).setP(new Punteggio(p1,p2));   
                     c.getC().getGironeRitorno().get(tabella.getSelectedRow()).setGiocata(true);
                    tab.fireTableDataChanged();
                }
                
                f.dispose();
            }
        });
        
        this.setLayout(new BoxLayout(this, View.Y_AXIS));
        
        ins.setAlignmentX(CENTER_ALIGNMENT);
     
        
        this.add(ins);
        
    }

   
   
    
    @Override
        public void paint(Graphics g){
        super.paint(g);

        }
    
}
