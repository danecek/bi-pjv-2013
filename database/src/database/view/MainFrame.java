/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package database.view;

import javax.swing.JFrame;

/**
 *
 * @author danecek
 */
public class MainFrame extends JFrame {
    
    public MainFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(new MainPanel());
        pack();
        setVisible(true);
    }
}
