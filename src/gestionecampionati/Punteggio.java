/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionecampionati;

/**
 *
 * @author enrico
 */
public class Punteggio {
    private Squadra a;
    private Squadra b;
    private int pa;
    private int pb;
    private Data data;

    public Squadra getA() {
        return a;
    }

    public void setA(Squadra a) {
        this.a = a;
    }

    public Squadra getB() {
        return b;
    }

    public void setB(Squadra b) {
        this.b = b;
    }

    public int getPa() {
        return pa;
    }

    public void setPa(int pa) {
        this.pa = pa;
    }

    public int getPb() {
        return pb;
    }

    public void setPb(int pb) {
        this.pb = pb;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public Punteggio(Squadra a, Squadra b, int pa, int pb, Data data) {
        this.a = a;
        this.b = b;
        this.pa = pa;
        this.pb = pb;
        this.data = data;
    }
    
    
    
}
