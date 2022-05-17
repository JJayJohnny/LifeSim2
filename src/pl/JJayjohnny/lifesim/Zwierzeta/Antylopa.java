package pl.JJayjohnny.lifesim.Zwierzeta;

import pl.JJayjohnny.lifesim.Organizm;
import pl.JJayjohnny.lifesim.Punkt;
import pl.JJayjohnny.lifesim.Swiat;
import pl.JJayjohnny.lifesim.Zwierze;

import java.awt.*;
import java.util.Vector;

public class Antylopa extends Zwierze {
    public static final int SILA_ANTYLOPY = 4;
    public static final int INICJATYWA_ANTYLOPY = 4;
    public static final String NAZWA_ANTYLOPY = "Antylopa";
    public static final Color KOLOR_ANTYLOPY = new Color(102, 51, 0);
    public static final int ZASIEG_RUCHU_ANTYLOPY = 2;
    public static final int SZANSA_NA_UCIECZKE_ANTYLOPY = 50;

    public Antylopa(Swiat swiat, Punkt pozycja){
        super(swiat, pozycja, SILA_ANTYLOPY, INICJATYWA_ANTYLOPY, NAZWA_ANTYLOPY, KOLOR_ANTYLOPY, ZASIEG_RUCHU_ANTYLOPY, ZWYKLA_SZANSA_NA_RUCH);
    }

    @Override
    public boolean TakiSamGatunek(Organizm inny){
        return inny instanceof Antylopa;
    }

    @Override
    public Organizm KlonujSiebie(Punkt pozycja){
        return new Antylopa(swiat, pozycja);
    }

    @Override
    public boolean CzyUciekl(Organizm atakujacy){
        int r = (int)(Math.random()*100);
        if(r<SZANSA_NA_UCIECZKE_ANTYLOPY) {
            Vector<Punkt> pola = swiat.GetSasiedniePola(this.GetPozycja());
            while(pola.size()>0){
                int pole = (int)(Math.random()*100)%pola.size();
                if(swiat.ZnajdzOrganizmNaPolu(pola.get(pole), this) == null){
                    this.SetPozycja(pola.get(pole));
                    return true;
                }
                else
                    pola.remove(pole);
            }
        }
        return false;
    }
}
