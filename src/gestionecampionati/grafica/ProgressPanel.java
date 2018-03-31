package gestionecampionati.grafica;


import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.text.View;

/**
 * Pannello che contiene la progress bar 
 * @author Enrico
 */

public class ProgressPanel extends JPanel{
         private JProgressBar pbar;
         private JLabel car;

        /**
         * Costruttore di default del pannello
         */
        public ProgressPanel() {
                super();
                this.setLayout(new BoxLayout(this, View.X_AXIS));

                car = new JLabel("Caricamento..");
                car.setAlignmentX(CENTER_ALIGNMENT);
                 
                pbar = new JProgressBar();
                pbar.setMaximum(100);
                pbar.setMinimum(0);
                pbar.setMaximumSize(new Dimension(150, 20));
                pbar.setStringPainted(true);
                
                
                this.add(car);
                this.add(Box.createRigidArea(new Dimension(20,0)));
                this.add(pbar);
                



            }
        
        public void updatePBar(int i){
            pbar.setValue(i);
        
        }

        public JProgressBar getPbar() {
            return pbar;
        }

        public void setPbar(JProgressBar pbar) {
            this.pbar = pbar;
        }


        public JLabel getCar() {
            return car;
        }

        public void setCar(JLabel car) {
            this.car = car;
        }

     
    
     @Override
        public void paint(Graphics g){
        super.paint(g);

        }
    
    }