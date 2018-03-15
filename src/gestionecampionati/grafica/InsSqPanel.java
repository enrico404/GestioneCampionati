/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionecampionati.grafica;

import gestionecampionati.grafica.Listener.InsActionListener;
import gestionecampionati.grafica.Listener.ChiudiActionListener;
import gestionecampionati.Campionato;
import gestionecampionati.grafica.Listener.ApriActionListener;
import gestionecampionati.grafica.Listener.ApriLogoActionListener;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.TextField;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author enrico
 */
public class InsSqPanel extends JPanel{

    
    private JLabel nome;
    private JLabel citta;
    private TextField Tnome;
    private TextField Tcitta;
    private JButton ins;
    private JButton insLogo;
    private JButton esci;
    private Dimension text;
    private Dimension text2;
    private Campionato c;
    private MainFrame f;
    private DefaultListModel<String> listmodel;
    private MenuPanel centP;
    
    
    
    public InsSqPanel(MainFrame f, Campionato c, DefaultListModel<String> listmodel, MenuPanel centP) {
        super();
        this.c = c;
        this.f = f;
        this.listmodel = listmodel;
        this.centP = centP;
        
 
        
        
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        
        text=new Dimension(140, 40);
        text2=new Dimension(260, 35);
        
        nome = new JLabel("Nome: ");
        citta = new JLabel("Città: ");
       
        
        
        
        nome.setAlignmentX(CENTER_ALIGNMENT);
        citta.setAlignmentX(CENTER_ALIGNMENT);
        
        
        Tnome = new TextField();
        Tcitta = new TextField();
        
     
        insLogo = new JButton("Inserisci logo");
        ins = new JButton("Inserisci");
        esci = new JButton("Chiudi");
        
        ins.setAlignmentX(CENTER_ALIGNMENT);
        esci.setAlignmentX(CENTER_ALIGNMENT);
        insLogo.setAlignmentX(CENTER_ALIGNMENT);
        
        
        Tnome.setMinimumSize(text2);
        Tnome.setMaximumSize(text2);
       
        
        Tcitta.setMinimumSize(text2);
        Tcitta.setMaximumSize(text2);
        
        ins.setMaximumSize(text);
        ins.setMinimumSize(text);
        
        insLogo.setMaximumSize(text);
        insLogo.setMinimumSize(text);
        
        esci.setMaximumSize(text);
        esci.setMinimumSize(text);
        
        JLabel hint = new JLabel("Dimensione consigliata (120x120)");
        hint.setAlignmentX(CENTER_ALIGNMENT);
        hint.setFont(new Font("san-serif", Font.PLAIN, 10));
        
        
        add(Box.createRigidArea(new Dimension(0, 80)));
        this.add(nome, BorderLayout.NORTH);
        this.add(Tnome );
        this.add(citta);
        this.add(Tcitta);
        add(Box.createRigidArea(new Dimension(0, 15)));
        this.add(hint);
        add(Box.createRigidArea(new Dimension(0, 5)));
        this.add(insLogo);
        add(Box.createRigidArea(new Dimension(0, 20)));
        this.add(ins);
        add(Box.createRigidArea(new Dimension(0, 35)));
        this.add(esci);
       
        
        ApriLogoActionListener apri = new ApriLogoActionListener(f);
        
        insLogo.addActionListener(apri);
        
        esci.addActionListener(new ChiudiActionListener(f, this, centP));
        
        ins.addActionListener(new InsActionListener(c, this, listmodel, apri));
        
        
        
        
    }
    
       public TextField getTnome() {
        return Tnome;
    }

    public void setTnome(TextField Tnome) {
        this.Tnome = Tnome;
    }

    public TextField getTcitta() {
        return Tcitta;
    }

    public void setTcitta(TextField Tcitta) {
        this.Tcitta = Tcitta;
    }
    
       @Override
        public void paint(Graphics g){
        super.paint(g);
       
       

        }
    
    
    
    
    
}
