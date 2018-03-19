/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionecampionati.grafica.visualizza_classifica;

import gestionecampionati.Campionato;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author enrico
 */
public class ClassificaTableModel extends AbstractTableModel{

    private Campionato c;
    private Object[][] data;
    private int cont;
    

    String[] colName = {"Posizione","Squadra", "Punteggio"};
    public ClassificaTableModel(Campionato c) {
        this.c = c;
        this.cont = 3;
        data = new Object[200][3];
        int row=0;
        for(int i=3; i<c.get_numSquadre(); i++){
            data[row][0]= ++cont;
            data[row][1] = c.getCls().getClassifica().get(i).getNome();
            data[row][2] = c.getCls().getClassifica().get(i).getPunteggio();
            row++;
        
        }
    }
    
    
    
    @Override
    public int getRowCount() {
        return (c.get_numSquadre()-3);
        
    }

    @Override
    public int getColumnCount() {
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
