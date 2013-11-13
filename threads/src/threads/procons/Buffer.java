/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package threads.procons;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author danecek
 */
public class Buffer {

    private double d;
    private boolean valid;

    /**
     * @return the d
     */
    public synchronized double getD() {
//        synchronized (this) {
            while (!valid) {
                try {
                    this.wait();
                } catch (InterruptedException ex) {
                    Logger.getLogger(Buffer.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            valid = false;
            notify();
            return d;
//        }
    }

    /**
     * @param d the d to set
     */
    public synchronized void setD(double d) {
        while (valid) {
            try {
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Buffer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        this.d = d;
        valid = true;
        notifyAll();
    }

    public static void main(String[] args) {
        Buffer b = new Buffer();
        new Producent(b).start();
        new Consument(b).start();
    }
}
