package pl.JJayjohnny.lifesim;

import pl.JJayjohnny.lifesim.interfejs.Okno;

import java.awt.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class Swiat {

    int szerokosc;
    int wysokosc;
    Okno okno;
    List<Organizm> organizmy = new LinkedList<>();
    int tura;
    boolean symuluj;

    Swiat(int szerokosc, int wysokosc){
        this.szerokosc = szerokosc;
        this.wysokosc = wysokosc;
        okno = new Okno(this, szerokosc, wysokosc);
    }

    public void WykonajTure(){
        for(int i=0; i<organizmy.size(); i++){
            if(organizmy.get(i).Zywy()){
                //System.out.println(o);
                organizmy.get(i).Akcja();
                Organizm przeciwnik = ZnajdzOrganizmNaPolu(organizmy.get(i).GetPozycja(), organizmy.get(i));
                organizmy.get(i).Kolizja(przeciwnik);
            }
        }

        organizmy.sort((Organizm o1, Organizm o2) -> {
            if(o1.GetInicjatywa() != o2.GetInicjatywa()){
                return (o1.GetInicjatywa() - o2.GetInicjatywa());
            }
            else
                return o1.GetWiek() - o2.GetWiek();
        });

        okno.plansza.colorBoard = PrzygotujPlansze();
        okno.plansza.repaint();
        tura++;
    }

    void DodajOrganizm(Organizm nowy){
        organizmy.add(nowy);
    }

    Organizm ZnajdzOrganizmNaPolu(Punkt pozycja, Organizm wylaczony){
        for(Organizm o : organizmy){
            if(o.GetPozycja().x == pozycja.x && o.GetPozycja().y == pozycja.y && o.hashCode()!=wylaczony.hashCode()) {
                return o;
            }
        }
        return null;
    }

    Vector<Punkt> GetSasiedniePola(Punkt pole){
        Vector<Punkt> pola = new Vector<>();
        if(pole.x > 0)
            pola.add(new Punkt(pole.x - 1, pole.y));
        if(pole.x < szerokosc-1)
            pola.add(new Punkt(pole.x+1, pole.y));
        if(pole.y > 0)
            pola.add(new Punkt(pole.x, pole.y-1));
        if(pole.y<wysokosc-1)
            pola.add(new Punkt(pole.x, pole.y+1));

        return pola;
    }

    Color[][] PrzygotujPlansze(){
        Color[][] plansza = new Color[wysokosc][szerokosc];
        for(int i=0; i<szerokosc; i++)
            for(int j=0; j<wysokosc; j++)
                plansza[j][i] = Color.white;

        for(Organizm o : organizmy){
            int x = o.GetPozycja().x;
            int y = o.GetPozycja().y;
            plansza[y][x] = o.GetKolor();
        }
        return plansza;
    }
}
