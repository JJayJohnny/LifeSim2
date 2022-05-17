package pl.JJayjohnny.lifesim.Zwierzeta;

import pl.JJayjohnny.lifesim.*;

import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Vector;

public class Czlowiek extends Zwierze {
    public static final int SILA_CZLOWIEKA=5;
    public static final int INICJATYWA_CZLOWIEKA=4;
    public static final String NAZWA_CZLOWIEKA="Czlowiek";
    public static final Color KOLOR_CZLOWIEKA= Color.pink;
    public static final int COOLDOWN_UMIEJETNOSCI_CZLOWIEKA=5;
    public static final int CZAS_TRWANIA_UMIEJETNOSCI_CZLOWIEKA=5;

    private int cooldownUmiejetnosci;
    private int pozostalyCzasTrwaniaUmiejetnosci;
    private boolean umiejetnoscAktywna;
    public Kierunek kierunek;

    public Czlowiek(Swiat swiat, Punkt pozycja){
        super(swiat, pozycja, SILA_CZLOWIEKA, INICJATYWA_CZLOWIEKA, NAZWA_CZLOWIEKA, KOLOR_CZLOWIEKA, ZWYKLY_ZASIEG_RUCHU, ZWYKLA_SZANSA_NA_RUCH);
        pozostalyCzasTrwaniaUmiejetnosci = 0;
        cooldownUmiejetnosci = COOLDOWN_UMIEJETNOSCI_CZLOWIEKA;
        umiejetnoscAktywna = false;
        kierunek = null;
    }

    @Override
    protected void Ruch(){
        if(kierunek!= null){
            Punkt nowa = this.GetPozycja();
            switch(kierunek){
                case GORA:
                    if(nowa.y > 0)
                        nowa.y--;
                break;
                case DOL:
                    if(nowa.y<swiat.wysokosc-1)
                        nowa.y++;
                    break;
                case LEWO:
                    if(nowa.x > 0)
                        nowa.x--;
                    break;
                case PRAWO:
                    if(nowa.x<swiat.szerokosc-1)
                        nowa.x++;
                    break;
            }
            this.SetPozycja(nowa);
        }
        if(cooldownUmiejetnosci > 0)
            cooldownUmiejetnosci--;
        if(pozostalyCzasTrwaniaUmiejetnosci > 0)
            pozostalyCzasTrwaniaUmiejetnosci--;
        if(pozostalyCzasTrwaniaUmiejetnosci == 0)
            umiejetnoscAktywna = false;
    }

    @Override
    public void Kolizja(Organizm inny){
        super.Kolizja(inny);
        if(umiejetnoscAktywna){
            Vector<Punkt> sasiedniePola = swiat.GetSasiedniePola(this.GetPozycja());
            for(int i=0; i<sasiedniePola.size(); i++){
                Organizm o = swiat.ZnajdzOrganizmNaPolu(sasiedniePola.get(i), this);
                if(o!= null){
                    o.Zgin();
                    //System.out.println(this+" pali umiejetnoscia "+o);
                    swiat.DodajLog(this+" pali umiejetnoscia "+o);
                }
            }
        }
        //System.out.println("Cooldown umiejetnosci: "+cooldownUmiejetnosci+" czas trwania: "+pozostalyCzasTrwaniaUmiejetnosci);
        swiat.DodajLog("Cooldown umiejetnosci: "+cooldownUmiejetnosci+" czas trwania: "+pozostalyCzasTrwaniaUmiejetnosci);
    }

    public void AktywujUmiejetnosc(){
        if(cooldownUmiejetnosci == 0){
            umiejetnoscAktywna = true;
            cooldownUmiejetnosci = CZAS_TRWANIA_UMIEJETNOSCI_CZLOWIEKA + COOLDOWN_UMIEJETNOSCI_CZLOWIEKA;
            pozostalyCzasTrwaniaUmiejetnosci = CZAS_TRWANIA_UMIEJETNOSCI_CZLOWIEKA;
        }
    }


    @Override
    public boolean TakiSamGatunek(Organizm inny){
        return inny instanceof Czlowiek;
    }
    @Override
    public Organizm KlonujSiebie(Punkt pozycja){
        return new Czlowiek(swiat, pozycja);
    }

    @Override
    public void Zapisz(FileWriter fileWriter){
        try{
            fileWriter.append(this.GetNazwa()+" "+this.GetPozycja().x+" "+this.GetPozycja().y+" "+this.GetSila()+" "+this.GetWiek()+" "+pozostalyCzasTrwaniaUmiejetnosci+" "+cooldownUmiejetnosci+"\n");
        }catch (IOException e){
            System.out.println("ERROR SAVING");
        }
    }

    @Override
    public void Wczytaj(Scanner scanner){
        this.SetSila(scanner.nextInt());
        this.SetWiek(scanner.nextInt());
        this.pozostalyCzasTrwaniaUmiejetnosci = scanner.nextInt();
        this.cooldownUmiejetnosci = scanner.nextInt();
        if(pozostalyCzasTrwaniaUmiejetnosci > 0)
            umiejetnoscAktywna = true;
    }
}
