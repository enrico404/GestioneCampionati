/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionecampionati.grafica.gestione_calendario;

import gestionecampionati.Campionato;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Vector;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.text.View;

/**
 *
 * @author Enrico
 */
public class GiornataPanel extends JPanel {
    private Campionato c;
    private int indice;
    /** variabile che indica il tipo di girone, 1-> andata, 2 -> ritorno */
    private int girone;
    private JTable tab;

    public GiornataPanel(Campionato c, int indice, int girone){
        super();
        this.c = c;
        this.indice = indice;
        this.girone = girone;
        
        this.setLayout(new BoxLayout(this, View.Y_AXIS ));
        
        if(girone == 1){
                       
                     Object[][] rowData = { {c.getC().getGironeAndata().get(indice).getCoppia().getA().getNome(), c.getC().getGironeAndata().get(indice).getCoppia().getB().getNome(), c.getC().getGironeAndata().get(indice).getP().getPa()+ " - "  + c.getC().getGironeAndata().get(indice).getP().getPb()}};
                     Object[] columnNames = {"Casa", "Trasferta", "Risultato"};
                     tab = new JTable( rowData, columnNames);
                }
        JScrollPane sc = new JScrollPane(tab);
        
      
        this.add(Box.createRigidArea(new Dimension(0, 40)));
        this.add(sc);        
    
    
    }


    
     @Override
        public void paint(Graphics g){
        super.paint(g);
        repaint();
       

        }
    
}
