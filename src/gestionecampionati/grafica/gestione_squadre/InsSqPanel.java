/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionecampionati.grafica.gestione_squadre;

import gestionecampionati.grafica.ChiudiActionListener;
import gestionecampionati.Campionato;
import gestionecampionati.grafica.MainFrame;
import gestionecampionati.grafica.Home.MenuPanel;
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
import javax.swing.text.View;

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
    private Dimension d;
    private Dimension d2;
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
        
 
        
        this.setLayout(new BoxLayout(this,View.Y_AXIS));
         
        
        d=new Dimension(180, 40);
        d2=new Dimension(260, 35);
        
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
        
        
        Tnome.setMinimumSize(d2);
        Tnome.setMaximumSize(d2);
       
        
        Tcitta.setMinimumSize(d2);
        Tcitta.setMaximumSize(d2);
        
        ins.setMaximumSize(d);
        ins.setMinimumSize(d);
        
        insLogo.setMaximumSize(d);
        insLogo.setMinimumSize(d);
        
        esci.setMaximumSize(d);
        esci.setMinimumSize(d);
        
        JLabel hint = new JLabel("Dimensione consigliata (120x160). Formato jpg/png.");
        hint.setAlignmentX(CENTER_ALIGNMENT);
        hint.setFont(new Font("san-serif", Font.PLAIN, 9));
        
        
        add(Box.createRigidArea(new Dimension(0, 80)));
        this.add(nome);
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
