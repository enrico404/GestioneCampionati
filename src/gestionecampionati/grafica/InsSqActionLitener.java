/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionecampionati.grafica;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author enrico
 */
class InsSqActionLitener implements ActionListener {

    private MainFrame f;
    private CenterCalcioP panelOld;
    public InsSqActionLitener(MainFrame f, CenterCalcioP panelOld) {
        this.f = f;
        this.panelOld = panelOld;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
     
        InsSqPanel panel = new InsSqPanel(f);
        f.remove(panelOld);
        f.add(panel);
        f.validate();
        f.repaint();
      

       
    }
    
}
