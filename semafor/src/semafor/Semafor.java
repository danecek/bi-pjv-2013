/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package semafor;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;
import static semafor.StavSemaforu.*;

/**
 *
 * @author danecek
 */
public class Semafor extends JPanel {
    
    Svetlo[] svetla;
    int prumerSvetla;
    private StavSemaforu stav = ZHAS;
    
    public Semafor(int prumerSvetla) {
        this.prumerSvetla = prumerSvetla;
        svetla = new Svetlo[]{
            new Svetlo(Color.RED, prumerSvetla),
            new Svetlo(Color.YELLOW, prumerSvetla),
            new Svetlo(Color.GREEN, prumerSvetla)
        };
    }
    
    @Override
    protected void paintComponent(Graphics grphcs) {
        int y = 0;
        for (Svetlo s : svetla) {
//            y+=prumerSvetla;
            s.nakresli((Graphics2D) grphcs);
            grphcs.translate(0, prumerSvetla);
        }
    }
    
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(prumerSvetla, svetla.length * prumerSvetla);
    }

    /**
     * @return the stav
     */
    public StavSemaforu getStav() {
        return stav;
    }

    /**
     * @param stav the stav to set
     */
    public void setStav(StavSemaforu stav) {
        this.stav = stav;
        for (Svetlo s : svetla) {
            s.setSviti(false);
        }
        switch (stav) {
            case CERV: {
                svetla[0].setSviti(true);
                break;
            }
            case CERV_ZLUT: {
                svetla[0].setSviti(true);
                svetla[1].setSviti(true);
                break;
            }
            case ZEL: {
                svetla[2].setSviti(true);
                break;
            }
            case ZLUT: {
                svetla[1].setSviti(true);
                break;
            }
            case ZHAS:
                ;
            
        }
        
        repaint();
        
    }
}
