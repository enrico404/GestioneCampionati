
package gestionecampionati.grafica.visualizza_classifica;

import gestionecampionati.Campionato;
import javax.swing.table.AbstractTableModel;

/**
 * TableModel per gestire la tabella inerente alla classifica al termine del campioanato
 * @author enrico
 */
public class ClassificaTableModel extends AbstractTableModel{

    private Campionato c;
    private Object[][] data;
    /** variabile che indica la posizione in classifica della squadra */
    private int cont;
    
    /** nomi delle varie colonne */
    String[] colName = {"Posizione","Squadra", "Punteggio", "Set Vinti"};
    
    
    /**
     * Costruttore del table model per la creazione della tabella della classifica
     * @param c  struttura dati utile al recupero dei risultati
     */
    public ClassificaTableModel(Campionato c) {
        this.c = c;
        if(c.getSport().equals("pallavolo"))
            this.cont = 0;
        else  this.cont = 3;
        data = new Object[200][4];
        int row=0;
        
        
        if(c.getSport().equals("pallavolo")){
             for(int i=0; i<c.get_numSquadre(); i++){
                    data[row][0]= ++cont;
                    data[row][1] = c.getCls().getClassifica().get(i).getNome();
                    data[row][2] = c.getCls().getClassifica().get(i).getPunteggio();
                    data[row][3] = c.getCls().getClassifica().get(i).getPunteggioParziale();
                    row++;

                 }
        
        }
        else {
                 for(int i=3; i<c.get_numSquadre(); i++){
                    data[row][0]= ++cont;
                    data[row][1] = c.getCls().getClassifica().get(i).getNome();
                    data[row][2] = c.getCls().getClassifica().get(i).getPunteggio();
                    row++;

                 }
        }    
       
    }
    
    
    
    @Override
    public int getRowCount() {
        if(c.getSport().equals("pallavolo"))
            return (c.get_numSquadre());
        return (c.get_numSquadre()-3);
        
    }

    @Override
    public int getColumnCount() {
        if(c.getSport().equals("pallavolo"))
         return 4;
        return 3;
    }
    

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        
        return data[rowIndex][columnIndex];
        
    }
    
     @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public String getColumnName(int column) {
        return colName[column];
    }
    
}
