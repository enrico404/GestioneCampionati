/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionecampionati.grafica;
import gestionecampionati.Calendario;
import gestionecampionati.Campionato;
import gestionecampionati.Squadra;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.*;
import static javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER;
import static javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED;
/**
 *
 * @author enrico
 */
public class CalcioPanel extends JPanel {

    private MainFrame f;
    private JButton button;
    private MenuBar menu;
    private Campionato c;
    private MenuPanel centP;
    private DefaultListModel<String> listmodel;

    
    
    public CalcioPanel(MainFrame f) {
        super();
        JLabel sq = new JLabel("Squadre: ");
        Font font = new Font("sans-serif", Font.PLAIN, 15);
        listmodel = new DefaultListModel<>();
        
      
      
        
        
        c = new Campionato("calcio" );
          
        centP = new MenuPanel(f, c, listmodel);
        centP.setEnabled(true);
    
        listmodel.add(0, sq.getText());
        
        JList<String> lista = new JList<>(listmodel);
      
        
        
        
        menu = new MenuBar(c, f, this, listmodel, centP );
        this.f = f;
        
        this.setLayout(new BorderLayout());
        
        
        
        this.add(menu, BorderLayout.PAGE_START);
        JScrollPane scrollPane = new JScrollPane(lista, VERTICAL_SCROLLBAR_AS_NEEDED, HORIZONTAL_SCROLLBAR_NEVER);
        
        lista.setPreferredSize(new Dimension(200,100));
        
        lista.setFont(font);
   
       this.add(new JScrollPane(lista), BorderLayout.WEST );
     
       
       this.add(centP, BorderLayout.CENTER);
       
       
       
       

        
        
        
    }
   
     @Override
        public void paint(Graphics g){
        super.paint(g);
       
        
        }
    
    
    
    
}
