package pl.JJayjohnny.lifesim.Zwierzeta;

import pl.JJayjohnny.lifesim.Organizm;
import pl.JJayjohnny.lifesim.Punkt;
import pl.JJayjohnny.lifesim.Swiat;
import pl.JJayjohnny.lifesim.Zwierze;

import java.awt.*;

public class Owca extends Zwierze {
    public static final int SILA_OWCY = 4;
    public static final int INICJATYWA_OWCY = 4;
    public static final char ZNAK_OWCY = 'o';
    public static final Color KOLOR_OWCY = Color.gray;

    public Owca(Swiat swiat, Punkt pozycja){
        super(swiat, pozycja, SILA_OWCY, INICJATYWA_OWCY, ZNAK_OWCY, KOLOR_OWCY, ZWYKLY_ZASIEG_RUCHU, ZWYKLA_SZANSA_NA_RUCH);
    }

    @Override
    public boolean TakiSamGatunek(Organizm inny){
        if(inny instanceof Owca)
            return true;
        else
            return false;
    }

    @Override
    public Organizm KlonujSiebie(Punkt pozycja){
        return new Owca(swiat, pozycja);
    }

}
