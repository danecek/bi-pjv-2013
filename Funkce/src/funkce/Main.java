/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package funkce;

/**
 *
 * @author danecek
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    
    
    
    public static void main(String[] args) {
        System.out.println(TrigFunkce.SIN.funkcniHodnota(0));
        System.out.println(TrigFunkce.SIN.funkcniHodnota(Math.PI / 2));
        System.out.println(TrigFunkce.COS.funkcniHodnota(0));
        System.out.println(TrigFunkce.COS.funkcniHodnota(Math.PI / 2));
        TrigFunkce tf = new TrigFunkce(1, 2, 0);
        System.out.println(tf.funkcniHodnota(0));
        System.out.println(tf.funkcniHodnota(Math.PI / 2));
        System.out.println(tf.funkcniHodnota(Math.PI));
        System.out.println(LinFunkce.IDENTITA);
    }
}
