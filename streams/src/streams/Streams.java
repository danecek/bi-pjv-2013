/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package streams;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

/**
 *
 * @author danecek
 */
public class Streams {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        FileOutputStream fos =
                new FileOutputStream("/home/classroom/user/danecek/NetBeansProjects/pjv/2013/stream/src/stream/StreamCopy.jv");
        FileInputStream fis =
                new FileInputStream("/home/classroom/user/danecek/NetBeansProjects/pjv/2013/stream/src/stream/Stream.java");
//        for (int b = fis.read(); b >= 0; b = fis.read()) {
//            System.out.println(b);
//            fos.write(b);
//        }
//        fos.close();
        
        // TODO code application logic here
        
        InputStreamReader isr = new InputStreamReader(fis);
        OutputStreamWriter osw = new OutputStreamWriter(fos, "utf-8");
        
//        FileReader fr = new FileReader("/home/classroom/user/danecek/NetBeansProjects/pjv/2013/stream/src/stream/Stream.java");
//        FileWriter fw = new FileWriter("/home/classroom/user/danecek/NetBeansProjects/pjv/2013/stream/src/stream/StreamCopy.java");
        BufferedReader br = new BufferedReader(isr);
        PrintWriter pw = new PrintWriter(osw);
        
        for (String line = br.readLine(); line != null; line = br.readLine()) {
            System.out.println(line);
            pw.println(line);
            
        }
        pw.close();
//        for (int b = fr.read(); b >= 0; b = fr.read()) {
//            System.out.println((char)b);
//        }
    }
}