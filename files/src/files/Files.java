/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package files;

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
        admp(new File(dir));
    }
    
    static void admp(File file) {
        System.out.println(file);
        if (file.isFile()) return;
        File[] fs = file.listFiles();
        for (File f : fs) {
           admp(f); 
        }
    }
}
