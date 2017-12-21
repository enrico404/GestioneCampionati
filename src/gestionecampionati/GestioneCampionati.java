/*
 * Classe main del sotware
 */
package gestionecampionati;

import java.util.ArrayList;

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
        MyPanel p = new MyPanel(f);
  
        
       
        //f.add(p);
       
        //f.setVisible(true);
        
        ArrayList<Squadra> squadre;
        squadre = new ArrayList<Squadra>();
        Squadra a = new Squadra("a", "roma");
        Squadra b = new Squadra("b", "roma");
        Squadra c = new Squadra("c", "roma");
        Squadra d = new Squadra("d", "roma");
        squadre.add(a);
        squadre.add(b);
        squadre.add(c);
        squadre.add(d);
        
        
        //for(int i = 0; i< squadre.size(); i++) System.out.println(squadre.get(i).getNome());
        
        Calendario c2 = new Calendario(squadre);
        
        c2.genera_calendario();
        c2.stampa_calendario();
        
        
        
        
        
        
        
    }
    
}
