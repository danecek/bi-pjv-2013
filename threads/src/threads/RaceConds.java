/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package threads;

/**
 *
 * @author danecek
 */
public class RaceConds extends Thread {

    static int x, y;
    static Object lock = new Object();

    public RaceConds(String string) {
        super(string);
    }

    @Override
    public void run() {

        for (int i = 0;; i++) {
            //  System.out.printf("%d:%s\n", i, getName());

            synchronized ("lock") {
                assert x + y == 0;

                int d = (int) (Math.random() * 10) - 5;
                x += d;

                y -= d;
            }
        }

    }

    public static void main(String[] args) {
        new RaceConds("V1").start();
        new RaceConds("V2").start();
    }
}
