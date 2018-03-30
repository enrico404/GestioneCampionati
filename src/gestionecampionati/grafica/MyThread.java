/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionecampionati.grafica;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Enrico
 */
public class MyThread implements Runnable {
    
    
    private ProgressPanel panel;
    private ProgressBarFrame pFrame;
    private int value;
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
