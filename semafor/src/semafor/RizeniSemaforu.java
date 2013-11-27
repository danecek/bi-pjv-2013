/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package semafor;

import java.util.logging.Level;
import java.util.logging.Logger;
import static semafor.StavSemaforu.CERV;
import static semafor.StavSemaforu.CERV_ZLUT;
import static semafor.StavSemaforu.ZEL;
import static semafor.StavSemaforu.ZHAS;
import static semafor.StavSemaforu.ZLUT;

/**
 *
 * @author danecek
 */
public class RizeniSemaforu implements Runnable {
    
    static RizeniSemaforu INSTANCE = new RizeniSemaforu();

    public RizeniSemaforu() {
    }
    void start() {
        runFl = true;
        new Thread(this).start();
    }

    void stop() {
        runFl = false;                
    }
    private Semafor semafor;

    void dalsiStav() {
        switch (semafor.getStav()) {

            case CERV: {
                semafor.setStav(CERV_ZLUT);
                break;
            }
            case CERV_ZLUT: {
                semafor.setStav(ZEL);
                break;
            }
            case ZEL: {
                semafor.setStav(ZLUT);
                break;
            }
            case ZLUT: {
                semafor.setStav(CERV);
                break;
            }
            case ZHAS:
                ;
        }
    }
    
    boolean runFl;

    @Override
    public void run() {
        while (runFl) {
            try {
                dalsiStav();
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(RizeniSemaforu.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     * @return the semafor
     */
    public Semafor getSemafor() {
        return semafor;
    }

    /**
     * @param semafor the semafor to set
     */
    public void setSemafor(Semafor semafor) {
        this.semafor = semafor;
    }
}
