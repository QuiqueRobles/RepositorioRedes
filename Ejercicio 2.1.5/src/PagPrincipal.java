
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Quique Robles <qroblesuriel@gmail.com>
 */
public class PagPrincipal extends JFrame {

    public PagPrincipal() {
        super("Ejercicio Delimitación de Tramas - Nivel de Enlace");
        JPanel panel = new JPanel();
        setSize(800, 400);

        panel.setLayout(new GridLayout(3, 1));
        JButton b1 = new JButton("Conteo de Caracteres");
        JButton b2 = new JButton("ByteStuffing");
        JButton b3 = new JButton("BitStuffing");
        b1.addActionListener(new OyenteConteoCaracteres());
        b2.addActionListener(new OyenteByteStuffing());
        b3.addActionListener(new OyenteBitStuffing());
        panel.add(b1);
        panel.add(b2);
        panel.add(b3);
        this.add(panel);
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    public static class OyenteConteoCaracteres implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Singleton.getConteoCaracteres();
        }

    }

    public static class OyenteByteStuffing implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Singleton.getByteStuffing();
        }

    }

    public static class OyenteBitStuffing implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Singleton.getBitSuffing();
        }

    }

    public static void main(String[] args) {
        new PagPrincipal();

    }

}
