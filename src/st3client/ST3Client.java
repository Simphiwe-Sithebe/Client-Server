/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package st3client;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Simphiwe-2021
 */
public class ST3Client {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        InetAddress adrr;
        Socket socket;
        PrintWriter out;
        BufferedReader in;
        Scanner sc = new Scanner(System.in);
        int op;
        String details,response = null;
        try {
            adrr = InetAddress.getByName("127.0.0.1");
            socket = new Socket(adrr, 8080);
            System.out.println("connection established on socket:"+ socket);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())),true);
            op = menu();
            while (op != 7) {                
                switch (op) {
                    case 1:
                        System.out.println("enter description, quantity, unit price '#'");
                        details = "adding#"+sc.nextLine();
                        out.println(details);
                        response = in.readLine();
                        System.out.println(response);
                        break;
                        
                    case 2: 
                        System.out.println("enter id and new price seperated by a #");
                        details = "update#"+sc.nextLine();
                        response = in.readLine();
                        System.out.println(response);
                        break;
                    case 3:     
                        System.out.println("enter id");
                        details = "Select#"+sc.nextLine();
                        response = in.readLine();
                        System.out.println(response);
                        break;
                    case 4:
                        System.out.println("enter id");
                        details = "remove#"+sc.nextLine();
                        response = in.readLine();
                        System.out.println(response);
                        break;
                    case 5:
                        out.println("displayAll");
                        response += in.readLine()+"\n";
                        System.out.println(response);
                        break;
                    case 6:
                        System.out.println("oops feature not ready yet");
                        break;
                    case 7:
                        out.print("stop");
                        socket.close();
                        System.out.println("connection terminated");
                        System.exit(0);
                    default:
                        throw new AssertionError();
                }
                op = menu();
            }
            
            
            
            
            
            
            
            
            
        } catch (UnknownHostException ex) {
            Logger.getLogger(ST3Client.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ST3Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static int menu(){
        System.out.println("1 – for adding/persisting item information into the database.\n"
                + "2 – for changing the unit price of an item.\n"
                + "3 – for getting the details of a specific item\n"
                + "4 – for removing a specific item from the database\n"
                + "5 – for displaying the details of all the items\n"
                + "6 – for displaying the number of items stored in the database\n"
                + "7 – for exiting the application");
        Scanner sc = new Scanner(System.in);
        int option = sc.nextInt();
        return option;
    }
}
