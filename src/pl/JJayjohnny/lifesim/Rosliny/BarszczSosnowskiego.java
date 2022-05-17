package pl.JJayjohnny.lifesim.Rosliny;

import pl.JJayjohnny.lifesim.Organizm;
import pl.JJayjohnny.lifesim.Punkt;
import pl.JJayjohnny.lifesim.Roslina;
import pl.JJayjohnny.lifesim.Swiat;

import java.awt.*;
import java.util.Vector;

public class BarszczSosnowskiego extends Roslina {
    public static final int SILA_BARSZCZU_SOSNOWSKIEGO = 10;
    public static final String NAZWA_BARSZCZU_SOSNOWSKIEGO = "BarszczSosnowskiego";
    public static final Color KOLOR_BARSZCZU_SOSNOWSKIEGO = new Color(255, 255, 153);

    public BarszczSosnowskiego(Swiat swiat, Punkt pozycja){
        super(swiat, pozycja, SILA_BARSZCZU_SOSNOWSKIEGO, NAZWA_BARSZCZU_SOSNOWSKIEGO, KOLOR_BARSZCZU_SOSNOWSKIEGO, SZANSA_NA_ROZROST, ILOSC_PROB_ROZROSTU);
    }

    @Override
    public Organizm KlonujSiebie(Punkt pozycja){
        return new BarszczSosnowskiego(swiat, pozycja);
    }

    @Override
    public void Kolizja(Organizm inny){
        if(inny != null) {
            swiat.DodajLog(inny + " zjada " + this + " i umiera");
            inny.Zgin();
            this.Zgin();
        }
    }

    @Override
    public void Akcja(){
        Vector<Punkt> pola = swiat.GetSasiedniePola(this.GetPozycja());
        for(Punkt p : pola){
            Organizm inny = swiat.ZnajdzOrganizmNaPolu(p, this);
            if(inny != null && !(inny instanceof Roslina)){
                inny.Zgin();
                swiat.DodajLog(inny+" byl za blisko "+this+" i zginal");
            }
        }
        super.Akcja();
    }
}
