/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package database.controller;

import java.awt.event.ActionEvent;

/**
 *
 * @author danecek
 */
public class CreateNoteAction extends AbstractNoteAction {
    
    private static CreateNoteAction instance = new CreateNoteAction();

    /**
     * @return the instance
     */
    public static CreateNoteAction getInstance() {
        return instance;
    }

    public CreateNoteAction() {
        super("Create Note ...");
    }
    
    

    @Override
    public void actionPerformed(ActionEvent ae) {
        new CreateNoteDialog();
        
    }
    
    
}
