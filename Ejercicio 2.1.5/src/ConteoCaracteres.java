
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Quique Robles <qroblesuriel@gmail.com>
 */
public class ConteoCaracteres extends JFrame {

    public static JTextField textoIntroducido = null;
    public static JTextField textoResultado = null;

    public ConteoCaracteres() {
        super("Delimitación mediante conteo de caracteres");
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

    public static String ConteoCaracteresProcessing(String s) {
        int i = s.length();
        /*for (int j = 0; j < i; j++) {
            if (!(s.charAt(j) == 1 || s.charAt(j) == 0)) {
                JOptionPane.showMessageDialog(p, "El número introducido no es un numero binario", JOptionPane.ERROR_MESSAGE);
            }

        }*/
        //String b = Integer.toBinaryString(i);
        double f = s.length() / 8.0;
        int j = (int) Math.ceil(f);
        j++;
        String b = Integer.toBinaryString(j);
        s = b + "   " + s;
        return s;
    }

    public static class OyenteBotonProcesar implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Toolkit.getDefaultToolkit().beep();
            String s;
            s = textoIntroducido.getText();
            String sProcessed = ConteoCaracteresProcessing(s);
            textoResultado.setText(sProcessed);

        }

    }

}
