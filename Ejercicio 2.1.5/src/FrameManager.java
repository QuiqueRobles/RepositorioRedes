
import javax.swing.JFrame;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Quique Robles <qroblesuriel@gmail.com>
 */
public class FrameManager {

    private JFrame PagPrincipal;
    private JFrame ConteoCaracteres;
    private JFrame ByteStuffing;
    private JFrame BitStuffing;

    public FrameManager() {

        PagPrincipal = Singleton.getPagPrincipal();
    }

    public void PagPrincipal() {
        new PagPrincipal();
    }
}
