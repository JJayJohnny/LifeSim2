package pl.JJayjohnny.lifesim;

public class Main {

    public static void main(String[] args) {
        KreatorSwiata kreatorSwiata = new KreatorSwiata();
        Swiat s = kreatorSwiata.StworzNowySwiat();
        if(s!=null)
            s.WykonajTure(null);
    }
}
