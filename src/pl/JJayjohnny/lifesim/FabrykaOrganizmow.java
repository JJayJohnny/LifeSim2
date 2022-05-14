package pl.JJayjohnny.lifesim;

import pl.JJayjohnny.lifesim.Rosliny.Trawa;
import pl.JJayjohnny.lifesim.Zwierzeta.Owca;

public class FabrykaOrganizmow {
    Swiat swiat;
    public FabrykaOrganizmow(Swiat swiat){
        this.swiat = swiat;
    }
    public void StworzOrganizm(String nazwa, Punkt pozycja){
        Organizm nowy = null;
        switch (nazwa) {
            case "Owca":
                nowy = new Owca(swiat, pozycja);
                break;
            case "Trawa":
                nowy = new Trawa(swiat, pozycja);
                break;
        }
        if (nowy != null) {
            swiat.DodajOrganizm(nowy);
            //System.out.println("Dodano organizm: "+nowy);
            swiat.DodajLog("Dodano organizm: "+nowy);
        }
    }
}
