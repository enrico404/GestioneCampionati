
package gestionecampionati.grafica.visualizza_classifica;

import gestionecampionati.Campionato;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.text.View;

/**
 * Pannello centrale della visualizzazione della classifica, contiene i loghi 
 * delle prime squadre classificate all'interno del campionato
 * @author enrico
 */
public class VisClassificaCenterL extends JPanel {

    private Campionato c;
    
    
    /**
     * Costruttore del pannello centrale della calssifica, dal campionato recupera i vari loghi
     * @param c struttura dati principale del programma
     */
    public VisClassificaCenterL(Campionato c) {
        this.c = c;
        BufferedImage[] bf = new BufferedImage[3];
        JLabel[] ico = new JLabel[3];
        int i =0;
      //  c.getC().ricalcolaPathLoghi();
        try {   
           while(i<c.get_numSquadre() && i<3){
               try{
                bf[i] = ImageIO.read(getClass().getResourceAsStream(c.getCls().getClassifica().get(i).getLogo()));
                ico[i]  = new JLabel(new ImageIcon(bf[i]));
               }catch(Exception e){
                   bf[i] = ImageIO.read(new File(c.getCls().getClassifica().get(i).getLogo()));
                   ico[i]  = new JLabel(new ImageIcon(bf[i]));
               }
                i++;
              
                }
            
            
        } catch (IOException ex) {
            System.out.println("Immagine non letta"); 
        }
        
      
        this.setLayout(new BoxLayout(this, View.X_AXIS));
        
        this.add(Box.createRigidArea(new Dimension(170, 0)));
        for(int j=0; j<i; j++){
            this.add(ico[j]);
            this.add(Box.createRigidArea(new Dimension(170, 0)));
             
        
        }
        
   
        
    }
    
    
    
    
    
    @Override
        public void paint(Graphics g){
        super.paint(g);

        }
    
    
    
}
