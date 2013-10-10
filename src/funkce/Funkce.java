/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package funkce;

/**
 *
 * @author danecek
 */
public abstract class Funkce {

    protected double amplituda;

    public Funkce(double amplituda) {
        this.amplituda = amplituda;
    }

    abstract double funkcniHodnota(double argument);

    public double getAmplituda() {
        return amplituda;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + ": amplituda=" + amplituda;
    }
}
