/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionecampionati.grafica;

import gestionecampionati.Campionato;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
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
class InsSqPanel extends JPanel{

    
    private JLabel nome;
    private JLabel citta;
    private TextField Tnome;
    private TextField Tcitta;
    private JButton ins;
    private JButton esci;
    private Dimension text;
    private Dimension text2;
    private Campionato c;
    private MainFrame f;
    private DefaultListModel<String> listmodel;
    
    
    public InsSqPanel(MainFrame f, Campionato c, DefaultListModel<String> listmodel) {
        super();
        this.c = c;
        this.f = f;
        this.listmodel = listmodel;
        
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        
        text=new Dimension(140, 40);
        text2=new Dimension(260, 35);
        
        nome = new JLabel("Nome: ");
        citta = new JLabel("Città: ");
        ins = new JButton("Inserisci");
        esci = new JButton("Esci");
        
        
        nome.setAlignmentX(CENTER_ALIGNMENT);
        citta.setAlignmentX(CENTER_ALIGNMENT);
        
        
        Tnome = new TextField();
        Tcitta = new TextField();
        
     
        
        ins = new JButton("Inserisci");
        esci = new JButton("Chiudi");
        
        ins.setAlignmentX(CENTER_ALIGNMENT);
        esci.setAlignmentX(CENTER_ALIGNMENT);
        
        
        Tnome.setMinimumSize(text2);
        Tnome.setMaximumSize(text2);
       
        
        Tcitta.setMinimumSize(text2);
        Tcitta.setMaximumSize(text2);
        
        ins.setMaximumSize(text);
        ins.setMinimumSize(text);
        
        esci.setMaximumSize(text);
        esci.setMinimumSize(text);
        
        
        add(Box.createRigidArea(new Dimension(0, 80)));
        this.add(nome, BorderLayout.NORTH);
        this.add(Tnome );
        this.add(citta);
        this.add(Tcitta);
        add(Box.createRigidArea(new Dimension(0, 40)));
        this.add(ins);
        add(Box.createRigidArea(new Dimension(0, 20)));
        this.add(esci);
        
        
        esci.addActionListener(new ChiudiActionListener(f, this, c, listmodel));
        ins.addActionListener(new InsActionListener(c, this, listmodel));
        
        
        
        
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
    
    
    
    
    
    
    
}
