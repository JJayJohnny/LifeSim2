package pl.JJayjohnny.lifesim.interfejs;

import pl.JJayjohnny.lifesim.FabrykaOrganizmow;
import pl.JJayjohnny.lifesim.Organizm;
import pl.JJayjohnny.lifesim.Punkt;
import pl.JJayjohnny.lifesim.Rosliny.Trawa;
import pl.JJayjohnny.lifesim.Swiat;
import pl.JJayjohnny.lifesim.Zwierzeta.Owca;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MenuOrganizmow extends JFrame {
    Swiat swiat;
    Punkt pozycja;
    JList<String> listaOrganizmow;

    public MenuOrganizmow(Swiat swiat, Punkt pozycja, int windowX, int windowY){
        this.swiat = swiat;
        this.pozycja = pozycja;
        DefaultListModel<String> model = new DefaultListModel<>();
        model.addElement("Owca");
        model.addElement("Trawa");
        listaOrganizmow = new JList<>(model);
        listaOrganizmow.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listaOrganizmow.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if(e.getValueIsAdjusting()) {
                    swiat.fabrykaOrganizmow.StworzOrganizm(listaOrganizmow.getSelectedValue(), pozycja);
                    //TODO oddzielna funkcja rysujaca plansze
                    swiat.okno.plansza.repaint();
                    setVisible(false);
                }
            }
        });
        add(listaOrganizmow);
        setSize(100, 200);
        setLocation(windowX, windowY);
        listaOrganizmow.setBackground(Color.cyan);
        setUndecorated(true);
        setVisible(true);
        addWindowFocusListener(new WindowAdapter() {
            @Override
            public void windowLostFocus(WindowEvent e) {
                dispose();
            }
        });
    }

}
