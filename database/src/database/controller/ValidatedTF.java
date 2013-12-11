/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package database.controller;

import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 *
 * @author danecek
 */
public class ValidatedTF extends JTextField {

    public ValidatedTF(final AbstractNoteDialog validator) {
        getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent de) {
                validator.validateNotes();
            }

            @Override
            public void removeUpdate(DocumentEvent de) {
                validator.validateNotes();
            }

            @Override
            public void changedUpdate(DocumentEvent de) {
                validator.validateNotes();
            }
        });
    }
}
