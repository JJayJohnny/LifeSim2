package pl.JJayjohnny.lifesim.Zwierzeta;

import pl.JJayjohnny.lifesim.Organizm;
import pl.JJayjohnny.lifesim.Punkt;
import pl.JJayjohnny.lifesim.Swiat;
import pl.JJayjohnny.lifesim.Zwierze;

import java.awt.*;

public class Wilk extends Zwierze {
    public static final int SILA_WILKA=9;
    public static final int INICJATYWA_WILKA=5;
    public static final String NAZWA_WILKA="Wilk";
    public static final Color KOLOR_WILKA= new Color(102, 102, 102);

    public Wilk(Swiat swiat, Punkt pozycja){
        super(swiat, pozycja, SILA_WILKA, INICJATYWA_WILKA, NAZWA_WILKA, KOLOR_WILKA, ZWYKLY_ZASIEG_RUCHU, ZWYKLA_SZANSA_NA_RUCH);
    }

     @Override
    public boolean TakiSamGatunek(Organizm inny){
        return inny instanceof Wilk;
     }

     @Override
    public Organizm KlonujSiebie(Punkt pozycja){
        return new Wilk(swiat, pozycja);
     }
}
