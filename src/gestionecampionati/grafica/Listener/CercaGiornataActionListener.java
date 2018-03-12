/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionecampionati.grafica.Listener;

import gestionecampionati.Campionato;
import gestionecampionati.grafica.Errors.ErrorPanel;
import gestionecampionati.grafica.MainFrame;
import gestionecampionati.grafica.gestione_calendario.CercaGiornataPanelBottom;
import gestionecampionati.grafica.gestione_calendario.CercaGiornataPanelUp;
import gestionecampionati.grafica.gestione_calendario.GestCSk;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.text.View;

/**
 *
 * @author Enrico
 */
public class CercaGiornataActionListener implements ActionListener {
    
    private Campionato c;
    private MainFrame f;
    private GestCSk p;
    private ErrorPanel err;
    private Font font, fontPunteggio;
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
        fontPunteggio = new Font("sans-serif", Font.BOLD, 24);
        if(!(p.getPanelCenter().getPanelA().getSqa().getSelectedItem().equals(p.getPanelCenter().getPanelB().getSqb().getSelectedItem()))){
         
            p.getPanelDown().removeAll();
                
            
            for(int i=0; i<c.getC().getGironeAndata().size(); i++){
                if(sqa.equals(c.getC().getGironeAndata().get(i).getCoppia().getA().getNome()) && sqb.equals(c.getC().getGironeAndata().get(i).getCoppia().getB().getNome()))
                {
                 
                             

               
                    
                    tmpA = c.getC().getGironeAndata().get(i).getP().getPa();
                    tmpB =  c.getC().getGironeAndata().get(i).getP().getPb();
                   
                    
                    
                    BufferedImage bf1, bf2;
                            
                            
                    JLabel icoA = null;
                    JLabel icoB = null;
              
                    try{
                        bf1 = ImageIO.read(new File("../GestioneCampionati/media/loghi/"+ c.getC().getGironeAndata().get(i).getCoppia().getA().getNome() + ".jpg"));
                        icoA = new JLabel(new ImageIcon(bf1));
                    }catch(IOException ex){
                        try {
                            bf1 = ImageIO.read(new File("../GestioneCampionati/media/loghi/default.jpg"));
                            icoA = new JLabel(new ImageIcon(bf1));
                        } catch (IOException ex1) {
                            Logger.getLogger(CercaGiornataActionListener.class.getName()).log(Level.SEVERE, null, ex1);
                        }
                    }
                    
                    try{
                         bf2 = ImageIO.read(new File("../GestioneCampionati/media/loghi/"+ c.getC().getGironeAndata().get(i).getCoppia().getB().getNome() + ".jpg"));
                         icoB = new JLabel(new ImageIcon(bf2));
                    }catch(IOException ex){
                        try {
                            bf2 = ImageIO.read(new File("../GestioneCampionati/media/loghi/default.jpg"));
                            icoB = new JLabel(new ImageIcon(bf2));
                        } catch (IOException ex1) {
                            Logger.getLogger(CercaGiornataActionListener.class.getName()).log(Level.SEVERE, null, ex1);
                        }
                    }
                    
                    
                    
                    
                    
                    
                    
                    
                    icoA.setMaximumSize(new Dimension(120, 120));
                    icoB.setMaximumSize(new Dimension(120, 120));
                    icoA.setMinimumSize(new Dimension(120, 120));
                    icoB.setMinimumSize(new Dimension(120, 120));
                    
                    JLabel puntA = null;
                    JLabel puntB = null;
                    
                    if(c.getC().getGironeAndata().get(i).isGiocata()){
                        puntA = new JLabel(""+tmpA);
                        puntB = new JLabel(""+ tmpB);
                        puntA.setFont(fontPunteggio);
                        puntB.setFont(fontPunteggio);
                    
                    }else {
                        puntA = new JLabel("Non giocata");
                        puntB = new JLabel("Non giocata");
                        puntA.setFont(font);
                        puntB.setFont(font);
                    
                    }
                    
                    
                 
                    p.getPanelDown().setLayout(new BoxLayout(p.getPanelDown(), View.Y_AXIS));
                    
                    JLabel txt = new JLabel("Girone Andata ");
                    txt.setFont(new Font("sans-serif", Font.BOLD, 18));
                    txt.setAlignmentX(Component.CENTER_ALIGNMENT);
                    p.getPanelDown().add(Box.createRigidArea(new Dimension(0, 60)));
                    p.getPanelDown().add(txt);
                 
                    p.getPanelDown().add(Box.createRigidArea(new Dimension(0, 60)));
                    p.getPanelDown().add(new CercaGiornataPanelUp(icoA, icoB));
                    p.getPanelDown().add(Box.createRigidArea(new Dimension(0, 10)));
                    p.getPanelDown().add(new CercaGiornataPanelBottom(puntA, puntB));
                    
                    
                   
                    f.repaint();
                    
                /**    
                    
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
                 
                   
                  
                   
          */
            
                 }
            }
            
             for(int i=0; i<c.getC().getGironeRitorno().size(); i++){
                if(sqa.equals(c.getC().getGironeRitorno().get(i).getCoppia().getA().getNome()) && sqb.equals(c.getC().getGironeRitorno().get(i).getCoppia().getB().getNome()))
                {
                   
                    
                    
                             

               
                    
                    tmpA = c.getC().getGironeRitorno().get(i).getP().getPa();
                    tmpB =  c.getC().getGironeRitorno().get(i).getP().getPb();
                   
                    
                    
                    BufferedImage bf1, bf2;
                            
                            
                    JLabel icoA = null;
                    JLabel icoB = null;
                    JLabel puntA = null;
                    JLabel puntB = null;
              
                    try{
                        bf1 = ImageIO.read(new File("../GestioneCampionati/media/loghi/"+ c.getC().getGironeRitorno().get(i).getCoppia().getA().getNome() + ".jpg"));
                        icoA = new JLabel(new ImageIcon(bf1));
                    }catch(IOException ex){
                        try {
                            bf1 = ImageIO.read(new File("../GestioneCampionati/media/loghi/default.jpg"));
                            icoA = new JLabel(new ImageIcon(bf1));
                        } catch (IOException ex1) {
                            Logger.getLogger(CercaGiornataActionListener.class.getName()).log(Level.SEVERE, null, ex1);
                        }
                    }
                    
                    try{
                         bf2 = ImageIO.read(new File("../GestioneCampionati/media/loghi/"+ c.getC().getGironeRitorno().get(i).getCoppia().getB().getNome() + ".jpg"));
                         icoB = new JLabel(new ImageIcon(bf2));
                    }catch(IOException ex){
                        try {
                            bf2 = ImageIO.read(new File("../GestioneCampionati/media/loghi/default.jpg"));
                            icoB = new JLabel(new ImageIcon(bf2));
                        } catch (IOException ex1) {
                            Logger.getLogger(CercaGiornataActionListener.class.getName()).log(Level.SEVERE, null, ex1);
                        }
                    }
                    
                    
      
                    icoA.setMaximumSize(new Dimension(120, 120));
                    icoB.setMaximumSize(new Dimension(120, 120));
                    icoA.setMinimumSize(new Dimension(120, 120));
                    icoB.setMinimumSize(new Dimension(120, 120));
                    
                    if(c.getC().getGironeAndata().get(i).isGiocata()){
                        puntA = new JLabel(""+tmpA);
                        puntB = new JLabel(""+ tmpB);
                        puntA.setFont(fontPunteggio);
                        puntB.setFont(fontPunteggio);
                    
                    }else {
                        puntA = new JLabel("Non giocata");
                        puntB = new JLabel("Non giocata");
                        puntA.setFont(font);
                        puntB.setFont(font);
                    
                    }
                    
                      
                    JLabel txt = new JLabel("Girone Ritorno ");
                    txt.setFont(new Font("sans-serif", Font.BOLD, 18));
                    txt.setAlignmentX(Component.CENTER_ALIGNMENT);
                    
                    p.getPanelDown().add(Box.createRigidArea(new Dimension(0, 60)));
                    p.getPanelDown().add(txt);
                    
                    p.getPanelDown().add(Box.createRigidArea(new Dimension(0, 60)));
                    p.getPanelDown().add(new CercaGiornataPanelUp(icoA, icoB));
                    p.getPanelDown().add(Box.createRigidArea(new Dimension(0, 10)));
                    p.getPanelDown().add(new CercaGiornataPanelBottom(puntA, puntB));
                    
                    
                   
                    f.repaint();
    
                
                }
            
            }
            p.getPanelDown().validate();
            
          
        }else err = new ErrorPanel(4);
    }
    
}
