package pl.JJayjohnny.lifesim;

import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public abstract class Organizm {
    private int sila, inicjatywa;
    private Punkt pozycja;
    private String nazwa;
    private Color kolor;
    private boolean zyje;
    private int wiek;
    protected Swiat swiat;

    public Organizm(Swiat swiat, Punkt pozycja, int sila, int inicjatywa, String nazwa, Color kolor){
        this.swiat = swiat;
        this.pozycja = pozycja;
        this.inicjatywa = inicjatywa;
        this.nazwa = nazwa;
        this.kolor = kolor;
        this.wiek = 0;
        this.zyje = true;
        this.sila = sila;
    }

    public abstract void Akcja();
    public abstract void Kolizja(Organizm inny);
    public abstract void RozmnozSie();
    public String GetNazwa(){
        return nazwa;
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
        return this.nazwa+"(pozycja: "+pozycja+" wiek: "+wiek+" sila: "+sila+")";
    }

    public void Zapisz(FileWriter fileWriter){
        try {
            fileWriter.append(nazwa + " " + pozycja.x + " " + pozycja.y + " " + sila + " " + wiek+"\n");
        }catch (IOException e){
            System.out.println("ERROR SAVING");
        }
    }

    public void Wczytaj(Scanner scanner){
        this.sila = scanner.nextInt();
        this.wiek = scanner.nextInt();
    }
}
