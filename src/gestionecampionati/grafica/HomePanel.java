/*
 * Pannello contenente la home page del software
 */
package gestionecampionati.grafica;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
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
        private JButton basket;
        private JButton pallavolo;
        private Dimension button;
        private JLabel text;
        private Font f; 
        private MainFrame fr; 
        private BufferedImage sfondo;
 
       
      
        
    
    
        public HomePanel(MainFrame fr){
          
            
            super();
            
            this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
            
            int W = fr.getWidth();
            int H = fr.getHeight();
            
           
            button = new Dimension(200, 50);
            calcio = new JButton("Calcio");
            basket = new JButton("Basket");
            pallavolo = new JButton("Pallavolo");
            text = new JLabel("Scegli lo sport: ");
            this.fr = fr;
          
            text.setAlignmentX(CENTER_ALIGNMENT);
            
            try {
                sfondo = ImageIO.read(new File("../GestioneCampionati/media/HomeBackground.png"));
            } catch (IOException ex) {
                Logger.getLogger(HomePanel.class.getName()).log(Level.SEVERE, null, ex);
            }
        
          
            
            
            f = new Font( "TimesRoman", Font.PLAIN , 50);
            text.setFont(f);
            
            
            
            
            /** Posizione e dimensioni bottoni */
            calcio.setAlignmentX(CENTER_ALIGNMENT);
            calcio.setPreferredSize(button);
            calcio.setMaximumSize(button);
             calcio.setMinimumSize(button);
            basket.setAlignmentX(CENTER_ALIGNMENT);
            basket.setPreferredSize(button);
            basket.setMaximumSize(button);
            basket.setMinimumSize(button);
            pallavolo.setAlignmentX(CENTER_ALIGNMENT);
            pallavolo.setPreferredSize(button);
            pallavolo.setMinimumSize(button);
            pallavolo.setMaximumSize(button);
            
            
            calcio.addActionListener(this);
            basket.addActionListener(this);
            pallavolo.addActionListener(this);
            
            
            
           
          
            
            /** Aggiunta componenti al pannello */
           
            add(Box.createRigidArea(new Dimension(0, 100)));
            add(text);
            add(Box.createRigidArea(new Dimension(0, 40)));
            add(calcio);
            add(Box.createRigidArea(new Dimension(0, 20)));
            add(pallavolo);
            add(Box.createRigidArea(new Dimension(0, 20)));
            add(basket);
      
            
            
            
          
        
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
                                    fr.setContentPane(new MainPanel(fr,1));
                                    fr.validate();
                                       
                                    
                                 
                                    }
        if(e.getSource() == pallavolo) {
                                    System.out.println("pallavolo");          
                                    fr.clean(); //rimuovo il vecchio pannello
                                    fr.setContentPane(new MainPanel(fr,2));
                                    fr.validate();
        
        }
        
        if(e.getSource() == basket) {
                                    System.out.println("basket");          
                                    fr.clean(); //rimuovo il vecchio pannello
                                    fr.setContentPane(new MainPanel(fr,3));
                                    fr.validate();
        
            }
 
        
    }

}
