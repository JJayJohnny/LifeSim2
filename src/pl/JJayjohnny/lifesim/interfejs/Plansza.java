package pl.JJayjohnny.lifesim.interfejs;

import pl.JJayjohnny.lifesim.Swiat;
import sun.java2d.loops.DrawRect;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Plansza extends JPanel implements MouseListener {
    public static final int WIELKOSC_POLA = 30;
    int szerokosc, wysokosc;
    Swiat swiat;
    public Plansza(int szerokosc, int wysokosc, Swiat swiat){
        super();
        this.szerokosc = szerokosc;
        this.wysokosc = wysokosc;
        this.swiat = swiat;
        addMouseListener(this);
    }
    @Override
    protected void paintComponent(Graphics g){
        g.setColor(Color.black);
        for(int i=0; i<(szerokosc*WIELKOSC_POLA); i+=WIELKOSC_POLA) {
            for(int j=0; j<(wysokosc*WIELKOSC_POLA); j+= WIELKOSC_POLA)
            g.drawRect(i, j, WIELKOSC_POLA, WIELKOSC_POLA);
        }

        Color[][] colorBoard= swiat.PrzygotujPlansze();
        for(int i=0; i<(szerokosc*WIELKOSC_POLA); i+=WIELKOSC_POLA) {
            for (int j = 0; j < (wysokosc * WIELKOSC_POLA); j += WIELKOSC_POLA) {
                if(colorBoard!=null) {
                    g.setColor(colorBoard[j/WIELKOSC_POLA][i/WIELKOSC_POLA]);
                    g.fillRect(i+1, j+1, WIELKOSC_POLA-2, WIELKOSC_POLA-2);
                }
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent event){
        int x = event.getX();
        int y = event.getY();
        x/=WIELKOSC_POLA;
        y/=WIELKOSC_POLA;
        if(x<szerokosc && y<wysokosc) {
            System.out.println("Kliknieto w pole (" + x + "," + y + ")");
        }
    }
    @Override
    public void mouseEntered(MouseEvent event) {
    }
    @Override
    public void mouseExited(MouseEvent event) {}
    @Override
    public void mousePressed(MouseEvent event) {}
    @Override
    public void mouseReleased(MouseEvent event) {}

}
