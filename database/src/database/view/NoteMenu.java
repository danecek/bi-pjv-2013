/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package database.view;

import database.controller.CreateNoteAction;
import javax.swing.JMenu;

/**
 *
 * @author danecek
 */
public class NoteMenu extends JMenu {

    public NoteMenu() {
        super("Note");
        add(CreateNoteAction.getInstance());
    }
    
    
    
}
