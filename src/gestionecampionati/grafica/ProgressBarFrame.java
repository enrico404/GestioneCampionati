
package gestionecampionati.grafica;

import java.awt.Dimension;
import javax.swing.JFrame;

/**
 * Frame che si apre durante il caricamento del calendario in memoria
 * @author Enrico
 */
public class ProgressBarFrame extends JFrame {
    private ProgressPanel ppanel;

    /**
     * Costruttore con parametri del frame
     * @param title titolo della finestra
     */
    public ProgressBarFrame(String title) {
      
        ppanel = new ProgressPanel();
        
        this.setTitle(title);
       
        
        this.setSize(new Dimension(400,200));
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        
        this.add(ppanel);
        
    }

    public ProgressPanel getPpanel() {
        return ppanel;
    }

    public void setPpanel(ProgressPanel ppanel) {
        this.ppanel = ppanel;
    }

  

   
     

}
