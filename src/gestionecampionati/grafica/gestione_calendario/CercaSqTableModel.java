/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionecampionati.grafica.gestione_calendario;

import gestionecampionati.Campionato;
import javax.swing.table.AbstractTableModel;

/**
 * TabelModel utilizzato per visualizzare in una tabella 
 * tutte le partite giocate da una squadra 
 * @author Enrico
 */
public class CercaSqTableModel extends AbstractTableModel{

    private Campionato c;
    private String nome;
    private Object data[][];
  
    
    String[] colName = {"Casa", "Trasferta", "Risultato"};
    
    /**
     * Costruttore con parametri del table model 
     * @param nome nome della squadra
     * @param c  struttura dati in cui ricercare le partite
     */
    public CercaSqTableModel(String nome, Campionato c) {
        this.c = c;
        this.nome = nome;
        String nome1, nome2, risultato;
        
        data = new Object[200][3];
        int row = 0; 
        
        
        
       
        for(int i=0; i<c.getC().getGironeAndata().size(); i++){
             if(c.getC().getGironeAndata().get(i).isGiocata()){
                    risultato = new String(c.getC().getGironeAndata().get(i).getP().getPa() + " - " +
                     c.getC().getGironeAndata().get(i).getP().getPb());

                 }else risultato = new String(" Non giocata");
                 nome1 = c.getC().getGironeAndata().get(i).getCoppia().getA().getNome();
                 nome2 =  c.getC().getGironeAndata().get(i).getCoppia().getB().getNome();
            if(nome1.equals(nome) || nome2.equals(nome)){
                   data[row][0] = nome1;
                   data[row][1] = nome2;
                   data[row][2] = risultato;
                   row++;
            }
        
        
        }
        
        for(int i=0; i<c.getC().getGironeRitorno().size(); i++){
             if(c.getC().getGironeRitorno().get(i).isGiocata()){
                    risultato = new String(c.getC().getGironeRitorno().get(i).getP().getPa() + " - " +
                     c.getC().getGironeRitorno().get(i).getP().getPb());

                 }else risultato = new String(" Non giocata");
                 nome1 = c.getC().getGironeRitorno().get(i).getCoppia().getA().getNome();
                 nome2 =  c.getC().getGironeRitorno().get(i).getCoppia().getB().getNome();
            if(nome1.equals(nome) || nome2.equals(nome)){
                   data[row][0] = nome1;
                   data[row][1] = nome2;
                   data[row][2] = risultato;
                   row++;
            }
        
        
        }
        
        
        
        
    }
    
       @Override
    public int getRowCount() {
        return ((c.get_numSquadre() - 1)*2);
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
