/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor..0
 */
package gestionecampionati;
import javax.swing.*;
/**
 *
 * @author enrico
 */
public class MyFrame extends JFrame{
    private static final int Width = 800;
    private static final int Heigth =600;

    public int getWidth() {
        return Width;
    }

    public int getHeigth() {
        return Heigth;
    }
    private String title;
    
    public MyFrame(String title){
        this.setTitle(title);
        this.setSize(Width, Heigth);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(this);
      
    }
    
    
    
}
