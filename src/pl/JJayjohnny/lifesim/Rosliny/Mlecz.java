package pl.JJayjohnny.lifesim.Rosliny;

import pl.JJayjohnny.lifesim.Organizm;
import pl.JJayjohnny.lifesim.Punkt;
import pl.JJayjohnny.lifesim.Roslina;
import pl.JJayjohnny.lifesim.Swiat;

import java.awt.*;

public class Mlecz extends Roslina {
    public static final int SILA_MLECZA = 0;
    public static final String NAZWA_MLECZA = "Mlecz";
    public static final Color KOLOR_MLECZA = Color.yellow;
    public static final int ILOSC_PROB_ROZROSTU_MLECZA = 3;

    public Mlecz(Swiat swiat, Punkt pozycja){
        super(swiat, pozycja, SILA_MLECZA, NAZWA_MLECZA, KOLOR_MLECZA, SZANSA_NA_ROZROST, ILOSC_PROB_ROZROSTU_MLECZA);
    }

    @Override
    public Organizm KlonujSiebie(Punkt pozycja){
        return new Mlecz(swiat, pozycja);
    }
}
