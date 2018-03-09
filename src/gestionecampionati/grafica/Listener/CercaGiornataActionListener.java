/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionecampionati.grafica.Listener;

import gestionecampionati.Campionato;
import gestionecampionati.Squadra;
import gestionecampionati.grafica.Errors.ErrorPanel;
import gestionecampionati.grafica.MainFrame;
import gestionecampionati.grafica.gestione_calendario.GestCSk;
import gestionecampionati.grafica.gestione_calendario.GiornataPanel;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.RowSorter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Enrico
 */
public class CercaGiornataActionListener implements ActionListener {
    
    private Campionato c;
    private MainFrame f;
    private GestCSk p;
    private ErrorPanel err;
    private Font font;
    private String sqa, sqb;
   
    public CercaGiornataActionListener(MainFrame f, Campionato c, GestCSk p, Font font) {
       this.c = c;
       this.f = f;
       this.p = p;
       
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int tmpA,tmpB;
        this.sqa = p.getPanelCenter().getPanelA().getSqa().getSelectedItem().toString();
        this.sqb = p.getPanelCenter().getPanelB().getSqb().getSelectedItem().toString();
        
        font = new Font("sans-serif", Font.BOLD, 16);
        
        if(!(p.getPanelCenter().getPanelA().getSqa().getSelectedItem().equals(p.getPanelCenter().getPanelB().getSqb().getSelectedItem()))){
          
            p.getPanelDown().removeAll();
            for(int i=0; i<c.getC().getGironeAndata().size(); i++){
                if(sqa.equals(c.getC().getGironeAndata().get(i).getCoppia().getA().getNome()) && sqb.equals(c.getC().getGironeAndata().get(i).getCoppia().getB().getNome()))
                {
                 


               
                    
                    tmpA = c.getC().getGironeAndata().get(i).getP().getPa();
                    tmpB =  c.getC().getGironeAndata().get(i).getP().getPb();
                   
                    
                    
                   Object[][] rowData = { {c.getC().getGironeAndata().get(i).getCoppia().getA().getNome(), c.getC().getGironeAndata().get(i).getCoppia().getB().getNome(), tmpA + " - "+ tmpB}};
                    
                   if(tmpA == 0 && tmpB == 0)
                          for(int j=0; j<rowData.length; j++)       
                               rowData[j][2] = "Non giocata"; 
                            
                   Object[] columnNames = {"Casa", "Trasferta", "Risultato"};
                   
                   JTable tabella = new JTable(rowData, columnNames);
                   
                   JLabel txt = new JLabel("Girone Andata: ");
                   txt.setFont(font);
                   p.getPanelDown().add(Box.createRigidArea(new Dimension(0, 40)));
                   p.getPanelDown().add(txt);
                   p.getPanelDown().add(Box.createRigidArea(new Dimension(0, 40)));
                   p.getPanelDown().add(new JScrollPane(tabella));
                 
                   
                  
                   
          
            
                 }
            }
            
             for(int i=0; i<c.getC().getGironeRitorno().size(); i++){
                if(sqa.equals(c.getC().getGironeRitorno().get(i).getCoppia().getA().getNome()) && sqb.equals(c.getC().getGironeRitorno().get(i).getCoppia().getB().getNome()))
                {
                   
                    
                    tmpA = c.getC().getGironeRitorno().get(i).getP().getPa();
                    tmpB =  c.getC().getGironeRitorno().get(i).getP().getPb();
                   
                    
                    
                   Object[][] rowData = { {c.getC().getGironeRitorno().get(i).getCoppia().getA().getNome(), c.getC().getGironeRitorno().get(i).getCoppia().getB().getNome(), tmpA + " - "+ tmpB}};
                    
                   if(tmpA == 0 && tmpB == 0)
                          for(int j=0; j<rowData.length; j++)       
                               rowData[j][2] = "Non giocata"; 
                            
                   Object[] columnNames = {"Casa", "Trasferta", "Risultato"};
                   
                   JTable tabella = new JTable(rowData, columnNames);
                   
                   JLabel txt = new JLabel("Girone Ritorno: ");
                   txt.setFont(font);
                   p.getPanelDown().add(Box.createRigidArea(new Dimension(0, 40)));
                   p.getPanelDown().add(txt);
                   p.getPanelDown().add(Box.createRigidArea(new Dimension(0, 40)));
                   p.getPanelDown().add(new JScrollPane(tabella));
            

                  
                   
            
                    
                
                }
            
            }
            p.getPanelDown().validate();
            
          
        }else err = new ErrorPanel(4);
    }
    
}
