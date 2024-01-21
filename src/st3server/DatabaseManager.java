/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package st3server;

import java.util.ArrayList;
import java.sql.*;
/**
 *
 * @author Simphiwe-2021
 */
public class DatabaseManager implements Databaseint {
    Connection conn;

    public DatabaseManager() throws SQLException {
        conn = DriverManager.getConnection("jdbc:derby://localhost:1527/MamazalaDB", "app", "123");
    }

    @Override
    public void add(Item t) throws SQLException {
      String sql = "INSERT INTO STOCKTBL (Description,quantity,price) VALUES (?,?,?)";
      PreparedStatement ps = conn.prepareStatement(sql);
      ps.setString(1, t.getDescription());
     
      ps.setInt(2, t.getQuantity());
      ps.setDouble(3, t.getPrice());
      ps.executeUpdate();
      ps.close();
    }

    @Override
    public void update(String id, Double price) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String get(String id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(String id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList getAll() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int count() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

 
    
    

   
    
}
