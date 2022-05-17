package pl.JJayjohnny.lifesim;

import pl.JJayjohnny.lifesim.Rosliny.Trawa;
import pl.JJayjohnny.lifesim.Zwierzeta.Czlowiek;
import pl.JJayjohnny.lifesim.Zwierzeta.Owca;

public class Main {

    public static void main(String[] args) {
        KreatorSwiata kreatorSwiata = new KreatorSwiata();
        Swiat s = kreatorSwiata.StworzNowySwiat();
        if(s!=null)
            s.WykonajTure(null);
    }
}
