package pl.JJayjohnny.lifesim.interfejs;

import pl.JJayjohnny.lifesim.Swiat;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JMenuBar implements ActionListener {
    JMenu gra;
    JMenuItem wczytaj, zapisz, logi;
    Swiat swiat;

    public Menu(Swiat swiat){
        this.swiat = swiat;
        gra = new JMenu("Gra");
        zapisz = new JMenuItem("Zapisz");
        wczytaj = new JMenuItem("Wczytaj");
        logi = new JMenuItem("Logi");

        zapisz.addActionListener(this);
        wczytaj.addActionListener(this);
        logi.addActionListener(this);

        gra.add(wczytaj);
        gra.add(zapisz);
        add(gra);
        add(logi);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource() == wczytaj){
            System.out.println("wczytaj");
        }
        if(e.getSource() == zapisz){
            System.out.println("Zapisz");
        }

        if(e.getSource() == logi){
            System.out.println("logi");
        }
    }
}
