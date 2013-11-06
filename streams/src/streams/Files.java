/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package streams;

import java.io.File;

/**
 *
 * @author danecek
 */
public class Files {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        dmp(".");

        // TODO code application logic here
    }

    static void dmp(String dir) {
        admp(new File(dir), 1);
    }

    static void admp(File file, int indent) {
        System.out.printf("%" + indent + "c%s\n", ' ', file);
        if (file.isFile()) {
            return;
        }
        File[] fs = file.listFiles();
        for (File f : fs) {
            admp(f, indent + 3);
        }
    }
}
