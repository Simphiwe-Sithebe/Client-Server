/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package st3server;

import java.io.IOException;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Simphiwe-2021
 */
public class ST3Server {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
         ServerSocket s;
         Socket socket;
         
        try {
            s = new ServerSocket(8080);
            System.out.println("waiting for connection");
            while (true) {                
                socket = s.accept();
                System.out.println("connection established on socket:"+ socket);
                new MyThread(socket);
            }
        } catch (IOException ex) {
            Logger.getLogger(ST3Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
