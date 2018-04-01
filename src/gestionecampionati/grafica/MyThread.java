
package gestionecampionati.grafica;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Thread per la gestione della progress bar durante il caricamento del calendario 
 * in memoria.
 * @author Enrico
 */
public class MyThread implements Runnable {
    
    /** pannello della progress bar */
    private ProgressPanel panel;
    /** frame principale a cui appartiene il pannello della progress bar */
    private ProgressBarFrame pFrame;
    /** valore assunto dalla progres bar */
    private int value;
    
    /**
     * Costruttore di default del thread
     * @param pFrame riferimento al frame, che va chiuso quando la progress bar arriva al 100%
     */
    public MyThread(ProgressBarFrame pFrame) {
        this.panel=pFrame.getPpanel();
        this.pFrame = pFrame;
    }
    
    

    @Override
    public void run() {
      while(value <100){
            panel.getPbar().setValue(value);
            panel.getPbar().repaint();
            
        
        }

        if(value > 99){
                try {
                    Thread.sleep(600);
                } catch (InterruptedException ex) {
                    Logger.getLogger(MyThread.class.getName()).log(Level.SEVERE, null, ex);
                }
            pFrame.dispose();
        }
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
    
    
}
