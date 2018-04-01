
package gestionecampionati.grafica.popMenu;

import gestionecampionati.Campionato;
import gestionecampionati.grafica.gestione_squadre.ApriLogoActionListener;
import static java.awt.Component.CENTER_ALIGNMENT;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.text.View;

/**
 * Pannello principale ddel frame fluattuante modificare risultati di una giornata
 * selezioanata dal calendario
 * @author Enrico
 */
public class ModSqPanel extends JPanel {

    private Campionato c;
    private JList lista;
    private DefaultListModel listModel;
    private JLabel nome;
    private JLabel citta;
    private TextField Tnome;
    private TextField Tcitta;
    private JButton modifica, modificaL;
    private Dimension d;
    private Dimension d2;
    private JFrame f;
    
    
    /**
     * Costruttore del pannello di modifica dei risultati di una giornata 
     * @param c struttura dati principale
     * @param lista lista da cui recuperare la giornata selezionata
     * @param listModel listmodel da aggiornate
     * @param f  frame in cui aggiungere il pannello
     */
    public ModSqPanel(Campionato c, JList lista, DefaultListModel listModel, JFrame f) {
        this.c= c;
        this.lista=lista;
        this.listModel = listModel;
        this.f  = f;
        this.setLayout(new BoxLayout(this,View.Y_AXIS));
         
        
     
        d2=new Dimension(220, 30);
        
        nome = new JLabel("Nome: ");
        citta = new JLabel("Città: ");

        nome.setAlignmentX(CENTER_ALIGNMENT);
        citta.setAlignmentX(CENTER_ALIGNMENT);
        
        
        Tnome = new TextField();
        Tcitta = new TextField();
        
     
        
        modifica = new JButton("Modifica");
        modifica.setAlignmentX(CENTER_ALIGNMENT);
        modificaL = new JButton("Modifica logo");
        modificaL.setAlignmentX(CENTER_ALIGNMENT);
        
        
        Tnome.setMinimumSize(d2);
        Tnome.setMaximumSize(d2);
       
        
        Tcitta.setMinimumSize(d2);
        Tcitta.setMaximumSize(d2);
        
        String squadra = lista.getSelectedValue().toString().substring(2);
      
         for(int i=0; i<c.get_numSquadre(); i++){
            if(c.getSquadre().get(i).getNome().equals(squadra)){
              Tnome.setText(c.getSquadre().get(i).getNome());
              Tcitta.setText(c.getSquadre().get(i).getCitta());
            }
        
        }
        ApriLogoActionListener apri = new ApriLogoActionListener(f);
        modifica.addActionListener(new ModificaActionListener(f,c,Tnome,Tcitta, squadra, apri));
        modificaL.addActionListener(apri);
         
        this.add(Box.createRigidArea(new Dimension(0, 5)));
        this.add(nome);
        this.add(Tnome );
        this.add(citta);
        this.add(Tcitta);
        this.add(Box.createRigidArea(new Dimension(0, 10)));
        this.add(modificaL);
        this.add(Box.createRigidArea(new Dimension(0, 10)));
        this.add(modifica);
     
 
        
    }
    
    
    /** 
     * Listener del bottone modifica risultati
     */
    public class ModificaActionListener implements ActionListener{
        private Campionato c;
        private TextField Tnome;
        private TextField Tcitta;
        private String squadra;
        private JFrame f;
        private ApriLogoActionListener apri;
        
        /**
         * Costruttore del listener, recupera i dati inseriti dall'utente e li inserisce 
         * nella struttura dati
         * @param f frame fluttuante di riferimento 
         * @param c struttura dati principale
         * @param Tnome campo di testo del nome 
         * @param Tcitta campo di testo della citta
         * @param squadra nome della squadra
         * @param apri  listener per recuperare il path del logo
         */
        public ModificaActionListener(JFrame f, Campionato c, TextField Tnome, TextField Tcitta, String squadra, ApriLogoActionListener apri) {
            this.c = c;
            this.Tnome = Tnome;
            this.Tcitta = Tcitta;
            this.squadra = squadra;
            this.f = f;
            this.apri = apri;
        }

        
        
        
        @Override
        public void actionPerformed(ActionEvent e) {
            
            for(int i=0; i<c.get_numSquadre(); i++){
                if(c.getSquadre().get(i).getNome().equals(squadra)){
              
                    c.getSquadre().get(i).setNome(Tnome.getText());
                    c.getSquadre().get(i).setCitta(Tcitta.getText());

                    listModel.setElementAt("- "+Tnome.getText() , i+1);
                    
                    if(!(apri.getPath().isEmpty())){ c.getSquadre().get(i).setLogo(apri.getPath()); System.out.println("Logo cambiato"+ apri.getPath());
                    apri.setPath("");
                    }
                    
                    
                    f.dispose();
              
                 }
        
             }
        }
    }
    
    
    
    @Override
        public void paint(Graphics g){
        super.paint(g);

        
        }
}
