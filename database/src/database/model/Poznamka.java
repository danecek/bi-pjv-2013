/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package database.model;

import java.sql.Date;

/**
 *
 * @author danecek
 */
public class Poznamka {

    int id;

    public int getId() {
        return id;
    }
    private Date date;
    private String text;

    public Poznamka(int id, Date date, String text) {
        this.id = id;
        this.date = date;
        this.text = text;
    }

    /**
     * @return the date
     */
    public Date getDate() {
        return date;
    }

    /**
     * @return the text
     */
    public String getText() {
        return text;
    }

    @Override
    public String toString() {
        return String.format("%d : %s : %s", id, date.toString(), text);
    }
}
