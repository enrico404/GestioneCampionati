/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionecampionati.grafica;
import gestionecampionati.grafica.Listener.GestCalActionListener;
import gestionecampionati.grafica.Listener.InsSqActionLitener;
import gestionecampionati.grafica.Listener.ApriActionListener;
import gestionecampionati.grafica.Listener.ExitActionListener;
import gestionecampionati.grafica.Listener.SalvaActionListener;
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
    private MenuPanel centerPanel;
    
    
    public MenuBar(Campionato c, MainFrame fr, CalcioPanel panel, DefaultListModel lista, MenuPanel centerPanel ) {
        this.c = c;
        this.lista = lista;
        this.panel = panel;
        this.centerPanel = centerPanel;
        this.fr = fr;
        Font f = new Font("sans-serif", Font.PLAIN, 12);
        file = new JMenu("File");
        file.setFont(f);
        
        
        edit = new JMenu("Edit");
        edit.setFont(f);
        
        help = new JMenu("Help");
        help.setFont(f);
 
    
    
        JMenuItem nuovo = new JMenuItem("Nuovo..");
        nuovo.setFont(f);
        
        
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
        
        
        JMenuItem expSq = new JMenuItem("Esporta squadre su file");
        expSq.setFont(f);
        
        JMenuItem impSq = new JMenuItem("Importa squadre da file");
        impSq.setFont(f);
        
        
        
        
        JMenuItem exit = new JMenuItem("Esci");
        exit.setFont(f);
        
        
        JMenuItem modRis = new JMenuItem("Modifica risultati");
        modRis.setFont(f);
        
        JMenuItem RemSq = new JMenuItem("Rimuovi squadre");
        RemSq.setFont(f);
        
        
        JMenuItem about = new JMenuItem("About");
        about.setFont(f);
        
        JMenuItem gestCal = new JMenuItem("Gestione calendario");
        gestCal.setFont(f);
        
        exit.addActionListener(new ExitActionListener());
        apri.addActionListener(new ApriActionListener(c,fr, panel, lista, 0));
        salva.addActionListener(new SalvaActionListener(c,fr, 0));
        impSq.addActionListener(new ApriActionListener(c, fr, panel, lista, 1));
        expSq.addActionListener(new SalvaActionListener(c, fr, 1));
        insSq.addActionListener(new InsSqActionLitener(fr, centerPanel , c, lista));
        gestCal.addActionListener(new GestCalActionListener(fr, centerPanel, c, lista));
        nuovo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                c.nuovo("Calcio");
                lista.removeAllElements();
                lista.addElement("Squadre: ");
            }
        });
        
        
        file.add(nuovo);
        file.add(apri);
        file.add(salva);
        file.add(insSq);
        file.add(impSq);
        file.add(expSq);
        file.add(gestCal);
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

