package pl.JJayjohnny.lifesim.Rosliny;

import pl.JJayjohnny.lifesim.Organizm;
import pl.JJayjohnny.lifesim.Punkt;
import pl.JJayjohnny.lifesim.Roslina;
import pl.JJayjohnny.lifesim.Swiat;

import java.awt.*;

public class Trawa extends Roslina {
    public static final int SILA_TRAWY = 0;
    public static final char ZNAK_TRAWY = 't';
    public static final Color KOLOR_TRAWY = Color.green;

    public Trawa(Swiat swiat, Punkt pozycja){
        super(swiat, pozycja, SILA_TRAWY, ZNAK_TRAWY, KOLOR_TRAWY, SZANSA_NA_ROZROST, ILOSC_PROB_ROZROSTU);
    }

    @Override
    public Organizm KlonujSiebie(Punkt pozycja){
        return new Trawa(swiat, pozycja);
    }
}
