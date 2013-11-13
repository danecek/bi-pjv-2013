/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sockets;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author danecek
 */
public class ThreadServer {

    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(3333);
            for (;;) {
                Socket s = ss.accept();
                System.out.println("client: " + s);
                new ClientThread(s).start();
            }

            // TODO code application logic here
        } catch (UnknownHostException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
