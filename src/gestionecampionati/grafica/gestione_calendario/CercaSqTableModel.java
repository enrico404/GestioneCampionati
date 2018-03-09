/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionecampionati.grafica.gestione_calendario;

import gestionecampionati.Campionato;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Enrico
 */
public class CercaSqTableModel extends AbstractTableModel{

    private Campionato c;
    private String nome;
    private int size;
    
    String[] colName = {"Casa", "Trasferta", "Risultato"};
    
    public CercaSqTableModel(String nome, Campionato c) {
        this.c = c;
        this.nome = nome;
        
        
        
    }
    
    
    
    @Override
    public int getRowCount() {
        return 10;
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        
        String nome1, nome2, risultato;
        
        for(int i=0; i< c.getC().getGironeAndata().size(); i++){
            nome1 = c.getC().getGironeAndata().get(i).getCoppia().getA().getNome();
            nome2 =  c.getC().getGironeAndata().get(i).getCoppia().getB().getNome();
            risultato = c.getC().getGironeAndata().get(i).getP().getPa() + " - "+c.getC().getGironeAndata().get(i).getP().getPb();
                if(nome1.equals(nome) || nome2.equals(nome) ){
                     switch (columnIndex){
                         case 0: return nome1;
                         case 1: return nome2; 
                         case 2: return risultato;
                         default: return "";
        

                         }
                
                }
        
        }
        
          for(int i=0; i< c.getC().getGironeRitorno().size(); i++){
            nome1 = c.getC().getGironeRitorno().get(i).getCoppia().getA().getNome();
            nome2 =  c.getC().getGironeRitorno().get(i).getCoppia().getB().getNome();
            risultato = c.getC().getGironeRitorno().get(i).getP().getPa() + " - "+c.getC().getGironeRitorno().get(i).getP().getPb();
                if(nome1.equals(nome) || nome2.equals(nome) ){
                     switch (columnIndex){
                         case 0: return nome1;
                         case 1: return nome2; 
                         case 2: return risultato;
                         default: return "";
        

                         }
                
                }
        
        }

        return "";
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
