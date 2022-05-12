package pl.JJayjohnny.lifesim;

import java.awt.*;

public abstract class Organizm {
    private int sila, inicjatywa;
    private Punkt pozycja;
    private char znak;
    private Color kolor;
    private boolean zyje;
    private int wiek;
    protected Swiat swiat;

    public Organizm(Swiat swiat, Punkt pozycja, int sila, int inicjatywa, char znak, Color kolor){
        this.swiat = swiat;
        this.pozycja = pozycja;
        this.inicjatywa = inicjatywa;
        this.znak = znak;
        this.kolor = kolor;
        this.wiek = 0;
        this.zyje = true;
        this.sila = sila;
    }

    public abstract void Akcja();
    public abstract void Kolizja(Organizm inny);
    public abstract void RozmnozSie();
    public char GetChar(){
        return znak;
    }
    public Color GetKolor(){
        return kolor;
    }
    public int GetSila(){
        return sila;
    }
    public void SetSila(int sila){
        this.sila = sila;
    }
    public int GetInicjatywa(){
        return inicjatywa;
    }
    public void SetInicjatywa(int inicjatywa){
        this.inicjatywa = inicjatywa;
    }
    public Punkt GetPozycja(){
        return pozycja;
    }
    public void SetPozycja(Punkt pozycja){
        this.pozycja = pozycja;
    }
    public boolean Zywy() {
        return zyje;
    }
    public int GetWiek(){
        return wiek;
    }
    public void SetWiek(int wiek){
        this.wiek = wiek;
    }
    public boolean CzyOdbilAtak(Organizm atakujacy){
        return false;
    }
    public boolean CzyUciekl(Organizm atakujacy){
        return false;
    }
    public void Zgin(){
        this.zyje = false;
    }
    @Override
    public String toString(){
        return this.znak+"(pozycja: "+pozycja+" wiek: "+wiek+" sila: "+sila+")";
    }
}
