/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package st3server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Simphiwe-2021
 */
public class MyThread implements Runnable{
    Socket socket;
    PrintWriter out;
    BufferedReader in;
    String recieved,description,op;
    Integer quantity;
    Double price;

    public MyThread(Socket socket) throws IOException {
        this.socket = socket;
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())),true);
        run();
    }

    @Override
    public void run() {
        try {
            recieved = in.readLine();
            DatabaseManager dm = new DatabaseManager();
            
            while (!recieved.equalsIgnoreCase("stop")) {                
            String[] token = recieved.split("#");
            op = token[0];
            description = token[1];
            quantity = Integer.valueOf(token[2]);
            price = Double.valueOf(token[3]);
            
            Item item = new Item(description, quantity, price);
            
            if (op.equalsIgnoreCase("adding")) {
                //pass object to method that adds to database
                dm.add(item);
                out.print("itme added on db");
            }
            else if (op.equalsIgnoreCase("update")) {
               //pass value to method for updating 
            }
            else if (op.equalsIgnoreCase("Select")) {
               //pass value to method for selecting 
            }
            else if (op.equalsIgnoreCase("remove")) {
               //pass value to method for remove 
            }
            else if (op.equalsIgnoreCase("displayAll")) {
               //pass value to method for displayAll 
            }
            }
        } catch (IOException ex) {
            Logger.getLogger(MyThread.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(MyThread.class.getName()).log(Level.SEVERE, null, ex);
        }finally
        {
            try {
                socket.close();
            } catch (IOException ex) {
                Logger.getLogger(MyThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    
    
    
}
