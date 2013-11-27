/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package semafor;

import java.awt.Color;
import java.awt.Graphics2D;

/**
 *
 * @author danecek
 */
public class Svetlo {

    private boolean sviti;
    private Color barva;
    private int prumer;

    public Svetlo(Color barva, int prumer) {
        this.barva = barva;
        this.prumer = prumer;
    }

    public void nakresli(Graphics2D g) {
        if (!sviti) {
            g.setColor(Color.LIGHT_GRAY);
        } else {
            g.setColor(barva);

        }
        g.fillOval(0, 0, prumer, prumer);
    }

    /**
     * @return the sviti
     */
    public boolean isSviti() {
        return sviti;
    }

    /**
     * @param sviti the sviti to set
     */
    public void setSviti(boolean sviti) {
        this.sviti = sviti;
    }

    /**
     * @return the barva
     */
    public Color getBarva() {
        return barva;
    }

    /**
     * @return the prumer
     */
    public int getPrumer() {
        return prumer;
    }
    
    
}
