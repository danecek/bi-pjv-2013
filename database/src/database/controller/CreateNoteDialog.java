/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package database.controller;

import database.integration.PoznamkaDAO;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;

/**
 *
 * @author danecek
 */
public class CreateNoteDialog extends AbstractNoteDialog {

    ValidatedTF note;

    public CreateNoteDialog() {
        super("Create Note");

        interior.setLayout(new GridLayout(0, 2));
        interior.add(new JLabel("Note:"));
        interior.add(note = new ValidatedTF(this));
        
        okButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                if (validateNotes()) {
                    try {
                        PoznamkaDAO.getInstance().create(note.getText());
                    } catch (SQLException ex) {
                        Logger.getLogger(CreateNoteDialog.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                    dispose();
                    
                }
            }
        });
        

        pack();
        setVisible(true);
    }

    @Override
    public boolean validateNotes() {
        if (note.getText().isEmpty()) {
            error("empty note");
            return false;
        }
        clearError();
        return true;
    }
}
