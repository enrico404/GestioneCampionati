
package gestionecampionati.grafica.gestione_calendario;

import gestionecampionati.Campionato;
import javax.swing.table.AbstractTableModel;


/**
 * TableModel per gestire la visualizzazione dei dati all'interno della tabella 
 * del girone di ritorno del pannello gestione calendario.
 * @author enrico
 */
public class Cal2TableModel extends AbstractTableModel{
    private Campionato c;
    
    
    String[] colName = {"Casa", "Trasferta", "Risultato"};

    /** 
     * Costruttore del tablemodel, utilizza la struttura dati campionato
     * @param c  struttura dati da cui si recupera il girone di ritorno
     */
    public Cal2TableModel(Campionato c) {
        this.c = c;
    }
   
    @Override
    public int getRowCount() {
        return (c.getC().getGironeRitorno().size());
                
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        String nome, nome2, risultato;
        nome = c.getC().getGironeRitorno().get(rowIndex).getCoppia().getA().getNome();
        nome2 =   c.getC().getGironeRitorno().get(rowIndex).getCoppia().getB().getNome();   
        if(c.getC().getGironeRitorno().get(rowIndex).isGiocata()){
            risultato = new String(c.getC().getGironeRitorno().get(rowIndex).getP().getPa() + " - " +
                    c.getC().getGironeRitorno().get(rowIndex).getP().getPb());
            
        
        
        }else risultato = new String("Non giocata");
                
        switch (columnIndex){
            case 0: return nome;
            case 1: return nome2; 
            case 2: return risultato;
            default: return "";
        
        
        
        }
        
        
        
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public String getColumnName(int column) {
        return colName[column];
    }
    
    
    public void removeRow(int row){
        fireTableRowsDeleted(row, row);
       fireTableDataChanged();
    
    }
    
}
