/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionecampionati.grafica.Listener.popMenu;

import gestionecampionati.Campionato;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultListModel;
import javax.swing.JList;

/**
 *
 * @author Enrico
 */
public class EliminaSqActionListener implements ActionListener{

    private Campionato c;
    private JList lista;
    private DefaultListModel listModel;

    public EliminaSqActionListener(Campionato c, JList lista, DefaultListModel listModel) {
        this.c = c;
        this.listModel=listModel;
        this.lista = lista;
    }
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        String nome = lista.getSelectedValue().toString().substring(2);
  
        for(int i=0; i<c.get_numSquadre(); i++){
            if(c.getSquadre().get(i).getNome().equals(nome)){
                System.out.println("Squadra rimossa: "+ c.getSquadre().get(i).getNome());
                c.getSquadre().remove(i);
                listModel.remove(i+1);

            }
        
        }
        
        
    }
    
}
