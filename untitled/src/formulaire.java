

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class formulaire extends JFrame {
    JFrame f = new JFrame();
    JPanel pan = (JPanel) f.getContentPane();
    JLabel l = new JLabel("wsfg");
    JButton b = new JButton("sfg");
    JLabel l1 = new JLabel("wsfg");
    JButton btn_Effacer;


    public static void main(String[] args) {
        formulaire x=new formulaire();
        x.f. setSize(300, 300);
        //titre
       x.f. setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       ????
       x.f.setVisible(true);
       x.b.setSize(new Dimension(100,20));
        x.pan.add(x.l);
        x.pan.add(x.l1);
        x.pan.add(x.b);

    }
}
