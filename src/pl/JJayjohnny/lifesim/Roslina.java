package pl.JJayjohnny.lifesim;

import java.awt.*;
import java.util.Vector;

public abstract class Roslina extends Organizm{
    public static final int SZANSA_NA_ROZROST = 10;
    public static final int ILOSC_PROB_ROZROSTU = 1;
    public static final int INICJATYWA_ROSLIN = 1;

    int szansaNaRozrost;
    int iloscProbRozrostu;

    abstract public Organizm KlonujSiebie(Punkt pozycja);

    public Roslina(Swiat swiat, Punkt pozycja, int sila, String nazwa, Color kolor, int szansaNaRozrost, int iloscProbRozrostu){
        super(swiat, pozycja, sila, INICJATYWA_ROSLIN, nazwa, kolor);
        this.szansaNaRozrost = szansaNaRozrost;
        this.iloscProbRozrostu = iloscProbRozrostu;
    }

    @Override
    public void Akcja(){
        if(this.GetWiek()>0){
            for(int i=0; i<iloscProbRozrostu; i++){
                int szansa = (int)(Math.random()*100);
                if(szansa < szansaNaRozrost)
                    this.RozmnozSie();
            }
        }
        this.SetWiek(this.GetWiek()+1);
    }

    @Override
    public void Kolizja(Organizm inny){
        if(inny != null){
            this.Zgin();
            //System.out.println(inny+" zjada "+this);
            swiat.DodajLog(inny+" zjada "+this);
        }
    }

    @Override
    public void RozmnozSie(){
        Vector<Punkt> pola = swiat.GetSasiedniePola(this.GetPozycja());
        while(pola.size()>0){
            int i = (int)(Math.random()*100)% pola.size();
            if(swiat.ZnajdzOrganizmNaPolu(pola.get(i), this) == null){
                Organizm dziecko = this.KlonujSiebie(pola.get(i));
                swiat.DodajOrganizm(dziecko);
                //System.out.println(dziecko+ " rosnie");
                swiat.DodajLog(dziecko+" rosnie");
                break;
            }
            else
                pola.remove(i);
        }
    }

}
