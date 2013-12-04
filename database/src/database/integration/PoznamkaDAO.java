/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package database.integration;

import database.model.Poznamka;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author danecek
 */
public class PoznamkaDAO {

    /**
     * @return the instance
     */
    public static PoznamkaDAO getInstance() {
        return instance;
    }

    private Connection conn;
    PreparedStatement psCreate;
    PreparedStatement psGetAll;
    
    private static PoznamkaDAO instance = new PoznamkaDAO();

    private PoznamkaDAO() {
        try {
            conn = DriverManager.getConnection("jdbc:derby:/home/classroom/user/danecek/poznamkyDB;  create=true");
            DatabaseMetaData md = conn.getMetaData();
            ResultSet rs = md.getTables(null, null, "POZNAMKY", null);
            if (!rs.next()) { // tabulka neexistuje
                Statement s = conn.createStatement();
                s.executeUpdate("CREATE TABLE POZNAMKY"
                        + "	(ID INT NOT NULL GENERATED ALWAYS AS IDENTITY,"
                        + "	DATUM DATE,"
                        + "	TEXT VARCHAR(100))");
            }
            psCreate = conn.prepareStatement("INSERT INTO POZNAMKY VALUES(DEFAULT, ?, ?)");
            psGetAll = conn.prepareStatement("SELECT * FROM POZNAMKY");

        } catch (SQLException ex) {
            Logger.getLogger(PoznamkaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void create(String text) throws SQLException {
        psCreate.setDate(1, new java.sql.Date(new java.util.Date().getTime()));
        psCreate.setString(2, text);
        psCreate.execute();
    }

   public Collection<Poznamka> getALL() throws SQLException {
        ResultSet rs = psGetAll.executeQuery();
        Collection<Poznamka> poznamky = new ArrayList<>();
        while (rs.next()) {
            int id = rs.getInt(1);
            Date d = rs.getDate(2);
            String t = rs.getString(3);
            poznamky.add(new Poznamka(id, d, t));
        }
        return poznamky;

    }
}
