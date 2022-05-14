package pl.JJayjohnny.lifesim.Zwierzeta;

import pl.JJayjohnny.lifesim.Organizm;
import pl.JJayjohnny.lifesim.Punkt;
import pl.JJayjohnny.lifesim.Swiat;
import pl.JJayjohnny.lifesim.Zwierze;

import java.awt.*;

public class Zolw extends Zwierze {
    public static final int SILA_ZOLWIA = 2;
    public static final int INICJATYWA_ZOLWIA = 1;
    public static final String NAZWA_ZOLWIA = "Zolw";
    public static final Color KOLOR_ZOLWIA = Color.GREEN.darker();
    public static final int SZANSA_NA_RUCH_ZOLWIA = 25;
    public static final int SILY_ATAKOW_BLOKOWANE_PRZEZ_ZOLWIA = 5;

    public Zolw(Swiat swiat, Punkt pozycja){
        super(swiat, pozycja, SILA_ZOLWIA, INICJATYWA_ZOLWIA, NAZWA_ZOLWIA, KOLOR_ZOLWIA, ZWYKLY_ZASIEG_RUCHU, SZANSA_NA_RUCH_ZOLWIA);
    }

    @Override
    public boolean TakiSamGatunek(Organizm inny){
        return inny instanceof Zolw;
    }

    @Override
    public Organizm KlonujSiebie(Punkt pozycja){
        return new Zolw(swiat, pozycja);
    }

    @Override
    public boolean CzyOdbilAtak(Organizm atakujacy){
        if(atakujacy.GetSila() < SILY_ATAKOW_BLOKOWANE_PRZEZ_ZOLWIA)
            return true;
        else
            return false;
    }
}
