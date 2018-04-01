
package gestionecampionati.grafica.gestione_squadre;


import gestionecampionati.Campionato;
import gestionecampionati.Squadra;
import gestionecampionati.grafica.Errors_Confirm.ErrorPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultListModel;

/**
 *  Listener del pulsante inserisci nel pannello di inserimento squadre. Prima di inserire la 
 * squadra nel campionato verifica che siano stati inseriti sia nome della squadra che citta
 * @author enrico
 */
public class InsActionListener implements ActionListener {
    
    private Campionato c;
    private InsSqPanel panel;
    private DefaultListModel<String> listmodel;
    private ApriLogoActionListener apri;
    
    /**
     * Costruttore con parametri del listener, recupera in vari dati
     * @param c struttura dati in cui inserire la nuova squadra
     * @param panel pannello da cui recuperare nome e citta inseriti dall'utente
     * @param listmodel lista delle squadre partecipanti al campionato
     * @param apri  lister aprilogo da cui recuperare il path del logo se inserito dall'utente
     */
    public InsActionListener(Campionato c, InsSqPanel panel, DefaultListModel<String> listmodel, ApriLogoActionListener apri) {
        this.c = c;
        this.panel = panel;
        this.listmodel = listmodel;
        this.apri = apri;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ErrorPanel err;
        Squadra sq;

               if(!(apri.getPath().isEmpty())){ 
               
                    sq= new Squadra(panel.getTnome().getText(), panel.getTcitta().getText(), apri.getPath());  
                    apri.setPath("");
               }
               else sq= new Squadra(panel.getTnome().getText(), panel.getTcitta().getText());
        
        if(c == null )System.out.print("campionato non inizializzato");
        if(sq == null ) System.out.print("squadra non inizializzata");

        
        if(!(panel.getTnome().getText().isEmpty())){
            if(!(panel.getTcitta().getText().isEmpty())){
           
               if(!(c.inserisci_squadra(sq))){
                   err = new ErrorPanel(9); 
                   return;
               };
               listmodel.addElement("- " + sq.getNome());
               
               System.out.println("Nome : "+ sq.getNome());
                 System.out.println("Citta: "+ sq.getCitta());
                 System.out.println("logo: "+ sq.getLogo());
               
               panel.getTnome().setText("");
               panel.getTcitta().setText("");
               
    
            }
        }    
        else {
             err = new ErrorPanel(5);
             
            
            }

    }
    
}
