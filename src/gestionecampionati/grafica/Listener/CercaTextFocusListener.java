/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionecampionati.grafica.Listener;

import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import gestionecampionati.grafica.gestione_calendario.SkPanelUp;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

/**
 *
 * @author enrico
 */
public class CercaTextFocusListener implements FocusListener{
    
    private TextField cerca; 
    public CercaTextFocusListener(TextField cerca){
        this.cerca = cerca;
    
    }

    @Override
    public void focusGained(FocusEvent e) {
        cerca.setText("");
    }

    @Override
    public void focusLost(FocusEvent e) {
        cerca.setText("Inserire squadra");
    }
   


}
