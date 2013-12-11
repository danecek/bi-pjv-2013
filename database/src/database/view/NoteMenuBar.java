/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package database.view;

import javax.swing.JMenuBar;

/**
 *
 * @author danecek
 */
public class NoteMenuBar extends JMenuBar {

    public NoteMenuBar() {
        add(new NoteMenu());
    }
}
