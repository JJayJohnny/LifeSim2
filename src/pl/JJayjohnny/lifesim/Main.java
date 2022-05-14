package pl.JJayjohnny.lifesim;

import pl.JJayjohnny.lifesim.Rosliny.Trawa;
import pl.JJayjohnny.lifesim.Zwierzeta.Czlowiek;
import pl.JJayjohnny.lifesim.Zwierzeta.Owca;

public class Main {

    public static void main(String[] args) {
        Swiat s = new Swiat(20, 20);
        s.DodajOrganizm(new Czlowiek(s, new Punkt(5, 5)));
        s.DodajOrganizm(new Trawa(s, new Punkt(10, 10)));

        s.WykonajTure(null);
    }
}
