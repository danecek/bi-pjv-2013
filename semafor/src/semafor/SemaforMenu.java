/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package semafor;

import javax.swing.JMenu;

/**
 *
 * @author danecek
 */
public class SemaforMenu extends JMenu {

    public SemaforMenu() {
        super("Semafor");
        add(new StartAkce());
    }
    
}
