
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Quique Robles <qroblesuriel@gmail.com>
 */
public class BitStuffing extends JFrame {

    public static JTextField textoIntroducido = null;
    public static JTextField textoResultado = null;

    public BitStuffing() {
        super("Delimitación mediante Bit Stuffing");
        setSize(1200, 100);
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        JPanel p1 = new JPanel();
        JPanel p2 = new JPanel();
        JPanel p3 = new JPanel();

        JLabel l = new JLabel("Introduzca la cadena de bits que quiera transmitir:  ");
        p1.add(l);
        textoIntroducido = new JTextField(20);
        p1.add(textoIntroducido);
        JButton b = new JButton("Procesar");
        b.addActionListener(new OyenteBotonProcesar());
        p2.add(b);
        JLabel l1 = new JLabel("Resultado:");
        p3.add(l1);
        textoResultado = new JTextField(20);
        p3.add(textoResultado);
        panel.add(p1);
        panel.add(p2);
        panel.add(p3);
        add(panel);
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

    }

    public static String BitStuffingProcessing(String s) {
        //Declaro las variable a utilizar
        int i, unos = 0;
        String s1, s2, flag = "01111110";
        //Voy recorriendo todo mi código introduciendo ceros cuando encuentro 5 unos
        for (i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                unos++;
            } else {
                unos = 0;
            }
            //Si tengo 5 unos seguidos divido mi cadena en dos subcadenas y le meto el cero
            if (unos == 5) {
                s1 = s.substring(0, i + 1);
                s2 = s.substring(i + 1);
                s = s1 + 0 + s2;
            }

        }
        //Meto los flags iniciales
        s = flag + "   " + s + "   " + flag;
        return s;

    }

    public static class OyenteBotonProcesar implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Toolkit.getDefaultToolkit().beep();
            String s;
            s = textoIntroducido.getText();
            String sProcessed = BitStuffingProcessing(s);
            textoResultado.setText(sProcessed);

        }

    }

}
