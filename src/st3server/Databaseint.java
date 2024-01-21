/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package st3server;

import java.util.ArrayList;
import java.sql.*;

/**
 *
 * @author Simphiwe-2021
 */
public interface Databaseint<T> {
    public void add(Item t) throws SQLException;
    public void update(String id,Double price) throws SQLException;
    public String get(String id) throws SQLException;
    public void delete(String id) throws SQLException;
    public ArrayList<Item> getAll() throws SQLException;
    public int count() throws SQLException;
}
