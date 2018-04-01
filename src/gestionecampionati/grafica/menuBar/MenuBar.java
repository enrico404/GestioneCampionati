
package gestionecampionati.grafica.menuBar;
import gestionecampionati.grafica.Home.MainPanel;
import gestionecampionati.grafica.Home.MenuPanel;
import gestionecampionati.grafica.gestione_calendario.GestCalActionListener;
import gestionecampionati.grafica.gestione_squadre.InsSqActionLitener;
import gestionecampionati.Campionato;
import gestionecampionati.Squadra;
import gestionecampionati.grafica.Home.InsRis2ActionListener;
import gestionecampionati.grafica.Home.InsRisActionListener;
import gestionecampionati.grafica.MainFrame;
import gestionecampionati.grafica.visualizza_classifica.VisualizzaClassificaActionListener;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;



/**
 * Classe menu bar, è la menu bar ricorrente in tutto il programma. Offre funzionalità 
 * utili come caricamento del calendario, importazione di squadre, esportazione di calendario
 * e squadre, informazioni sullo sviluppatore etc..
 * @author enrico
 */
public class MenuBar extends JMenuBar{

    private JMenu file;
    private JMenu edit; 
    private JMenu help;
    private Campionato c;
    private MainFrame fr;
    private MainPanel panel;
    private DefaultListModel<Squadra> lista;
    private MenuPanel centerPanel;
    private JMenuItem nuovo, apri, salva, insSq, insRis, visClass, expSq, impSq, exit, about, gestCal;
    
 
    
    /**
     * Costruttore con parametri della menu bar
     * @param c struttura dati che modifica in caso di azzeramento del campionato
     * @param fr fame in inserire i vari pannelli
     * @param lista lista delle squadre partecipanti al campioanto da aggiornare
     * @param centerPanel  pannello menu
     */
    public MenuBar(Campionato c, MainFrame fr, DefaultListModel lista, MenuPanel centerPanel ) {
        this.c = c;
        this.lista = lista;
        this.centerPanel = centerPanel;
        this.fr = fr;
        Font f = new Font("sans-serif", Font.PLAIN, 12);
        file = new JMenu("File");
        file.setFont(f);
        

        edit = new JMenu("Edit");
        edit.setFont(f);
        
        help = new JMenu("Help");
        help.setFont(f);
 
        
    
        nuovo = new JMenuItem("Nuovo..");
        nuovo.setFont(f);
        
        
        apri = new JMenuItem("Apri.. "); //insieme al calendario devo caricare il file dei risultati
        apri.setFont(f);
        
        salva = new JMenuItem("Salva"); //salvo sia calendario, sia risultati su file diversi
        salva.setFont(f);
        
        insSq = new JMenuItem("Inserisci squadre");
        insSq.setFont(f);
        
        
        insRis = new JMenuItem("Inserisci risultati");
        insRis.setFont(f);
        
        visClass = new JMenuItem("Visualizza classifica");
        visClass.setFont(f);
        
        
        expSq = new JMenuItem("Esporta squadre su file");
        expSq.setFont(f);
        
        impSq = new JMenuItem("Importa squadre da file");
        impSq.setFont(f);
        
        
        
        
        exit = new JMenuItem("Esci");
        exit.setFont(f);
        
        about = new JMenuItem("About");
        about.setFont(f);
        
        gestCal = new JMenuItem("Gestione calendario");
        gestCal.setFont(f);
        
        
        exit.addActionListener(new ExitActionListener());
        apri.addActionListener(new ApriActionListener(c,fr, lista, 0));
        salva.addActionListener(new SalvaActionListener(c,fr, 0));
        impSq.addActionListener(new ApriActionListener(c, fr, lista, 1));
        expSq.addActionListener(new SalvaActionListener(c, fr, 1));
        insSq.addActionListener(new InsSqActionLitener(fr, centerPanel , c, lista));
        gestCal.addActionListener(new GestCalActionListener(fr,centerPanel, c));
        visClass.addActionListener(new VisualizzaClassificaActionListener(c, centerPanel, fr));
        about.addActionListener(new AboutFrameListener());
        
        if(c.getSport().equals("pallavolo")){
            insRis.addActionListener(new InsRis2ActionListener(fr, centerPanel, c));
        }else insRis.addActionListener(new InsRisActionListener(fr, centerPanel, c));
        nuovo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String sport = c.getSport();
                c.nuovo(sport);
                lista.removeAllElements();
                lista.addElement("Squadre: ");
            }
        });
        
        
        file.add(nuovo);
        file.add(apri);
        file.add(salva);
        file.add(impSq);
        file.add(expSq);
        file.addSeparator();
        file.add(exit);
 

        
        help.add(about);
        
        this.add(file);
        this.add(help);
    }


    
    
  

    
    
}

