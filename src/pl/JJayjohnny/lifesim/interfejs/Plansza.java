package pl.JJayjohnny.lifesim.interfejs;

import pl.JJayjohnny.lifesim.Punkt;
import pl.JJayjohnny.lifesim.Swiat;
import sun.java2d.loops.DrawRect;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class Plansza extends JPanel implements MouseListener, MouseMotionListener {
    public static final int WIELKOSC_POLA = 30;
    int szerokosc, wysokosc;
    int mouseX, mouseY;
    Swiat swiat;
    MenuOrganizmow menuOrganizmow;
    public Plansza(int szerokosc, int wysokosc, Swiat swiat){
        super();
        this.szerokosc = szerokosc;
        this.wysokosc = wysokosc;
        this.swiat = swiat;
        this.mouseX = -1;
        this.mouseY = -1;
        addMouseListener(this);
        addMouseMotionListener(this);
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
                    g.fillRect(i+1, j+1, WIELKOSC_POLA-1, WIELKOSC_POLA-1);
                }
            }
        }
        if(mouseX != -1 && mouseY != -1) {
            g.setColor(Color.red);
            g.drawRect(mouseX*WIELKOSC_POLA, mouseY*WIELKOSC_POLA, WIELKOSC_POLA, WIELKOSC_POLA);
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
            Punkt p = new Punkt(x, y);
            if(swiat.ZnajdzOrganizmNaPolu(p, null)==null) {
                menuOrganizmow = new MenuOrganizmow(swiat, p, event.getX(), event.getY());
            }
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
    public void mouseReleased(MouseEvent event) {
    }

    @Override
    public void mouseMoved(MouseEvent event){
        int x = event.getX();
        int y = event.getY();
        x/=WIELKOSC_POLA;
        y/=WIELKOSC_POLA;
        if(x<szerokosc && y<wysokosc) {
            this.mouseX = x;
            this.mouseY = y;
        }
        else{
            this.mouseX = -1;
            this.mouseY = -1;
        }
        this.repaint();
    }
    @Override
    public void mouseDragged(MouseEvent event){
    }

}
