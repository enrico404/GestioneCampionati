/**
 * Classe main del sotware. Nel progetto sono state usate strutture dati del tipo
* ArrayList poichè non vengono utilizzati thread aggiuntivi e non c'è bisogno che 
* i metodi siano synchronized. Si è preferita quindi utilizzare una struttura dati 
* non thread-safe, ma con maggiori performance.
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
        
        Calendario c2 = new Calendario();
        
        Campionato ca = new Campionato(0, "calcio", squadre, c2);
        
        ca.carica_calendario("calendario");
        
  //      c2.genera_calendario();
        ca.getC().stampa_calendario();
        
//        c2.salva("calendario");
        
        
        
        
        
        
        
    }
    
}
