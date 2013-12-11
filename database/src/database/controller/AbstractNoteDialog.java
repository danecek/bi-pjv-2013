/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package database.controller;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author danecek
 */
public abstract class AbstractNoteDialog extends JDialog {

    JLabel errorLabel = new JLabel(" ");
    JButton okButton;
    JPanel interior = new JPanel();

    class ButtonBox extends Box {

        public ButtonBox() {
            super(BoxLayout.LINE_AXIS);

            add(Box.createHorizontalGlue());
            add(new JButton(new AbstractAction("Cancel") {
                @Override
                public void actionPerformed(ActionEvent ae) {
                    AbstractNoteDialog.this.dispose();
                }
            }));
            add(Box.createHorizontalStrut(5));
            add(okButton = new JButton("OK"));
        }
    }

    public AbstractNoteDialog(String name) {
        super((JFrame) null, name, true);
        setResizable(false);


        add(errorLabel, BorderLayout.NORTH);
        add(interior, BorderLayout.CENTER);

        add(new ButtonBox(), BorderLayout.SOUTH);
    }

    public abstract boolean validateNotes();

    protected void error(String empty_note) {
        errorLabel.setText(empty_note);
    }

    protected void clearError() {
        errorLabel.setText("");
    }
    
    
}
