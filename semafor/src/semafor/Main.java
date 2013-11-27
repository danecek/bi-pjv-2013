/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package semafor;

import javax.swing.JFrame;

/**
 *
 * @author danecek
 */
public class Main extends JFrame {

    public Main(Semafor s) {
        setJMenuBar(new SemaforMenuBar());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(s);
        setSize(800, 600);
        setVisible(true);
    }
    public static void main(String[] args) throws InterruptedException {
        Semafor s = new Semafor(100);
        new Main(s);
        s.setStav(StavSemaforu.CERV);
        RizeniSemaforu.INSTANCE.setSemafor(s);
        // TODO code application logic here
    }

}
