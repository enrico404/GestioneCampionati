/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionecampionati;
import javax.swing.*;
/**
 *
 * @author enrico
 */
public class MyFrame extends JFrame{
    private int Width = 800;
    private int Heigth =600;
    private String title;
    
    public MyFrame(String title){
        this.setTitle(title);
        this.setSize(Width, Heigth);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(this);
        
    }
    
    
    
}
