package pl.JJayjohnny.lifesim;

import pl.JJayjohnny.lifesim.Rosliny.Trawa;
import pl.JJayjohnny.lifesim.Zwierzeta.Owca;

import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {
        Swiat s = new Swiat(20, 20);
        Owca o = new Owca(s, new Punkt(2, 2));
        Owca o2 = new Owca(s, new Punkt(2, 1));
        s.DodajOrganizm(o);
        s.DodajOrganizm(o2);
        s.DodajOrganizm(new Trawa(s, new Punkt(10, 10)));
        s.WykonajTure();
    }
}
