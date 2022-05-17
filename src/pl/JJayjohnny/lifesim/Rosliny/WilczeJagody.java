package pl.JJayjohnny.lifesim.Rosliny;

import pl.JJayjohnny.lifesim.Organizm;
import pl.JJayjohnny.lifesim.Punkt;
import pl.JJayjohnny.lifesim.Roslina;
import pl.JJayjohnny.lifesim.Swiat;

import java.awt.*;

public class WilczeJagody extends Roslina {
    public static final int SILA_WILCZYCH_JAGOD = 99;
    public static final String NAZWA_WILCZYCH_JAGOD = "WilczeJagody";
    public static final Color KOLOR_WILCZYCH_JAGOD = new Color(0, 0, 153);

    public WilczeJagody(Swiat swiat, Punkt pozycja){
        super(swiat, pozycja, SILA_WILCZYCH_JAGOD, NAZWA_WILCZYCH_JAGOD, KOLOR_WILCZYCH_JAGOD, SZANSA_NA_ROZROST, ILOSC_PROB_ROZROSTU);
    }

    @Override
    public Organizm KlonujSiebie(Punkt pozycja){
        return new WilczeJagody(swiat, pozycja);
    }

    @Override
    public void Kolizja(Organizm inny){
        if(inny != null) {
            swiat.DodajLog(inny + " zjada " + this + " i umiera");
            inny.Zgin();
            this.Zgin();
        }
    }
}
