/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionecampionati.grafica.gestione_calendario;

import gestionecampionati.Campionato;
import javax.swing.table.AbstractTableModel;
import gestionecampionati.Calendario;


/**
 *
 * @author enrico
 */
public class Cal2TableModel extends AbstractTableModel{
    private Campionato c;
    
    
    String[] colName = {"Casa", "Trasferta", "Risultato"};

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
            
        
        
        }else risultato = new String(" Non giocata");
                
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
