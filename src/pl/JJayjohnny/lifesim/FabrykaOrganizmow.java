package pl.JJayjohnny.lifesim;

import pl.JJayjohnny.lifesim.Rosliny.*;
import pl.JJayjohnny.lifesim.Zwierzeta.*;

public class FabrykaOrganizmow {
    Swiat swiat;
    public FabrykaOrganizmow(Swiat swiat){
        this.swiat = swiat;
    }
    public Organizm StworzOrganizm(String nazwa, Punkt pozycja){
        Organizm nowy = null;
        switch (nazwa) {
            case "Owca":
                nowy = new Owca(swiat, pozycja);
                break;
            case "Wilk":
                nowy = new Wilk(swiat, pozycja);
                break;
            case "Lis":
                nowy = new Lis(swiat, pozycja);
                break;
            case "Zolw":
                nowy = new Zolw(swiat, pozycja);
                break;
            case "Antylopa":
                nowy = new Antylopa(swiat, pozycja);
                break;
            case "Trawa":
                nowy = new Trawa(swiat, pozycja);
                break;
            case "Mlecz":
                nowy = new Mlecz(swiat, pozycja);
                break;
            case "Guarana":
                nowy = new Guarana(swiat, pozycja);
                break;
            case "WilczeJagody":
                nowy = new WilczeJagody(swiat, pozycja);
                break;
            case "BarszczSosnowskiego":
                nowy = new BarszczSosnowskiego(swiat, pozycja);
                break;
            case "Czlowiek":
                nowy = new Czlowiek(swiat, pozycja);
                break;
        }
        if (nowy != null) {
            swiat.DodajOrganizm(nowy);
            //System.out.println("Dodano organizm: "+nowy);
            swiat.DodajLog("Dodano organizm: "+nowy);
            return nowy;
        }
        else
            return null;
    }
}
