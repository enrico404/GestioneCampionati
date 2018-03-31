
package gestionecampionati.grafica;

import java.awt.Dimension;
import java.awt.Font;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/**
 * Frame about per la gestione dei crediti.
 * @author Enrico
 */
public class AboutFrame extends JFrame{
    private int Width, Height;
   
    /**
     * Costruttore del frame contente le informazioni sullo sviluppatore
     * @param title titolo del frame
     */
    public AboutFrame(String title) {
        super();
        this.Width = 450;
        this.Height = 120;
        this.setTitle(title);
        this.setSize(Width, Height);
        this.setLocationRelativeTo(this);
        this.setMinimumSize(new Dimension(Width,Height));
        
        
        Font font =  new Font("sans-serif", Font.PLAIN, 14);

        JLabel frase = new JLabel("<html> Programma sviluppato da Sedoni Enrico per l'esame di programmazione ad oggetti.<br>Anno accademico 2017/2018 </html>");
        frase.setFont(font);
        frase.setBorder(new EmptyBorder(10, 20, 0, 10));
       
        
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(frase);
        
        this.add(panel);
        
        
        
        
    }

}
