/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionecampionati.grafica;
import gestionecampionati.Campionato;
import gestionecampionati.Squadra;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
/**
 *
 * @author enrico
 */
public class MenuBar extends JMenuBar{

    private JMenu file;
    private JMenu edit; 
    private JMenu help;
    private Campionato c;
    private MainFrame fr;
    private CalcioPanel panel;
    private DefaultListModel<Squadra> lista;
    
    
    public MenuBar(Campionato c, MainFrame fr, CalcioPanel panel, DefaultListModel lista) {
        this.c = c;
        this.lista = lista;
        this.panel = panel;
        this.fr = fr;
        Font f = new Font("sans-serif", Font.PLAIN, 12);
        file = new JMenu("File");
        file.setFont(f);
        
        
        edit = new JMenu("Edit");
        edit.setFont(f);
        
        help = new JMenu("Help");
        help.setFont(f);
    /*    
        JMenuItem nuovo = new JMenuItem("Crea campionato");
        nuovo.setFont(f);
      */  
        JMenuItem apri = new JMenuItem("Apri.. "); //insieme al calendario devo caricare il file dei risultati
        apri.setFont(f);
        
        JMenuItem salva = new JMenuItem("Salva"); //salvo sia calendario, sia risultati su file diversi
        salva.setFont(f);
        
        JMenuItem insSq = new JMenuItem("Inserisci squadre");
        insSq.setFont(f);
        
        
        JMenuItem insRis = new JMenuItem("Inserisci risultati");
        insRis.setFont(f);
        
        JMenuItem visClass = new JMenuItem("Visualizza classifica");
        visClass.setFont(f);
        
        JMenuItem exit = new JMenuItem("Esci");
        exit.setFont(f);
        
        
        JMenuItem modRis = new JMenuItem("Modifica risultati");
        modRis.setFont(f);
        
        JMenuItem RemSq = new JMenuItem("Rimuovi squadre");
        RemSq.setFont(f);
        
        
        JMenuItem about = new JMenuItem("About");
        about.setFont(f);
        
        
        
        exit.addActionListener(new ExitActionListener());
        apri.addActionListener(new ApriActionListener(c,fr, panel, lista));
        salva.addActionListener(new SalvaActionListener(c,fr));
        
        
       
        file.add(apri);
        file.add(salva);
        file.add(insSq);
        file.add(insRis);
        file.add(visClass);
        file.addSeparator();
        file.add(exit);
        
        edit.add(modRis);
        edit.add(RemSq);

        
        help.add(about);
        
        this.add(file);
        this.add(edit);
        this.add(help);
    }
    
  

    
    
}

