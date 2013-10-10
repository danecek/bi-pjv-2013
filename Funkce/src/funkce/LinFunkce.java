/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package funkce;

/**
 *
 * @author danecek
 */
public class LinFunkce extends Funkce {

    public static final LinFunkce IDENTITA = new LinFunkce(1, 0);
    private double b;

    public LinFunkce(double amplituda, double b) {
        super(amplituda);
        this.b = b;
    }

    @Override
    double funkcniHodnota(double argument) {
        return getAmplituda() * (argument + b);
    }

    @Override
    public String toString() {
        return super.toString() + ", b=" + b;
    }

    public double getB() {
        return b;
    }
}
