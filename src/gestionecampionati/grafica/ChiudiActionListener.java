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
class ChiudiActionListener implements ActionListener {

    MainFrame f;
    InsSqPanel old;
    public ChiudiActionListener(MainFrame f, InsSqPanel old) {
        this.old = old;
        this.f = f;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        CenterCalcioP panel = new CenterCalcioP(f);
        f.remove(old);
        f.add(panel);
        f.validate();
        f.repaint();
        
    }
    
}
