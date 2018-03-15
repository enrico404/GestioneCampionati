/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionecampionati.grafica.inserimento_risultati;

import gestionecampionati.Campionato;
import gestionecampionati.grafica.MainFrame;
import gestionecampionati.grafica.MenuPanel;
import java.awt.Graphics;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

/**
 *
 * @author Enrico
 */
public class InsRisPanel extends JPanel {
    private MenuPanel menu;
    private Campionato c;
    private MainFrame f;

    public InsRisPanel(MenuPanel menu, Campionato c, MainFrame f) {
        super();
        this.menu = menu;
        this.c = c;
        this.f = f;
        
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        
        
        
        
        
        
    }
    
    @Override
        public void paint(Graphics g){
        super.paint(g);

        }
}
