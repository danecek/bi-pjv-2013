/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package threads.procons;

/**
 *
 * @author danecek
 */
public class Producent extends Thread {

    Buffer buf;

    public Producent(Buffer buf) {
        this.buf = buf;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            buf.setD(Math.random());
            try {
                sleep(100);
            } catch (InterruptedException ex) {
            }
        }
    }
}
