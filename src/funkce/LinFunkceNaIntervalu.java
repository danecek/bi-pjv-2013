/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package funkce;

/**
 *
 * @author danecek
 */
public class LinFunkceNaIntervalu extends LinFunkce {

    double min;
    double max;

    public LinFunkceNaIntervalu(double amplituda, double b, double min, double max) {
        super(amplituda, b);
        this.min = min;
        this.max = max;
    }

    @Override
    double funkcniHodnota(double argument) {
        if (argument < min || argument > max) {
            throw new IllegalArgumentException("argument mimo definicni obor");
        }
        return super.funkcniHodnota(argument); //To change body of generated methods, choose Tools | Templates.
    }
}
