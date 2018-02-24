/*
 * Pannello contenente la home page del software
 */
package gestionecampionati.grafica;
import java.awt.AlphaComposite;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.*;
/**
 *
 * @author enrico
 */
public class HomePanel extends JPanel implements ActionListener{
    
        private JButton calcio;
        private JButton rugby;
        private JButton pallavolo;
        private Dimension button;
        private JLabel text;
        private Font f; 
        private MainFrame fr; 
        private BufferedImage sfondo;
        private JPanel calcioPanel;
        
    
    
        public HomePanel(MainFrame fr, JPanel calcioPanel){
          
            
            super();
            
            this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
            
            int W = fr.getWidth();
            int H = fr.getHeight();
            
            this.calcioPanel = calcioPanel; 
            button = new Dimension(200, 50);
            calcio = new JButton("Calcio");
            rugby = new JButton("Rugby");
            pallavolo = new JButton("Pallavolo");
            text = new JLabel("Scegli lo sport: ");
            this.fr = fr;
          
            text.setAlignmentX(CENTER_ALIGNMENT);
            
            try {
                sfondo = ImageIO.read(new File("../GestioneCampionati/media/HomeBackground.png"));
            } catch (IOException ex) {
                Logger.getLogger(HomePanel.class.getName()).log(Level.SEVERE, null, ex);
            }
        
           // JLabel back = new JLabel(new ImageIcon("../GestioneCampionati/media/HomeBackground.png"));
   
           // this.add(back);
            //fr.setContentPane(back);
        
           // JLabel back = new JLabel(new ImageIcon("../GestioneCampionati/media/HomeBackground.png"));
   
           // this.add(back);
            //fr.setContentPane(back);
            
            
            f = new Font( "TimesRoman", Font.PLAIN , 50);
            text.setFont(f);
            
            
            
            
            /** Posizione e dimensioni bottoni */
            calcio.setAlignmentX(CENTER_ALIGNMENT);
            calcio.setPreferredSize(button);
            calcio.setMaximumSize(button);
             calcio.setMinimumSize(button);
            rugby.setAlignmentX(CENTER_ALIGNMENT);
            rugby.setPreferredSize(button);
            rugby.setMaximumSize(button);
            rugby.setMinimumSize(button);
            pallavolo.setAlignmentX(CENTER_ALIGNMENT);
            pallavolo.setPreferredSize(button);
            pallavolo.setMinimumSize(button);
            pallavolo.setMaximumSize(button);
            
            
            calcio.addActionListener(this);
            rugby.addActionListener(this);
            pallavolo.addActionListener(this);
            
            
            
           
          
            
            /** Aggiunta componenti al pannello */
           
            add(Box.createRigidArea(new Dimension(0, 100)));
            add(text);
            add(Box.createRigidArea(new Dimension(0, 40)));
            add(calcio);
            add(Box.createRigidArea(new Dimension(0, 20)));
            add(pallavolo);
            add(Box.createRigidArea(new Dimension(0, 20)));
            add(rugby);
      
            
            
            
          
        
        }
        
        
        
        @Override
        public void paint(Graphics g){
        super.paint(g);
       

        }
        
    

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == calcio) {
            
                                    System.out.println("calcio"); 
                                    fr.clean(); //rimuovo il vecchio pannello
                                    fr.setContentPane(calcioPanel); //aggiungo il pannello selezionato
                                    fr.validate(); // rendo valido il frame e faccio lavorare il layout manager per settarmi le coordinate dei component
                                  
                                    repaint();
                                    }
        if(e.getSource() == rugby) {System.out.println("rugby"); this.setVisible(false);}
        if(e.getSource() == pallavolo) {System.out.println("pallavolo"); this.setVisible(false);}
        
        
        
    }
    
    
    
}
