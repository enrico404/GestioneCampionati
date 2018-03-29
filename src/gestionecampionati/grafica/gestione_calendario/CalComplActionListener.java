/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionecampionati.grafica.gestione_calendario;

import gestionecampionati.Campionato;
import gestionecampionati.grafica.MainFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.text.View;

/**
 *
 * @author Enrico
 */
public class CalComplActionListener implements ActionListener {
    private MainFrame f;
    private GestCSk sk;
    private Campionato c;
    private SkPanelDown pdown;
    
    
    public CalComplActionListener(MainFrame f,GestCSk sk, Campionato c ){
        this.f = f;
        this.sk = sk;
        this.c = c;
        
    
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        sk.getPanelDown().removeAll();
        pdown = new SkPanelDown(c,sk,f);
        sk.getPanelDown().setLayout(new BoxLayout(sk.getPanelDown(), View.Y_AXIS));
        sk.getPanelDown().add(pdown);
        f.revalidate();
        
        
    }
    
}
