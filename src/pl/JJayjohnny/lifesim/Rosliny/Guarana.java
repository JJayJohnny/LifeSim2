package pl.JJayjohnny.lifesim.Rosliny;

import pl.JJayjohnny.lifesim.Organizm;
import pl.JJayjohnny.lifesim.Punkt;
import pl.JJayjohnny.lifesim.Roslina;
import pl.JJayjohnny.lifesim.Swiat;

import java.awt.*;

public class Guarana extends Roslina {
    public static final int SILA_GUARANY = 0;
    public static final String NAZWA_GUARANY = "Guarana";
    public static final Color KOLOR_GUARANY = Color.red;
    public static final int BONUS_DO_SILY_GUARANY = 3;

    public Guarana(Swiat swiat, Punkt pozycja){
        super(swiat, pozycja, SILA_GUARANY, NAZWA_GUARANY, KOLOR_GUARANY, SZANSA_NA_ROZROST, ILOSC_PROB_ROZROSTU);
    }

    @Override
    public Organizm KlonujSiebie(Punkt pozycja){
        return new Guarana(swiat, pozycja);
    }

    @Override
    public void Kolizja(Organizm inny){
        if(inny != null){
            swiat.DodajLog(inny+" zjada "+this+" i jego sila zwieksza sie o "+BONUS_DO_SILY_GUARANY);
            inny.SetSila(inny.GetSila()+BONUS_DO_SILY_GUARANY);
            this.Zgin();
        }
    }
}
