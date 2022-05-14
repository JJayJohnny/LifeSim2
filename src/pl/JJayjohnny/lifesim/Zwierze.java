package pl.JJayjohnny.lifesim;

import java.awt.*;
import java.util.Vector;

public abstract class Zwierze extends Organizm{
    public static final int ZWYKLY_ZASIEG_RUCHU = 1;
    public static final int ZWYKLA_SZANSA_NA_RUCH = 100;
    public static final int MINIMALNY_WIEK_ROZRODCZY = 3;


    protected int zasiegRuchu;
    protected int szansaNaRuch;
    Punkt poprzedniaPozycja;
    abstract public boolean TakiSamGatunek(Organizm inny);
    abstract public Organizm KlonujSiebie(Punkt pozycja);

    public Zwierze(Swiat swiat, Punkt pozycja, int sila, int inicjatywa, String nazwa, Color kolor, int zasiegRuchu, int szansaNaRuch){
        super(swiat, pozycja, sila, inicjatywa, nazwa, kolor);
        this.zasiegRuchu = zasiegRuchu;
        this.szansaNaRuch = szansaNaRuch;
        this.poprzedniaPozycja = pozycja;
    }

    @Override
    public void Akcja(){
        if(this.GetWiek() > 0){
            poprzedniaPozycja = this.GetPozycja();
            for(int i=0; i<zasiegRuchu; i++)
                this.Ruch();
        }
        this.SetWiek(this.GetWiek()+1);
    }

    protected void Ruch(){
        int czyRuch = (int)(Math.random()*100);
        if(czyRuch < szansaNaRuch){
            Vector<Punkt> pola = swiat.GetSasiedniePola(this.GetPozycja());
            if(pola.size() > 0){
                int r = (int)(Math.random()*100)%pola.size();
                this.SetPozycja(pola.get(r));
            }
        }
    }

    @Override
    public void Kolizja(Organizm inny){
        if(inny!=null){
            if(this.TakiSamGatunek(inny)){
                if(inny.GetWiek() >= MINIMALNY_WIEK_ROZRODCZY && this.GetWiek() >= MINIMALNY_WIEK_ROZRODCZY){
                    this.CofnijSie();
                    this.RozmnozSie();
                }
                else{
                    this.CofnijSie();
                }
            }
            else if(inny instanceof Zwierze){
                if (inny.CzyOdbilAtak(this)) {
                    this.CofnijSie();
                }
                else if(inny.CzyUciekl(this)){

                }
                else if(this.GetSila() >= inny.GetSila()){
                    inny.Zgin();
                    //System.out.println(this+" atakuje i zabija "+inny);
                    swiat.DodajLog(this+" atakuje i zabija "+inny);
                }
                else{
                    this.Zgin();
                    //System.out.println(this+" atakuje "+inny+" ale przegrywa");
                    swiat.DodajLog(this+" atakuje "+inny+" ale przegrywa");
                }
            }
            else{
                inny.Kolizja(this);
            }
        }
    }

    @Override
    public void RozmnozSie(){
        Vector<Punkt> pola = swiat.GetSasiedniePola(this.GetPozycja());
        while(pola.size()>0){
            int i = (int)(Math.random()*100)%pola.size();
            if(swiat.ZnajdzOrganizmNaPolu(pola.get(i), this) == null){
                Organizm dziecko = this.KlonujSiebie(pola.get(i));
                swiat.DodajOrganizm(dziecko);
                //System.out.println("Rodzi sie "+dziecko);
                swiat.DodajLog("Rodzi sie "+dziecko);
                break;
            }
            else
                pola.remove(i);
        }
    }

    void CofnijSie(){
        this.SetPozycja(this.poprzedniaPozycja);
    }
}
