package pl.JJayjohnny.lifesim.Zwierzeta;

import pl.JJayjohnny.lifesim.Organizm;
import pl.JJayjohnny.lifesim.Punkt;
import pl.JJayjohnny.lifesim.Swiat;
import pl.JJayjohnny.lifesim.Zwierze;

import java.awt.*;
import java.util.Vector;

public class Lis extends Zwierze {
    public static final int SILA_LISA = 3;
    public static final int INICJATYWA_LISA = 7;
    public static final String NAZWA_LISA = "Lis";
    public static final Color KOLOR_LISA = Color.orange;

    public Lis(Swiat swiat, Punkt pozycja){
        super(swiat, pozycja, SILA_LISA, INICJATYWA_LISA, NAZWA_LISA, KOLOR_LISA, ZWYKLY_ZASIEG_RUCHU, ZWYKLA_SZANSA_NA_RUCH);
    }

    @Override
    public boolean TakiSamGatunek(Organizm inny){
        return inny instanceof Lis;
    }

    @Override
    public Organizm KlonujSiebie(Punkt pozycja){
        return new Lis(swiat, pozycja);
    }

    @Override
    public void Ruch(){
        int czyRuch = (int)(Math.random()*100);
        if(czyRuch < szansaNaRuch){
            Vector<Punkt> pola = swiat.GetSasiedniePola(this.GetPozycja());
            while(pola.size() > 0){
                int r = (int)(Math.random()*100)%pola.size();
                Organizm naPolu = swiat.ZnajdzOrganizmNaPolu(pola.get(r), this);
                if(naPolu!= null && naPolu.GetSila() > this.GetSila() && !this.TakiSamGatunek(naPolu)){
                    pola.remove(r);
                    swiat.DodajLog(this+" wyczul "+naPolu+" i nie zaatakowal");
                }
                else
                {
                    this.SetPozycja(pola.get(r));
                    pola.clear();
                }
            }
        }
    }
}
