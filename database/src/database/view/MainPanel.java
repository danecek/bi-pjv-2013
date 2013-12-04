/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package database.view;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 *
 * @author danecek
 */
public class MainPanel extends JPanel {

    public MainPanel() {
        
        setLayout(new BorderLayout());
        add(new JScrollPane(new JTable(new PoznamkyModel())));
    }
    
    
    
}
