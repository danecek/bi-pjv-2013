/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package database.view;

import database.integration.PoznamkaDAO;
import database.model.Poznamka;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author danecek
 */
class PoznamkyModel extends AbstractTableModel {

    List<Poznamka> poznamky;

    public PoznamkyModel() {
        refresh();
    }

    @Override
    public int getRowCount() {
        return poznamky.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int row, int col) {
        Poznamka p = poznamky.get(row);
        switch (col) {
            case 0:
                return p.getId();
            case 1:
                return p.getDate();
            case 2:
                return p.getText();
        }
        return null;
    }
    
    public void refresh() {
        try {
            poznamky =  new ArrayList<>(PoznamkaDAO.getInstance().getALL());
            fireTableDataChanged();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.toString());
        }
    }
}
