package pl.JJayjohnny.lifesim.interfejs;

import pl.JJayjohnny.lifesim.SluchaczLogow;
import pl.JJayjohnny.lifesim.Swiat;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JMenuBar implements ActionListener {
    JMenu gra;
    JMenuItem wczytaj, zapisz, logi, nowaGra;
    Swiat swiat;

    public Menu(Swiat swiat){
        this.swiat = swiat;
        gra = new JMenu("Gra");
        nowaGra = new JMenuItem("Nowa Gra");
        zapisz = new JMenuItem("Zapisz");
        wczytaj = new JMenuItem("Wczytaj");
        logi = new JMenuItem("Logi");

        nowaGra.addActionListener(this);
        zapisz.addActionListener(this);
        wczytaj.addActionListener(this);
        logi.addActionListener(this);

        gra.add(nowaGra);
        gra.add(wczytaj);
        gra.add(zapisz);
        add(gra);
        add(logi);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource() == wczytaj){
            System.out.println("wczytaj");
            String sciezka = JOptionPane.showInputDialog(
                    null,
                    "Wpisz nazwe pliku do wczytania:",
                    "Wczytaj",
                    JOptionPane.QUESTION_MESSAGE
            );
            swiat.kreatorSwiata.WczytajSwiat(swiat, sciezka);
        }
        if(e.getSource() == zapisz){
            String sciezka = JOptionPane.showInputDialog(
                    null,
                   "Wpisz nazwe pliku do zapisania:",
                    "Zapis",
                    JOptionPane.QUESTION_MESSAGE
            );
            System.out.println(sciezka);
            if(sciezka != null)
                swiat.ZapiszSwiat(sciezka);
        }

        if(e.getSource() == logi){
            System.out.println("logi");
            OknoLogow logi = new OknoLogow(swiat);
            swiat.DodajSluchaczaLogow(logi);
        }

        if(e.getSource() == nowaGra){
            swiat.okno.dispose();
            for(SluchaczLogow s : swiat.sluchaczeLogow)
                s.Zamknij();
            swiat = swiat.kreatorSwiata.StworzNowySwiat();
        }
    }
}
