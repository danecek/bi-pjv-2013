/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import database.view.MainFrame;
import java.sql.SQLException;

/**
 *
 * @author danecek
 */
public class Database {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        new MainFrame();
//        PoznamkaDAO pdao = new PoznamkaDAO();
//        pdao.create("bla bla");
//        pdao.create("xxx yyy");
//        Collection<Poznamka> py = pdao.getALL();
//        System.out.println(py);
//        
        // TODO code application logic here
    }
}
