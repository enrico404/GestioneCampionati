/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionecampionati.grafica.gestione_calendario;

import gestionecampionati.Campionato;
import gestionecampionati.grafica.MainFrame;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.text.View;

/**
 * Listener del bottone che ricerca una squadra.
 * @author Enrico
 */
public class CercaSquadraActionListener implements ActionListener {
    private GestCSk sk;
    private TextField cerca;
    private Campionato c;
    private CercaSqTableModel model;
    private JTable tabella;
    private JLabel sqnome, nome, sqcitta, citta;
    private JButton stampa;

    /**
     * Costruttore con parametri del listener, prende in input una stringa che va a ricercare nella struttura dati
     * @param cerca nome della squadra da cercare
     * @param sk pannello scheletro da cui recupero il pannello da sovrascrivere
     * @param c struttura dati in cui cerco la squadra
     * 
     */
    public CercaSquadraActionListener(TextField cerca, GestCSk sk, Campionato c) {
        this.sk = sk;
        this.cerca = cerca;
        this.c = c;

        Font font = new Font("sans-serif", Font.BOLD, 16);
        Font font2 = new Font("sans-serif", Font.PLAIN, 16);
        nome = new JLabel("Nome: ");
        nome.setFont(font);
        citta = new JLabel("Città: ");
        citta.setFont(font);
        sqnome = new JLabel();
        sqcitta = new JLabel();
        sqnome.setFont(font2);
        sqcitta.setFont(font2);
     
        stampa = new JButton("Stampa");
        stampa.setMinimumSize(new Dimension(140, 35));
        stampa.setMaximumSize(new Dimension(140, 35));
        stampa.setAlignmentX(Component.CENTER_ALIGNMENT);
       
        stampa.addActionListener(new StampaActionListener(sk));
    }

    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        BufferedImage bf;
        JLabel logo = null;
        boolean esiste= false;
        sk.getPanelDown().setLayout(new BoxLayout(sk.getPanelDown(), View.Y_AXIS));
        int i;
      
        String nomesq = cerca.getText().toLowerCase();
        String nomesqF = nomesq.substring(1, nomesq.length()).toLowerCase();
        nomesq = nomesq.substring(0, 1).toUpperCase() + nomesqF;
       
        for(i=0; i<c.get_numSquadre(); i++)
            if(c.getC().getSquadre().get(i).getNome().equals(nomesq)){
                esiste=true;
                sqnome.setText(c.getC().getSquadre().get(i).getNome());
                sqcitta.setText(c.getC().getSquadre().get(i).getCitta());
               
                break;
            }
       
        if( esiste==true){
         
            try {
                bf = ImageIO.read(new File(c.getC().getSquadre().get(i).getLogo()));
                logo = new JLabel(new ImageIcon(bf));
                 logo.setMaximumSize(new Dimension(120, 160));
                 logo.setMinimumSize(new Dimension(120, 160));
                 logo.setAlignmentX(Component.CENTER_ALIGNMENT);
                
            } catch (IOException ex) {
                Logger.getLogger(CercaSquadraActionListener.class.getName()).log(Level.SEVERE, null, ex);
            }
            
           
             model = new CercaSqTableModel(nomesq, c);
            
            tabella = new JTable(model);
            JScrollPane sc = new JScrollPane(tabella);
            
            
            JPanel info = new JPanel();
            info.setLayout(new FlowLayout());
            info.add(nome);
            info.add(Box.createRigidArea(new Dimension(10, 0)));
            info.add(sqnome);
            info.add(Box.createRigidArea(new Dimension(140, 0)));
            info.add(citta);
            info.add(Box.createRigidArea(new Dimension(10, 0)));
            info.add(sqcitta);
            
            sk.getPanelDown().removeAll();
            sk.getPanelDown().add(Box.createRigidArea(new Dimension(0, 20)));
            sk.getPanelDown().add(logo);
            sk.getPanelDown().add(Box.createRigidArea(new Dimension(0, 40)));
            sk.getPanelDown().add(info);
            sk.getPanelDown().add(Box.createRigidArea(new Dimension(0, 40)));
            sk.getPanelDown().add(sc);
            sk.getPanelDown().add(Box.createRigidArea(new Dimension(0, 40)));
            sk.getPanelDown().add(stampa);
            
            
            sk.getPanelDown().revalidate();
            sk.getPanelDown().repaint();
            esiste=false;
        
        
        }else {
            JLabel err = new JLabel("Squadra non trovata!");
            err.setFont(new Font("sans-serif", Font.PLAIN, 16));
            
            
            sk.getPanelDown().removeAll();
            sk.getPanelDown().add(Box.createRigidArea(new Dimension(30, 40)));
            sk.getPanelDown().add(err);
            sk.getPanelDown().revalidate();
            sk.getPanelDown().repaint();
        }
        
    }
    
}
