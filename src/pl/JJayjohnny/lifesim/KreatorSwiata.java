package pl.JJayjohnny.lifesim;

import pl.JJayjohnny.lifesim.Zwierzeta.Czlowiek;

import javax.swing.*;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class KreatorSwiata {
    public Swiat StworzNowySwiat(){
        JTextField szerokosc = new JTextField();
        JTextField wysokosc = new JTextField();
        Object[] form = {
                "Szerokosc:", szerokosc,
                "Wysokosc:", wysokosc
        };
        JOptionPane.showConfirmDialog(null, form, "Podaj wielkosc planszy", JOptionPane.DEFAULT_OPTION);
        int x = 0, y=0;

        if(!szerokosc.getText().equals(""))
        x = parseInt(szerokosc.getText());
        if(!wysokosc.getText().equals(""))
        y = parseInt(wysokosc.getText());

        if(x > 0 && y > 0) {
            System.out.println(x + " " + y);
            Swiat swiat = new Swiat(x, y, this);
            swiat.DodajOrganizm(new Czlowiek(swiat, new Punkt((int) (Math.random() * 100) % x, (int) (Math.random() * 100) % y)));
            return swiat;
        }
        else
            return null;
    }

    public void WczytajSwiat(Swiat swiat, String sciezka){
        File f = new File(Swiat.folderZapisow+sciezka);
        try {
            Scanner scanner = new Scanner(f);
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            swiat.okno.dispose();
            for(SluchaczLogow s : swiat.sluchaczeLogow)
                s.Zamknij();
            swiat = new Swiat(x, y, this);
            swiat.WczytajSwiat(scanner);
        }catch (IOException e){
            System.out.println(e);
        }
    }
}
