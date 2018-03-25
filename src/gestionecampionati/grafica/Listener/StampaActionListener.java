/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionecampionati.grafica.Listener;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import java.awt.print.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Enrico
 */
public class StampaActionListener implements ActionListener {

    private JPanel panel;
    



    public StampaActionListener(JPanel panel) {
        
        this.panel = panel;
    }
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
       
        PrinterJob prj = PrinterJob.getPrinterJob();
    
        prj.setJobName("Stampa calendario");
        prj.setPrintable(new Printable() {
            
            
            @Override
            public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
                if (pageIndex > 0) { 
                   return NO_SUCH_PAGE;
                }
             
                Graphics2D g2 = (Graphics2D)graphics;
                
                
                
                double cWidth = panel.getWidth();
                double cHeight = panel.getHeight();
                
                double pWidth = pageFormat.getImageableWidth();
                double pHeight = pageFormat.getImageableHeight();
                
                
                /** ridimensiona l'immagine */
                g2.scale(pWidth/cWidth, 0.6);
                
                /** stampo tutto il pannello con il componente grafico g2 */
                panel.paintAll(g2);
             
                return PAGE_EXISTS;
            }
        });
      
        /** apro dialogo di print */
        if(prj.printDialog()){
            try {
                prj.print();
            } catch (PrinterException ex) {
                Logger.getLogger(StampaActionListener.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        };
    }
    
}
