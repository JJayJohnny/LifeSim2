package pl.JJayjohnny.lifesim.interfejs;

import javax.swing.*;
import java.awt.*;

public class Plansza extends JPanel {
    public static final int WIELKOSC_POLA = 30;
    int szerokosc, wysokosc;
    public Color[][] colorBoard;
    public Plansza(int szerokosc, int wysokosc){
        super();
        this.szerokosc = szerokosc;
        this.wysokosc = wysokosc;
    }
    @Override
    protected void paintComponent(Graphics g){
        g.setColor(Color.black);
        for(int i=0; i<(szerokosc*WIELKOSC_POLA); i+=WIELKOSC_POLA) {
            for(int j=0; j<(wysokosc*WIELKOSC_POLA); j+= WIELKOSC_POLA)
            g.drawRect(i, j, WIELKOSC_POLA, WIELKOSC_POLA);
        }

        for(int i=0; i<(szerokosc*WIELKOSC_POLA); i+=WIELKOSC_POLA) {
            for (int j = 0; j < (wysokosc * WIELKOSC_POLA); j += WIELKOSC_POLA) {
                if(colorBoard!=null) {
                    g.setColor(colorBoard[j/WIELKOSC_POLA][i/WIELKOSC_POLA]);
                    g.fillRect(i+1, j+1, WIELKOSC_POLA-2, WIELKOSC_POLA-2);
                }
            }
        }
    }
}
