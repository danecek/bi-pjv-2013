/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sockets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author danecek
 */
public class ClientThread extends Thread {

    PrintWriter pw;
    BufferedReader br;
    Socket s;

    public ClientThread(Socket s) {
        this.s = s;
        try {
            InputStream is = s.getInputStream();
            OutputStream os = s.getOutputStream();
            pw = new PrintWriter(new OutputStreamWriter(os, StandardCharsets.UTF_8));
            br = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));
        } catch (IOException ex) {
            Logger.getLogger(ClientThread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void run() {
        try {
            for (;;) {
                try {
                    String request = br.readLine();
                    System.out.println("request:" + request);
                    if (request.equalsIgnoreCase("KONEC"))
                        break;
//                    String[] as = request.split(" ");
                    Scanner reqSc = new Scanner(request);
                    int sum = 0;
                    while (reqSc.hasNextInt()) {
                        sum+= reqSc.nextInt();
                    }
                    
//                    pw.println("request: " + request + " came at:" + new Date());
                    pw.printf("%d\n", sum);
                    pw.flush();
                } catch (IOException ex) {
                    Logger.getLogger(ClientThread.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            pw.close();
            br.close();
            s.close();
        } catch (IOException ex) {
            Logger.getLogger(ClientThread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
