/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package funkce;

/**
 *
 * @author danecek
 */
public class TrigFunkce extends Funkce {

    public static final TrigFunkce SIN = new TrigFunkce(1, 1, 0);
    public static final TrigFunkce COS = new TrigFunkce(-1, 1, Math.PI / 2);
    double frekvence;
    double faze;

    public TrigFunkce(double amplituda, double frekvence, double faze) {
        super(amplituda);
        this.frekvence = frekvence;
        this.faze = faze;
    }

    @Override
    double funkcniHodnota(double argument) {
        return amplituda * (Math.sin(argument * frekvence - faze));
    }
}
