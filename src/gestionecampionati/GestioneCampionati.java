/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionecampionati;

/**
 *
 * @author enrico
 */
public class GestioneCampionati {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MyFrame f = new MyFrame("Gestione Campionati");
        MyPanel p = new MyPanel();
        
        f.add(p);
        f.setVisible(true);
        
    }
    
}
