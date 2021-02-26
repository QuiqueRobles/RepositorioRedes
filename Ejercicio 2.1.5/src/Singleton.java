
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
class Singleton {

    private static JFrame PagPrincipal = null;
    private static JFrame PagNoticia = null;
    private static JFrame PagInicioSesion = null;

    private Singleton() {
    }

    public static JFrame getPagPrincipal() {
        if (PagPrincipal == null) {
            new PagPrincipal();
        }
        return PagPrincipal;

    }

    public static JFrame getConteoCaracteres() {
        if (PagNoticia == null) {
            new ConteoCaracteres();
        }
        return PagNoticia;

    }

    public static JFrame getByteStuffing() {
        if (PagNoticia == null) {
            new ByteStuffing();
        }
        return PagNoticia;

    }

    public static JFrame getBitSuffing() {
        if (PagInicioSesion == null) {
            new BitStuffing();
        }
        return PagInicioSesion;

    }
}
