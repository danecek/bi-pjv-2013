/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package semafor;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

/**
 *
 * @author danecek
 */
public class StartAkce extends AbstractAction {

    public StartAkce() {
        super("Start");
    }
    

    @Override
    public void actionPerformed(ActionEvent ae) {
        RizeniSemaforu.INSTANCE.start();
    }
    
    
}
