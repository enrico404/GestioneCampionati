
package gestionecampionati.grafica.popMenu;

import gestionecampionati.Campionato;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultListModel;
import javax.swing.JList;

/**
 *  Listener di "elimina" presente nel pop menu visualizzato all'interno della lista 
 * di squadre partecipanti al campionato
 * @author Enrico
 */
public class EliminaSqActionListener implements ActionListener{

    private Campionato c;
    private JList lista;
    private DefaultListModel listModel;

    /**
     * Costruttore, prende in input la listaper recuperare la riga selezionata e il list model
     * da modificare
     * @param c struttura dati da aggiornare
     * @param lista jlist da cui recuperare la riga da eliminare 
     * @param listModel  list model da modificare
     */
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
