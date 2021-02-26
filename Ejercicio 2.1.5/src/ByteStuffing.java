
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
public class ByteStuffing extends JFrame {

    public static JTextField textoIntroducido = null;
    public static JTextField textoResultado = null;

    public ByteStuffing() {
        super("Delimitación mediante Byte Stuffing");
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

    public static String ByteStuffingProcessing(String s) {

        //Declaro mis variables
        int i, j = 0, k = 0, l;
        String[] sa = new String[80];
        String flag = "01111110", esc = "11100000", s1, s2;

        //Recorro los bits y los separo en bytes
        for (i = 0; i <= s.length(); i++) {
            if ((i + 1) % 8 == 0) {
                sa[j] = s.substring(k, i + 1);
                System.out.println(sa[j]);
                k = k + 8;
                j++;
            }
        }

        //Calculo las veces que recorro los byte
        i = s.length() / 8;

        s = "";
        for (l = 0; l < i; l++) {
            if (sa[l].equals("01111110") || sa[l].equals("11100000")) {
                s = s + "   " + esc + "   " + sa[l];
            } else {
                s = s + "   " + sa[l];
            }
        }
        s = flag + s + "   " + flag;
        return s;

    }

    public static class OyenteBotonProcesar implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Toolkit.getDefaultToolkit().beep();
            String s;
            s = textoIntroducido.getText();
            String sProcessed = ByteStuffingProcessing(s);
            textoResultado.setText(sProcessed);

        }

    }

}
