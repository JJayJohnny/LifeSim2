package pl.JJayjohnny.lifesim.interfejs;

import pl.JJayjohnny.lifesim.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Okno extends JFrame implements KeyListener{
    public Plansza plansza;
    private int szerokosc, wysokosc;
    private Swiat swiat;

    public Okno(Swiat swiat, int szerokosc, int wysokosc){
        this.swiat = swiat;
        this.szerokosc = szerokosc;
        this.wysokosc = wysokosc;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("LifeSim2 - Project by Jan Barczewski (188679)");
        //setMinimumSize(new Dimension((szerokosc)*Plansza.WIELKOSC_POLA, (wysokosc)*Plansza.WIELKOSC_POLA));
        getContentPane().setPreferredSize(new Dimension((szerokosc)*Plansza.WIELKOSC_POLA, (wysokosc)*Plansza.WIELKOSC_POLA));
        plansza = new Plansza(szerokosc, wysokosc, swiat);
        add(plansza);
        plansza.setVisible(true);
        setVisible(true);
        pack();

        addKeyListener(this);
    }

    public void keyPressed(KeyEvent e){
        if(e.getKeyChar() == 'n')
            swiat.WykonajTure();
    }
    public void keyTyped(KeyEvent e){
    }
    public void keyReleased(KeyEvent e){
    }
}
