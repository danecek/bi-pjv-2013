/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package threads.procons;

/**
 *
 * @author danecek
 */
public class Consument extends Thread {

    Buffer buf;
    int i;

    public Consument(Buffer buf) {
        this.buf = buf;
    }

    @Override
    public void run() {
        for (;;) {
            System.out.printf("%d %f\n", ++i, buf.getD());
        }

    }
}
