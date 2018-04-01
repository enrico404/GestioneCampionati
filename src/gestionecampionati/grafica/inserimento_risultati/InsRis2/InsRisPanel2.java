
package gestionecampionati.grafica.inserimento_risultati.InsRis2;

import gestionecampionati.Campionato;
import gestionecampionati.grafica.MainFrame;
import gestionecampionati.grafica.ChiudiActionListener;
import gestionecampionati.grafica.inserimento_risultati.InsRis.InsRisPanelUP;
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
 * Secondo pannello scheletro di inserimento dei risultati, utile per lo sport della pallavolo
 * che prevede l'inserimento di più set, in base ai risultati dei set si calcola 
 * il risultato finale della partita.
 * @author Enrico
 */
public class InsRisPanel2 extends JPanel{

    private JPanel old;
    private Campionato c;
    private MainFrame f;
    private InsRisPanelUP panelUp;
    private JLabel qst_set;
    private JComboBox num_set;
    private JButton vai, indietro;
    
    
    /**
     * Costruttore con parametri del pannello scheletro (secondo ) di inserimento 
     * dei risultati. utile per per gestire bene il lalyout e recupare i vari dati
     * dai pannelli che contiene.
     * @param old panello vecchio menu, utile per il bottone indietro
      * @param c  struttura dati in cui inserire i risultati
     * @param f  frame in cui inserire i vari pannelli
     */
    public InsRisPanel2(JPanel old, Campionato c, MainFrame f) {
        this.old = old;
        this.c = c;
        this.f = f;
         
        Dimension d = new Dimension(50 , 30);
        
        vai = new JButton("Vai");
        vai.setMaximumSize(new Dimension(100,40));
        vai.setMinimumSize(new Dimension(100,40));
        vai.setAlignmentX(CENTER_ALIGNMENT);
        
        indietro = new JButton("Indietro");
        indietro.setMaximumSize(new Dimension(100,40));
        indietro.setMinimumSize(new Dimension(100,40));
        indietro.setAlignmentX(CENTER_ALIGNMENT);
        
        Font font =  new Font("sans-serif", Font.PLAIN, 18);
        panelUp = new InsRisPanelUP(c);
        
        qst_set = new JLabel("Inserire numero set giocati");
        qst_set.setFont(font);
        qst_set.setAlignmentX(CENTER_ALIGNMENT);
        
        num_set = new JComboBox();
        riempi();
        
        
        num_set.setMaximumSize(d);
        num_set.setMinimumSize(d);
        num_set.setBackground(Color.white);
        
        
       
        
        
        vai.addActionListener(new VaiActionListener(c, panelUp, num_set, f, this));
        indietro.addActionListener(new ChiudiActionListener(f, this, old));
        
        JPanel bottom = new JPanel();
        bottom.setLayout(new BoxLayout(bottom, BoxLayout.X_AXIS));
        bottom.add(indietro);
        bottom.add(Box.createRigidArea(new Dimension(20,0)));
        bottom.add(vai);
        
        
        
        
        
        this.setLayout(new BoxLayout(this,View.Y_AXIS));
        
        this.add(Box.createRigidArea(new Dimension(0, 100)));
        this.add(panelUp);
        this.add(Box.createRigidArea(new Dimension(0, 50)));
        this.add(qst_set);
        this.add(Box.createRigidArea(new Dimension(0, 20)));
        this.add(num_set);
        this.add(Box.createRigidArea(new Dimension(0, 100)));
        this.add(bottom);
        
        
    }
    
    /**
     * Metodo per riempire le combo box dei possibili set giocati nella pallavolo
     */
    public void riempi(){
          for(int i=3; i<6; i++){
                  
                       num_set.addItem(i);
                      
                  }
   
    }

    public InsRisPanelUP getPanelUp() {
        return panelUp;
    }

    public void setPanelUp(InsRisPanelUP panelUp) {
        this.panelUp = panelUp;
    }

    public JComboBox getNum_set() {
        return num_set;
    }

    public void setNum_set(JComboBox num_set) {
        this.num_set = num_set;
    }
    
   
     @Override
        public void paint(Graphics g){
        super.paint(g);

        }
    
}
