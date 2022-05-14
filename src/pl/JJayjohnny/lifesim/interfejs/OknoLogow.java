package pl.JJayjohnny.lifesim.interfejs;

import pl.JJayjohnny.lifesim.SluchaczLogow;
import pl.JJayjohnny.lifesim.Swiat;

import javax.swing.*;
import java.util.List;

public class OknoLogow  extends JFrame implements SluchaczLogow {

    Swiat swiat;
    JTextArea textArea;

    public OknoLogow(Swiat swiat){
        this.swiat = swiat;
        this.setTitle("Logi ze swiata");
        setResizable(false);
        textArea = new JTextArea();
        add(textArea);
        setSize(600, 300);
        textArea.setVisible(true);
        textArea.setEditable(false);
        setVisible(true);
        this.AktualizujLogi();
    }

    public void AktualizujLogi(){
        textArea.setText(null);
        List<String> logi = swiat.GetLogi();
        for(String log : logi){
            textArea.append(log);
            textArea.append("\n");
        }
    }
}
